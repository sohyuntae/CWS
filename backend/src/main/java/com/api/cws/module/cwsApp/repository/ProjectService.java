package com.api.cws.module.cwsApp.repository;

import com.dgs.dgsframework.types.addProjectInfo;
import com.dgs.dgsframework.types.projectInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProjectService {
    List<projectInfo> getProjectInfo(List<Long> projectKey);
    String setProjectInfo(addProjectInfo addProjectInfo);
}
