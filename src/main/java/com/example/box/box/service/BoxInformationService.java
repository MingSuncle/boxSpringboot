package com.example.box.box.service;


import com.example.box.box.entity.BoxInformationEntity;
import com.example.box.box.form.BoxModelForm;
import com.github.jeffreyning.mybatisplus.service.IMppService;
import io.swagger.models.auth.In;

import java.util.List;

public interface BoxInformationService extends IMppService<BoxInformationEntity> {


    Integer boxState(String boxId);

    List<BoxInformationEntity> getAll(Integer currentPage,Integer pageSize);

    Integer boxNum();

    BoxModelForm getBoxModelInformation(String boxId);
}
