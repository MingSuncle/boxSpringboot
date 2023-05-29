package com.example.box.project.controller;


import com.example.box.project.entity.ProjectEntity;
import com.example.box.project.form.UserForm;
import com.example.box.project.service.ProjectService;
import com.example.box.project.service.impl.ProjectServiceImpl;
import com.example.box.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "项目相关")
@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @ApiOperation("获取项目")
    @GetMapping("/getAll")
    public R getALl(@RequestParam(value = "current_page")Integer currentPage,
                    @RequestParam(value = "page_size")Integer pageSize){
        R r = R.ok();
        //      前端传回的currentPage需要做处理才能作为数据库的limit参数
        Integer currentPageTemp = (currentPage - 1) * pageSize;
        List<ProjectEntity> result = projectService.getAll(currentPageTemp, pageSize);
        Integer total = projectService.projectNum();
        r.addData("result",result);
        r.addData("total",total);
        return r;
    }

    @ApiOperation("增/改项目")
    @PostMapping("/saveOrUpdateProject")
    public R saveOrUpdateProject(@RequestBody ProjectEntity project){
        R r = R.ok();
        projectService.saveOrUpdate(project);
        return r;
    }

    @ApiOperation("获取项目下用户")
    @GetMapping("/getUsersByProjectId")
    public R getProjectsByUserId(@RequestParam(value = "project_id")String projectId){
        R r = R.ok();
        List<UserForm> result = projectService.getUsersByProjectId(projectId);
        r.addData("result",result);
        return r;
    }

    @ApiOperation("更改项目用户")
    @PostMapping("/setProjectUser")
    public R setProjectUser(@RequestParam(value = "user_id") String userId,
                            @RequestParam(value = "project_id")String projectId){
        R r = R.ok();
        List<Integer> userList = Arrays.stream(userId.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        projectService.setProjectUser(userList,projectId);
        return r;
    }
}
