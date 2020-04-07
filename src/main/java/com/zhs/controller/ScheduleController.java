package com.zhs.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.util.Result;
import com.zhs.dto.MenuDto;
import com.zhs.dto.ScheduleDto;
import com.zhs.entity.MySchedule;
import com.zhs.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/28 19:56
 * @package: com.zhs.controller
 * @description:
 */
@RequestMapping("schedule")
@Controller
public class ScheduleController {

    @Autowired
    private IScheduleService scheduleService;

    @GetMapping
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/my/day");
        modelAndView.addObject("data",scheduleService.list());
        modelAndView.addObject("title","我的日常");
        return modelAndView;
    }

    @PostMapping
    @ResponseBody
    public Result add(ScheduleDto scheduleDto){
        return Result.success(scheduleService.add(scheduleDto));
    }
}
