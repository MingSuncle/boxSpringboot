package com.example.box.box.controller;


import com.example.box.box.entity.EventEntity;
import com.example.box.box.service.EventService;
import com.example.box.utils.R;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

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
        Integer total = eventService.eventNum();
        r.addData("result",result);
        r.addData("total",total);
        return r;
    }

    @ApiOperation("新增事件")
    @PostMapping("/addEvent")
    public R addEvent(@RequestBody EventEntity event){
        R r = R.ok();
        eventService.save(event);
        return r;
    }

    @ApiOperation("删除事件")
    @GetMapping("/deleteEvent")
    public R deleteEvent(@RequestParam(value = "event_id")Integer eventId){
        R r = R.ok();
        eventService.delete(eventId);
        return r;
    }

    @ApiOperation("修改事件")
    @PostMapping("/editEvent")
    public R editEvent(@RequestBody EventEntity eventEntity){
        R r = R.ok();
        eventService.updateById(eventEntity);
        return r;
    }
}
