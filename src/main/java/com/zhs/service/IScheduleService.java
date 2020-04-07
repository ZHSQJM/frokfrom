package com.zhs.service;

import com.zhs.dto.ScheduleDto;
import com.zhs.entity.MySchedule;
import com.zhs.vo.ScheduleVo;

import java.util.List;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/28 20:08
 * @package: com.zhs.service
 * @description:
 */

public interface IScheduleService {

    boolean add(ScheduleDto scheduleDto);


    List<ScheduleVo> list();
}
