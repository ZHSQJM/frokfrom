package com.zhs.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/23 17:25
 * @package: com.zhs
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenuVo {
    @JsonProperty("id")
    private Integer id;

    /**权限名称*/
    @JsonProperty("name")
    private String name;

    /**权限图表*/
    @JsonProperty("icon")
    private String icon;

    /**权限码*/

    @JsonProperty("permissionValue")
    private String code;

    /**权限请求地址*/
    @JsonProperty("href")
    private String url;

    /**权限类型 0菜单  1按钮 */
    private Integer type;

    /**上级菜单*/
    @JsonProperty("pid")
    private Integer pid;


    /**权限创建时间*/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**权限更新时间*/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    /**逻辑删除 0 正常使用 1 逻辑删除*/
    private Integer disable;


    @JsonProperty("children")
    private List<SysMenuVo> list;
}
