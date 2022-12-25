package com.api.cws.module.cwsApp.repository;

import com.dgs.dgsframework.types.addProjectInfo;
import com.dgs.dgsframework.types.projectInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService {
    @Override
    public List<projectInfo> getProjectInfo(List<Long> projectKey) {
        return Collections.emptyList();
    }

    @Override
    public String setProjectInfo(addProjectInfo addProjectInfo) {
        return "성공";
    }
}
