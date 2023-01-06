package com.api.cws.module.cwsApp.query;

import com.api.cws.module.cwsApp.service.*;
import com.dgs.dgsframework.types.addProjectInfo;
import com.dgs.dgsframework.types.projectInfo;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class projectQuery {
    private final ProjectService projectService;

    @DgsQuery
    @Transactional(readOnly = true)
    public List<projectInfo> getProjectInfo(@InputArgument List<Long> projectKey) {
        return projectService.getProjectInfo(projectKey);
    }

    @DgsMutation
    @Transactional
    public String setProjectInfo(@InputArgument addProjectInfo addProjectInfo) {
        return projectService.setProjectInfo(addProjectInfo);
    }
}
