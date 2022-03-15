package com.LewisCloud.service;

import com.LewisCloud.common.core.domain.model.CreateProject;
import com.LewisCloud.pojo.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getAllProject();
    List<Project> getProjectsByManId(int managerId);
    Project getProjectById(int id);
    void createProject(CreateProject createProject);
    void addWorker(int projectId, int workerId);
}
