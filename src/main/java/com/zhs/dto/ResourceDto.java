package com.zhs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/4/3 09:56
 * @package: com.zhs.dto
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDto {

    private Long id;


    private Long categoryType;


    private String description;

    private Integer integral;

    private String name;

    private String openId;

    private String password;

    private String phothUrl;

    private Integer status;

    private String url;

}
