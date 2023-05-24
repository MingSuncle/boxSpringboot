package com.example.box.box.service.impl;

import com.example.box.box.dao.CommandDao;
import com.example.box.box.entity.CommandEntity;
import com.example.box.box.service.CommandService;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderService")
public class CommandServiceImpl extends
        MppServiceImpl<CommandDao, CommandEntity> implements CommandService {

    @Override
    public List<CommandEntity> getAll(Integer currentPage, Integer pageSize) {
        return baseMapper.getAll(currentPage, pageSize);
    }

    @Override
    public Integer commandNum() {
        return baseMapper.commandNum();
    }

    @Override
    public Integer deleteCommand(Integer commandId) {
        return baseMapper.deleteCommand(commandId);
    }


}
