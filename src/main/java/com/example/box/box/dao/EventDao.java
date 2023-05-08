package com.example.box.box.dao;

import com.example.box.box.entity.EventEntity;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.awt.*;
import java.util.List;

@Mapper
public interface EventDao extends MppBaseMapper<EventEntity> {
    /**
     * 获取盒子全部信息存入
     */
    List<EventEntity> getAll();

    List<EventEntity> getEvent(@Param(value = "currentPage") Integer currentPage, @Param(value="pageSize")Integer pageSize);

    Integer eventNum();

    Integer deleteEvent(Integer eventId);
}
