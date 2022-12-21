package com.api.cws.module.cwsApp.repository;

import com.api.cws.domain.Qprjct_list;
import com.api.cws.domain.prjct_list;
import com.dgs.dgsframework.types.addProjectInfo;
import com.dgs.dgsframework.types.projectInfo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<projectInfo> getProjectInfo(List<Long> projectKey) {

        List<prjct_list> projectList = queryFactory
                .select(Qprjct_list.prjct_list)
                .from(Qprjct_list.prjct_list)
                .where(Qprjct_list.prjct_list.plKey.in(projectKey))
                .fetch();

        return Collections.emptyList();
    }

    @Override
    public String setProjectInfo(addProjectInfo addProjectInfo) {
        return "성공";
    }
}
