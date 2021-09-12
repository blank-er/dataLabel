package com.LewisCloud.service;

import com.LewisCloud.common.constant.ProjectStateConstants;
import com.LewisCloud.common.core.domain.model.CreateProject;
import com.LewisCloud.common.exception.BaseException;
import com.LewisCloud.common.utils.ServletUtils;
import com.LewisCloud.controller.ProjectController;
import com.LewisCloud.mapper.ProjectMapper;
import com.LewisCloud.pojo.Project;
import com.LewisCloud.pojo.User;
import com.LewisCloud.service.auth.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    TokenService tokenService;

    @Autowired
    @Qualifier("pathService")
    PathService pathService;

    @Autowired
    ProjectMapper projectMapper;

    public void setProjectMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public List<Project> getAllProject() {
        LinkedList<Project> projects = null;
        try{
            projects = (LinkedList<Project>) projectMapper.getAllProject();
        }catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
        return projects;
    }

    @Override
    public Project getProjectById(int id) {
        Project project = null;
        try{
            project = projectMapper.getProjectById(id);
        }catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
        return project;
    }

    @Override
    @Transactional
    public void createProject(CreateProject createProject) {
        String allocatedPath = pathService.allocatePath();
        Path photosPath = Paths.get(allocatedPath, "./photos").normalize().toAbsolutePath();
        Path annoPath = Paths.get(allocatedPath, "./annotations").normalize().toAbsolutePath();

        System.out.println(photosPath);

        Project project = new Project(0, tokenService.getLoginUser(ServletUtils.getRequest()), null,
                ProjectStateConstants.publishing, createProject.getTitle(), createProject.getIntroduction(),
                createProject.getWorkerMaxNum(), photosPath.toString(), photosPath.toString());
        try{
            Files.createDirectories(photosPath);
            Files.createDirectories(annoPath);
            projectMapper.addProject(project);
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
    }
}
