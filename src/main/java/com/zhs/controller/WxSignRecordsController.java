package com.zhs.controller;

import com.github.pagehelper.PageInfo;
import com.zhs.entity.WxUser;
import com.zhs.service.IWxSignRecordsService;
import com.zhs.service.IWxUserService;
import com.zhs.vo.SignRecordsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:45
 * @package: com.zhs.controller
 * @description:
 */
@Controller
@Slf4j
@RequestMapping("centrally")
public class WxSignRecordsController {

    @Autowired
    private IWxSignRecordsService wxSignRecordsService;

    @GetMapping(value = "wx-sign-records")
    public ModelAndView list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSzie,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        final PageInfo<SignRecordsVo> list = wxSignRecordsService.list(page, pageSzie);
        modelAndView.setViewName("admin/centrally/sign-records");
        modelAndView.addObject("data",list);
        modelAndView.addObject("title","集中地/签到记录");
        return modelAndView;
    }
}
