package com.example.box.box.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import java.io.Serializable;

@Data
@TableName("aievent")

public class EventEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "AIevent_id", type = IdType.AUTO)
    private Integer AIeventId;

    @TableField(value = "AIevent_name")
    private String AIeventName;

    @TableField(value = "AIevent_description")
    private String AIeventDescription;
}
