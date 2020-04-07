package com.zhs.service.impl;

import com.zhs.dto.ScheduleDto;
import com.zhs.entity.MySchedule;
import com.zhs.mapper.MyScheduleMapper;
import com.zhs.service.IScheduleService;
import com.zhs.vo.ScheduleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/28 20:08
 * @package: com.zhs.service.impl
 * @description:
 */
@Service
public class ScheduleServiceImpl implements IScheduleService {

    @Autowired
    private MyScheduleMapper myScheduleMapper;
    @Override
    public boolean add(ScheduleDto scheduleDto) {

        MySchedule mySchedule = new MySchedule();
        mySchedule.setTitle(scheduleDto.getTitle());
        mySchedule.setStartTime(scheduleDto.getStart_day() + " "+scheduleDto.getStart_time());
        mySchedule.setEndTime(scheduleDto.getEnd_day()+" "+scheduleDto.getEnd_time());

        mySchedule.setContent(scheduleDto.getRemark());
        mySchedule.setCreatetime(new Date());
        mySchedule.setUpdatetime(new Date());
        mySchedule.setColor(scheduleDto.getEvent_bg());
        myScheduleMapper.insert(mySchedule);
        return true;
    }

    @Override
    public List<ScheduleVo> list() {
        return myScheduleMapper.list();
    }


}
