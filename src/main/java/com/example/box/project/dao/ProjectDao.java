package com.example.box.project.dao;


import com.example.box.project.entity.ProjectEntity;
import com.example.box.project.form.UserForm;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectDao extends MppBaseMapper<ProjectEntity> {

    /**
     * 分页获取所有项目
     * @param currentPage 当前页
     * @param pageSize 每页容量
     * @return 项目实体
     */
    List<ProjectEntity> getAll(@Param(value = "currentPage")Integer currentPage,@Param(value = "pageSize") Integer pageSize);

    /**
     * 项目总数
     * @return 整数
     */
    Integer projectNum();

    /**
     * 返回用户对应的projectId
     * @param userId
     * @return String数组
     * Result type doesn't match for Select id="***“不需要管，插件不智能造成的报错
     */
    String[] getProjectsByUserId(Integer userId);

    /**
     * 返回项目下用户Id
     * @param projectId
     * @return Integer数组
     *
     */
    List<UserForm> getUsersByProject(String projectId);

    /**
     *
     * @param userList 用户列表，整型数组
     * @param projectId 项目ID，String类型
     * @return  返回影响的列数，一般用不到
     */
    Integer setProjectUser(@Param(value = "userList")List<Integer> userList,@Param(value = "projectId")String projectId);

}
