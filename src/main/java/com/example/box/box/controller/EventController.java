package com.example.box.box.controller;


import com.example.box.box.entity.EventEntity;
import com.example.box.box.service.EventService;
import com.example.box.utils.R;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "事件相关")
@ApiSupport(order = 20)
@RestController
@RequestMapping("/event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @ApiOperation("获取事件")
    @GetMapping("/getAll")
    public R getAll(@RequestParam(value = "current_page")Integer currentPage,
                    @RequestParam(value = "page_size")Integer pageSize
                    ){
        R r = R.ok();
        Integer currentPageTemp = (currentPage - 1) * pageSize;
        List<EventEntity> result = eventService.getEvent(currentPageTemp,pageSize);
        r.addData("result",result);
        return r;
    }
}
