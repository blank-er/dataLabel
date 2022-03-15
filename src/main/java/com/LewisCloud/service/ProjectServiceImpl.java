package com.LewisCloud.service;

import com.LewisCloud.common.constant.ProjectStateConstants;
import com.LewisCloud.common.core.domain.model.CreateProject;
import com.LewisCloud.common.exception.BaseException;
import com.LewisCloud.common.utils.ServletUtils;
import com.LewisCloud.mapper.ProjectMapper;
import com.LewisCloud.mapper.UserMapper;
import com.LewisCloud.pojo.Project;
import com.LewisCloud.pojo.User;
import com.LewisCloud.service.auth.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    TokenService tokenService;

    @Autowired
    @Qualifier("pathService")
    PathService pathService;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    UserMapper userMapper;

    public void setProjectMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public List<Project> getAllProject() {
        List<Project> projects = null;
        try{
            projects = projectMapper.getAllProject();
        }catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
        return projects;
    }

    @Override
    public List<Project> getProjectsByManId(int managerId) {
        List<Project> projects = null;
        try{
            projects = projectMapper.getProjectsByManId(managerId);
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
                ProjectStateConstants.publishing, createProject.getTitle(), createProject.getIntroduction(), 0,
                createProject.getWorkerMaxNum(), photosPath.toString(), annoPath.toString());
        try{
            Files.createDirectories(photosPath);
            Files.createDirectories(annoPath);
            projectMapper.addProject(project);
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void addWorker(int projectId, int workerId) {
        User user = null;
        if (this.getProjectById(projectId) != null && (user = userMapper.getUserById(workerId)) != null) {
            if (Objects.equals(user.getIdentity(), "worker")) {
                projectMapper.addWorker(projectId, workerId);
            }else {
                throw new BaseException("所添加的用户身份不是标注者!");
            }
        }else {
            throw new BaseException("不存在提供的项目id或用户id所对应的项目或用户!");
        }
    }
}
