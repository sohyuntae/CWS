package com.api.cws.module.cwsApp.repository;

import com.api.cws.domain.Qfile_info;
import com.api.cws.domain.Qprjct_info;
import com.api.cws.domain.file_info;
import com.api.cws.domain.prjct_info;
import com.api.cws.module.user.service.userService;
import com.dgs.dgsframework.types.UserInfo;
import com.dgs.dgsframework.types.addProjectInfo;
import com.dgs.dgsframework.types.fileInfo;
import com.dgs.dgsframework.types.projectInfo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    @Override
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
    public String setProjectInfo(addProjectInfo addProjectInfo) {
        return "성공";
    }
}
