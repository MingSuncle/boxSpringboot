package com.example.box.box.dao;

import com.example.box.box.entity.CommandEntity;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommandDao extends MppBaseMapper<CommandEntity> {
    List<CommandEntity> getAll(@Param(value = "currentPage") Integer currentPage, @Param(value="pageSize")Integer pageSize);

    Integer commandNum();

    Integer deleteCommand(Integer commandId);
}
