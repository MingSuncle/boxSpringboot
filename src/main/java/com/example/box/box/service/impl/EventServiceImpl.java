package com.example.box.box.service.impl;


import com.example.box.box.dao.EventDao;
import com.example.box.box.entity.EventEntity;
import com.example.box.box.service.EventService;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("EventService")
public class EventServiceImpl extends
        MppServiceImpl<EventDao, EventEntity> implements EventService {
    @Override
    public Map getEvent() {
        List<EventEntity> eventList= baseMapper.getAll();
        Map<Integer,String> result = new HashMap<>();
        for(Integer i=0;i<eventList.size();i++)
        {
            result.put(eventList.get(i).getAIeventId(),eventList.get(i).getAIeventName());
        }
        return result;
    }

    @Override
    public List<EventEntity> getAll() {
        List<EventEntity> result = baseMapper.getAll();
        return result;
    }

    @Override
    public List<EventEntity> getEvent(Integer currentPage, Integer pageSize) {
        return baseMapper.getEvent(currentPage, pageSize);
    }

    @Override
    public Integer eventNum() {
        return baseMapper.eventNum();
    }

}
