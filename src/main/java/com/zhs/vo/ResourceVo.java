package com.zhs.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/25 15:53
 * @package: com.zhs.vo
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceVo {

    private String id;

    private String name;

    private String nickName;

    private String photoUrl;

    private String url;

    private String password;

    private String typeName;
    private String typeId;

    private Integer integral;
    private int status;
    private int records;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

}
