package com.LewisCloud.controller;

import com.LewisCloud.common.core.domain.AjaxResult;
import com.LewisCloud.common.core.domain.model.CreateProject;
import com.LewisCloud.pojo.Project;
import com.LewisCloud.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
public class ProjectController {
    @Autowired
    @Qualifier("projectService")
    private ProjectService projectService;

    @GetMapping("/project")
    public AjaxResult getAllProject() {
        LinkedList<Project> projects = (LinkedList<Project>) projectService.getAllProject();
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

    @PostMapping("/project/create")
    public AjaxResult createProject(@RequestBody CreateProject createProject) {

        projectService.createProject(createProject);
        return AjaxResult.success("创建项目成功");
    }

}