package com.zhs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "create_time")
    private Date createTime;

    private String title;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "category_id")
    private String categoryId;

    private Integer flag;

    private Integer type;

    /**
     * 概要
     */
    private String synopsis;

    private Integer look;

    private String content;


}