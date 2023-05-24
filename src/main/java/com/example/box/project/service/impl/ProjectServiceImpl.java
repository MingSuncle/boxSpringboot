package com.example.box.project.service.impl;


import com.example.box.project.dao.ProjectDao;
import com.example.box.project.entity.ProjectEntity;
import com.example.box.project.service.ProjectService;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProjectService")
public class ProjectServiceImpl extends
        MppServiceImpl<ProjectDao, ProjectEntity> implements ProjectService {


    @Override
    public List<ProjectEntity> getAll(Integer currentPage, Integer pageSize) {
        return baseMapper.getAll(currentPage, pageSize);
    }

    @Override
    public Integer projectNum() {
        return baseMapper.projectNum();
    }
}
