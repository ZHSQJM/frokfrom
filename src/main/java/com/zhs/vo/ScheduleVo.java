package com.zhs.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/28 20:29
 * @package: com.zhs.vo
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleVo {

    private Integer id;

    private String title;

    private String start;

    private String end;

    private String className;

    private String remark;

}
