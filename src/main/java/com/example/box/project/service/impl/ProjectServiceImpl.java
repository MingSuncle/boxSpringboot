package com.example.box.project.service.impl;


import com.example.box.project.dao.ProjectDao;
import com.example.box.project.entity.ProjectEntity;
import com.example.box.project.form.UserForm;
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

    @Override
    public String[] getProjectsByUserId(Integer userId) {
        return baseMapper.getProjectsByUserId(userId);
    }

    @Override
    public List<UserForm> getUsersByProjectId(String projectId) {
        return baseMapper.getUsersByProject(projectId);
    }

    @Override
    public Integer setProjectUser(List<Integer> userList, String projectId) {
        return baseMapper.setProjectUser(userList, projectId);
    }
}
