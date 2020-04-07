package com.zhs.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_menu")
@Data
public class SysMenu {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;

    private String code;

    private Integer type;

    private String url;

    private String icon;

    private Integer pid;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;


}