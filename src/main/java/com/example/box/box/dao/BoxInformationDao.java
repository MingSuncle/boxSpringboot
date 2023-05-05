package com.example.box.box.dao;



import com.example.box.box.entity.BoxInformationEntity;
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


}
