package com.example.box.project.service;

import com.example.box.project.entity.ProjectEntity;
import com.example.box.project.form.UserForm;
import com.github.jeffreyning.mybatisplus.service.IMppService;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface ProjectService extends IMppService<ProjectEntity> {

    List<ProjectEntity> getAll(Integer currentPage,Integer pageSize);

    Integer projectNum();

    String[] getProjectsByUserId(Integer userId);

    List<UserForm> getUsersByProjectId(String projectId);

    Integer setProjectUser(List<Integer> userList,String projectId);
}
