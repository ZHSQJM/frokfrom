package com.zhs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_role")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysRole {

    @Column(name = "id")
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "role_desc")
    private String description;

    @Column(name = "update_time")
    private Date updateTime;


}