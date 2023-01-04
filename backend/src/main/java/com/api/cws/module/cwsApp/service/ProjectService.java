package com.api.cws.module.cwsApp.service;

import com.dgs.dgsframework.types.addProjectInfo;
import com.dgs.dgsframework.types.projectInfo;

import java.util.List;

public interface ProjectService {
    List<projectInfo> getProjectInfo(List<Long> projectKey);
    String setProjectInfo(addProjectInfo addProjectInfo);
}
