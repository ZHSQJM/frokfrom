package com.zhs.mapper;

import com.util.MyMapper;
import com.zhs.entity.MySchedule;
import com.zhs.vo.ScheduleVo;

import java.util.List;

public interface MyScheduleMapper extends MyMapper<MySchedule> {


    List<ScheduleVo> list();
}