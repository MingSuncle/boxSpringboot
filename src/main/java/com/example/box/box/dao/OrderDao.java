package com.example.box.box.dao;

import com.example.box.box.entity.OrderEntity;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;

import java.util.List;

public interface OrderDao extends MppBaseMapper<OrderEntity> {
    List<OrderEntity> getAll();
}
