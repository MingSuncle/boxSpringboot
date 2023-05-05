package com.example.box.box.service.impl;


import com.example.box.box.dao.BoxInformationDao;
import com.example.box.box.entity.BoxInformationEntity;
import com.example.box.box.service.BoxInformationService;
import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BoxInformationService")

public class BoxInformationServiceImpl extends
        MppServiceImpl<BoxInformationDao, BoxInformationEntity> implements BoxInformationService {
    /**
     *
     * @param boxId
     * @return
     */
    @Override
    public Integer boxState(String boxId) {
        BoxInformationEntity box = baseMapper.selectById(boxId);
        if (box == null) {
            //盒子不存在返回0
            return 0;
        } else {
            if (box.getBoxState() == 0) {
                //盒子未激活
                return 1;
            } else {
                //其他情况
                return 2;
            }

        }

    }

    @Override
    public List<BoxInformationEntity> getAll(Integer currentPage,Integer pageSize) {
        return baseMapper.getAll(currentPage,pageSize);
    }

    @Override
    public Integer boxNum() {
        return baseMapper.boxNum();
    }



}