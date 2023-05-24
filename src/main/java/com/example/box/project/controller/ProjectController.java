package com.example.box.project.controller;


import com.example.box.project.entity.ProjectEntity;
import com.example.box.project.service.ProjectService;
import com.example.box.project.service.impl.ProjectServiceImpl;
import com.example.box.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        List<ProjectEntity> result = projectService.getAll(currentPage, pageSize);
        Integer total = projectService.projectNum();
        r.addData("result",result);
        r.addData("total",total);
        return r;
    }
}
