package com.zhs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/27 17:54
 * @package: com.zhs.dto
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {

    private Integer id;

    private String name;

    private String code;

    private Integer type;

    private String url;

    private String icon;

    private Integer pid;

}
