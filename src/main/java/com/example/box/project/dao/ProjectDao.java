package com.example.box.project.dao;


import com.example.box.project.entity.ProjectEntity;
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
}
