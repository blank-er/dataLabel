package com.LewisCloud.controller;

import com.LewisCloud.common.UserThreadLocal;
import com.LewisCloud.common.core.domain.AjaxResult;
import com.LewisCloud.common.core.domain.model.AddWorker;
import com.LewisCloud.common.core.domain.model.CreateProject;
import com.LewisCloud.pojo.Project;
import com.LewisCloud.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    @Qualifier("projectService")
    private ProjectService projectService;

    @GetMapping("/project")
    public AjaxResult getAllProject() {
        List<Project> projects = projectService.getAllProject();
        System.out.println(UserThreadLocal.get());
        return AjaxResult.success("获取所有项目成功", projects);
    }

    @GetMapping("/project/{id}")
    public AjaxResult getProjectById(@PathVariable("id")int id) {
        Project project = projectService.getProjectById(id);
        if (project == null) {
            return AjaxResult.error("未找到" + id + "对应的项目");
        }else {
            return AjaxResult.success("找到" + id + "对应的项目", project);
        }
    }

    @GetMapping("/project/manager/{managerId}")
    public AjaxResult getProjectByManId(@PathVariable("managerId")int managerId) {
        List<Project> projects = projectService.getProjectsByManId(managerId);
        if (projects == null) {
            return AjaxResult.error("未找到" + managerId + "对应的项目");
        }else {
            return AjaxResult.success("找到" + managerId + "对应的项目", projects);
        }
    }

    @PostMapping("/project/create")
    public AjaxResult createProject(@RequestBody CreateProject createProject) {
        projectService.createProject(createProject);
        return AjaxResult.success("创建项目成功");
    }

    @PostMapping("/project/addWorker")
    public AjaxResult addWorker(@RequestBody AddWorker addWorker) {
//        System.out.println(UserThreadLocal.get());
//        int workerId = UserThreadLocal.get().getId();
        projectService.addWorker(addWorker.getProjectId(), addWorker.getWorkerId());
        return AjaxResult.success("添加成员成功");
    }
}