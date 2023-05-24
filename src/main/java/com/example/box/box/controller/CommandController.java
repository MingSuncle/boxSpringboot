package com.example.box.box.controller;


import com.example.box.box.entity.CommandEntity;
import com.example.box.box.service.CommandService;
import com.example.box.utils.R;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "运维命令相关")
@ApiSupport(order = 15)
@RestController
@RequestMapping("/command")
public class CommandController {
    private final CommandService commandService;

    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    @ApiOperation("获取指令")
    @GetMapping("/getAll")
    public R getAll(@RequestParam(value = "current_page")Integer currentPage,
                    @RequestParam(value = "page_size")Integer pageSize){
        R r = R.ok();
        Integer currentPageTemp = (currentPage - 1) * pageSize;
        List<CommandEntity> result = commandService.getAll(currentPageTemp,pageSize);
        Integer total = commandService.commandNum();
        r.addData("result",result);
        r.addData("total",total);
        return r;
    }

    @ApiOperation("新增修改指令")
    @PostMapping("/saveOrUpdateCommand")
    public R newCommand(@RequestBody CommandEntity commandEntity){
        R r = R.ok();
        commandService.saveOrUpdate(commandEntity);
        return r;
    }

    @ApiOperation("删除指令")
    @GetMapping("/deleteCommand")
    public R deleteCommand(@RequestParam(value = "command_id")Integer commandId){
        R r = R.ok();
        commandService.deleteCommand(commandId);
        return r;
    }

}
