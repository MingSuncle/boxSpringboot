package com.example.box.project.service;

import com.example.box.project.entity.ProjectEntity;
import com.github.jeffreyning.mybatisplus.service.IMppService;

import java.util.List;

public interface ProjectService extends IMppService<ProjectEntity> {

    List<ProjectEntity> getAll(Integer currentPage,Integer pageSize);

    Integer projectNum();
}
