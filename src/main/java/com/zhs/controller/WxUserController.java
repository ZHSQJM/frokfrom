package com.zhs.controller;

import com.github.pagehelper.PageInfo;
import com.zhs.entity.SysUser;
import com.zhs.entity.WxUser;
import com.zhs.service.IUserService;
import com.zhs.service.IWxUserService;
import com.zhs.vo.DataInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
public class WxUserController {

    @Autowired
    private IWxUserService wxUserService;

    @GetMapping(value = "wx-user")
    public ModelAndView list(String nickName,Integer gender,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSzie,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        final PageInfo<WxUser> list = wxUserService.list(nickName,gender, page, pageSzie);
        modelAndView.setViewName("admin/centrally/user");
        modelAndView.addObject("data",list);
        modelAndView.addObject("title","集中地/授权用户");
        modelAndView.addObject("nickName",nickName);
        modelAndView.addObject("gender",gender);
        return modelAndView;
    }
}
