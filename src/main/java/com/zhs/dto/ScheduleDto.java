package com.zhs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/28 20:12
 * @package: com.zhs.dto
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {

    private String title;

    private String start_day;

    private String start_time;

    private String end_day;

    private String end_time;

    private String remark;

    private String event_bg;
}
