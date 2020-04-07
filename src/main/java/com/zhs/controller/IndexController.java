package com.zhs.controller;

import com.zhs.service.impl.SummaryService;
import com.zhs.vo.SysMenuVo;
import com.zhs.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 10:49
 * @package: com.zhs.controller
 * @description:
 */

@Controller
@RequestMapping
public class IndexController {


    @Autowired
    private SummaryService summaryService;

    @GetMapping("toLogin")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
       return mv;
    }


    @GetMapping(value = {"index","/"})
    public ModelAndView index(HttpServletRequest request){


        ModelAndView modelAndView = new ModelAndView();
        final Integer users = summaryService.summaryUser();
        final Integer resources = summaryService.summaryResource();
        modelAndView.addObject("users",users);
        modelAndView.addObject("resources",resources);
        modelAndView.addObject("blogs",10);
        modelAndView.addObject("eyes",10000);
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
