package com.LewisCloud.mapper;
import com.LewisCloud.pojo.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper {
    List<Project> getAllProject();
    Project getProjectById(@Param("id")int id);
    List<Project> getProjectsByManId(@Param("managerId")int managerId);
    void addProject(@Param("project")Project project);
    void addWorker(@Param("projectId")int projectId, @Param("workerId")int workerId);
}