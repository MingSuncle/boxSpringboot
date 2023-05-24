package com.example.box.box.service;

import com.example.box.box.entity.CommandEntity;
import com.github.jeffreyning.mybatisplus.service.IMppService;

import java.util.List;

public interface CommandService extends IMppService<CommandEntity> {
    List<CommandEntity> getAll(Integer currentPage, Integer pageSize);

    Integer commandNum();

    Integer deleteCommand(Integer commandId);
}
