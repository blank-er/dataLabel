package com.LewisCloud.mapper;
import com.LewisCloud.pojo.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper {
    List<Project> getAllProject();
    Project getProjectById(@Param("id")int id);
    void addProject(@Param("project")Project project);
}
