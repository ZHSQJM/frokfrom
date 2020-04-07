package com.zhs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Table(name = "wx_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxUser {
    @Column(name = "open_id")
    private String openId;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "create_time")
    private Date createTime;

    private Integer gender;

    private Integer integral;

    @Column(name = "nick_name")
    private String nickName;

    private String province;

    @Column(name = "recently_time")
    private Date recentlyTime;


}