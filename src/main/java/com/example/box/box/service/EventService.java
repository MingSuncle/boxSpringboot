package com.example.box.box.service;

import com.example.box.box.entity.EventEntity;
import com.github.jeffreyning.mybatisplus.service.IMppService;

import java.util.List;
import java.util.Map;

public interface EventService extends IMppService<EventEntity>{
    Map getEvent();

    List<EventEntity> getAll();

    List<EventEntity> getEvent(Integer currentPage,Integer pageSize);
}
