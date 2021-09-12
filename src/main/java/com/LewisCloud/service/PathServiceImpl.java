package com.LewisCloud.service;

import com.LewisCloud.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("pathService")
public class PathServiceImpl implements PathService{

    @Value("${file.upload.url}")
    String originalPath;

    @Autowired
    ProjectMapper projectMapper;


    @Override
    public String getOriginalPath() {
        return originalPath;
    }

    @Override
    public String allocatePath() {
        String addPath = String.format("%1$-11x", System.currentTimeMillis());
        return originalPath + "/project" + addPath;
    }

    @Override
    public String getPhotosPath(int projectId) {
        return projectMapper.getProjectById(projectId).getPhotosPath();
    }

    @Override
    public String getCocoPath(int projectId) {
        return projectMapper.getProjectById(projectId).getCocoPath();
    }
}
