package com.example.box.box.dao;



import com.example.box.box.entity.BoxInformationEntity;
import com.example.box.box.form.BoxModelForm;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoxInformationDao extends MppBaseMapper<BoxInformationEntity> {


    /**
     * 激活盒子
     *
     * @return null
     */
    Boolean activateBox(String boxId);


    /**
     * 查看所有盒子信息(管理员用)
     *
     * @return null
     */
    List<BoxInformationEntity> getAll(@Param(value = "currentPage") Integer currentPage,@Param(value="pageSize")Integer pageSize);


    /**
     *
     */


    /**
     * 查看盒子数量
     *
     * @return null
     */
    Integer boxNum();

    /***
     * 获取盒子对应模型消息(目前仅考虑一个盒子搭载一个模型),模型备注、版本信息为数据库中盒子对应当前版本模型信息
     * @param boxId
     * @return BoxModelForm
     */
    BoxModelForm getBoxModelInformation(String boxId);
}
