package com.example.box.project.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("project")
public class ProjectEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "project_id")
    private String projectId;

    @TableField(value = "project_name")
    private String projectName;

    @TableField(value = "project_position")
    private String projectPosition;

    @TableField(value = "project_longitude")
    private String projectLongitude;

    @TableField(value = "project_latitude")
    private String projectLatitude;

    @TableField(value = "project_create_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date projectCreateTime;

}
