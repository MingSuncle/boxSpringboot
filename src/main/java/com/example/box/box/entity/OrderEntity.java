package com.example.box.box.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("aievent")

public class OrderEntity implements Serializable {
    private  static final long serialVersionUID = 1L;

    @TableId(value = "order_id",type = IdType.AUTO)
    private Integer orderId;

    @TableField(value = "order_name")
    private String orderName;

    @TableField(value = "order_description")
    private String orderDescription;

    @TableField(value = "order_details")
    private String orderDetails;

    @TableField(value = "order_create_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderCreateTime;

    @TableField(value = "order_creator")
    private String orderCreator;
}
