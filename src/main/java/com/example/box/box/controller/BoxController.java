package com.example.box.box.controller;


import com.example.box.box.entity.BoxInformationEntity;
import com.example.box.box.service.BoxInformationService;
import com.example.box.box.service.EventService;
import com.example.box.utils.R;
import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "盒子相关")
@ApiSupport(order = 20)
@RestController
@RequestMapping("/box")
@EnableMPP

public class BoxController {
    private final BoxInformationService boxInformationService;
    private final EventService eventService;

    public BoxController(BoxInformationService boxInformationService, EventService eventService) {
        this.boxInformationService = boxInformationService;
        this.eventService = eventService;
    }

    @ApiOperation("获取全部盒子")
    @GetMapping("/getBox")
    public R getBox(@RequestParam(value = "current_page")Integer currentPage,
                    @RequestParam(value = "page_size")Integer pageSize){
//      前端传回的currentPage需要做处理才能作为数据库的limit参数
        Integer currentPageTemp = (currentPage - 1) * pageSize;
        Integer boxNum = boxInformationService.boxNum();
        List<BoxInformationEntity> result = boxInformationService.getAll(currentPageTemp,pageSize);
        R r =R.ok();
        r.addData("result",result);
        r.addData("total",boxNum);
        return r;
    }

    @ApiOperation("获取事件Map")
    @GetMapping("/getEvent")
    public R getEvent(){
        R r = R.ok();
        Map<Integer,String> result= eventService.getEvent();
        r.addData("result",result);
        return r;
    }

    @ApiOperation("新增盒子")
    @PostMapping("/addBox")
    public R addBox(@RequestBody BoxInformationEntity boxInformation){
        R r = R.ok();
        Integer state = boxInformationService.boxState(boxInformation.getBoxId());
        if(state==0)
        {
            boxInformationService.saveOrUpdate(boxInformation);
            return r;
        }
        else{

            return R.error(300,"已存在");
        }

    }

    @ApiOperation("删除盒子")
    @GetMapping("/deleteBox")
    public R deleteBox(@RequestParam(value = "box_id")String boxId){
        R r = R.ok();
        boxInformationService.removeById(boxId);
        return r;
    }

    @ApiOperation("修改盒子配置")
    @PostMapping("/editBox")
    public R editBox(@RequestBody BoxInformationEntity boxInformation){
        R r = R.ok();
        boxInformationService.saveOrUpdate(boxInformation);
        return r;
    }
}
