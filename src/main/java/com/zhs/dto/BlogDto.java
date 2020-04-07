package com.zhs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import java.util.List;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/4/6 21:51
 * @package: com.zhs.dto
 * @description:
 */
@Data
@AllArgsConstructor
public class BlogDto {
    private String id;

    private String title;

    private String categoryId;

    private Integer flag;

    private Integer type;
    /**
     * 概要
     */
    private String synopsis;

    private String content;


    private List<String> tags;

}
