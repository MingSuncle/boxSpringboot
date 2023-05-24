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
@TableName("command")

public class CommandEntity implements Serializable {
    private  static final long serialVersionUID = 1L;

    @TableId(value = "command_id",type = IdType.AUTO)
    private Integer commandId;

    @TableField(value = "command_name")
    private String commandName;

    @TableField(value = "command_description")
    private String commandDescription;

    @TableField(value = "command_details")
    private String commandDetails;

    @TableField(value = "command_create_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commandCreateTime;

    @TableField(value = "command_creator")
    private String commandCreator;

    @TableField(exist = false)
    private String commandCreatorName;
}
