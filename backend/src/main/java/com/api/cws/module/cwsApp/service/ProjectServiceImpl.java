package com.api.cws.module.cwsApp.service;

import com.api.cws.domain.Qfile_info;
import com.api.cws.domain.Qprjct_info;
import com.api.cws.domain.file_info;
import com.api.cws.domain.prjct_info;
import com.api.cws.module.user.service.userService;
import com.dgs.dgsframework.types.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.api.cws.module.cwsApp.repository.prjctInfoRepository;
import com.api.cws.module.cwsApp.repository.fileInfoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService {
    private final JPAQueryFactory queryFactory;
    private final userService userService;

    private final prjctInfoRepository prjctInfoRepository;
    private final fileInfoRepository fileInfoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<projectInfo> getProjectInfo(List<Long> projectKey) {

        // 추가적으로 조건에 대한 추가 작업 진행 예정
        BooleanBuilder whereOption = new BooleanBuilder();

        if (projectKey.size() > 0) {
            whereOption.and(Qprjct_info.prjct_info.piKey.in(projectKey));
        }

        List<prjct_info> projectList = queryFactory
                .select(Qprjct_info.prjct_info)
                .from(Qprjct_info.prjct_info)
                .where(whereOption)
                .fetch();

        if (projectList == null) {
            return Collections.emptyList();
        }

        List<Long> userIdList = projectList.stream().map(prjct_info::getReqKey).collect(Collectors.toList());
        List<UserInfo> userList = userService.getUserList(userIdList);
        Map<Long, UserInfo> userInfoMap = userList.stream().collect(Collectors.toMap(UserInfo::getUiKey, Function.identity()));

        List<Long> fileKeyList = projectList.stream().map(prjct_info::getFiKey).collect(Collectors.toList());
        List<fileInfo> fileList = queryFactory
                .select(
                        Projections.fields(
                                fileInfo.class,
                                Qfile_info.file_info.piKey.as("projectKey"),
                                Qfile_info.file_info.fiKey.as("fileKey"),
                                Qfile_info.file_info.fiNm.as("fileName"),
                                Qfile_info.file_info.fiPath.as("filePath")
                        )
                )
                .from(Qfile_info.file_info)
                .where(Qfile_info.file_info.fiKey.in(fileKeyList))
                .fetch();

        Map<Long,List<fileInfo>> fileListMap = fileList.stream().collect(Collectors.groupingBy(fileInfo::getProjectKey, Collectors.toList()));

        List<projectInfo> result = new ArrayList<>(projectList.size());

        projectList.forEach(domain -> {
            projectInfo newInfo = new projectInfo();
            newInfo.setProjectKey(domain.getPiKey());
            newInfo.setProjectName(domain.getPiNm());
            newInfo.setPurpose(domain.getPiPurpose());
            newInfo.setEstimation(domain.getPiEstmt());
            newInfo.setDescription(domain.getPiCntnt());
            if(userInfoMap.containsKey(domain.getReqKey())) {
                newInfo.setRequestUserInfo(userInfoMap.get(domain.getReqKey()));
            }
            if(fileListMap.containsKey(domain.getPiKey())) {
                newInfo.setFileList(fileListMap.get(domain.getPiKey()));
            }
            result.add(newInfo);
        });

        return result;
    }

    @Override
    @Transactional
    public String setProjectInfo(addProjectInfo addProjectInfo) {

        Timestamp now = new Timestamp(java.lang.System.currentTimeMillis());

        prjct_info projectInfo = new prjct_info();

        if (addProjectInfo.getProjectKey() != null) {
            projectInfo = prjctInfoRepository.findById(addProjectInfo.getProjectKey()).orElse(new prjct_info());
            projectInfo.setUpdDt(now);
            projectInfo.setUpdKey(addProjectInfo.getRequestUidKey());
        } else {
            projectInfo.setRegDt(now);
            projectInfo.setRegKey(addProjectInfo.getRequestUidKey());
        }

        projectInfo.setPiNm(addProjectInfo.getProjectName());
        projectInfo.setReqKey(addProjectInfo.getRequestUidKey());
        projectInfo.setPiPurpose(addProjectInfo.getPurpose());
        projectInfo.setPiEstmt(addProjectInfo.getEstimation());
        projectInfo.setPiCntnt(addProjectInfo.getDescription());

        prjct_info newProjectInfo = prjctInfoRepository.save(projectInfo);

        setFileList(newProjectInfo.getPiKey(), addProjectInfo.getFileList(),addProjectInfo.getRequestUidKey());

        return "성공";
    }

    public void setFileList(Long piKey, List<addFileInfo> fileList, Long reqUiKey) {

        Timestamp now = new Timestamp(java.lang.System.currentTimeMillis());

        fileList.forEach(info -> {
            file_info newInfo = new file_info();
            newInfo.setFiKey(info.getFileKey());
            newInfo.setPiKey(piKey);
            newInfo.setFiNm(info.getFileName());
            newInfo.setFiPath(info.getFilePath());
            newInfo.setRegDt(now);
            newInfo.setRegKey(reqUiKey);
            fileInfoRepository.save(newInfo);
        });
    }
}
