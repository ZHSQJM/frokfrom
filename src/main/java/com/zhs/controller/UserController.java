package com.zhs.controller;

import com.github.pagehelper.PageInfo;

import com.util.Result;
import com.zhs.entity.SysUser;
import com.zhs.service.IUserService;
import com.zhs.vo.DataInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public ModelAndView list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSzie,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        final PageInfo<SysUser> list = userService.list(null, page, pageSzie);
        modelAndView.setViewName("admin/user/user");
        modelAndView.addObject("data",list);
        modelAndView.addObject("title","系统管理/用户管理");
        return modelAndView;
    }

    @ResponseBody
    @DeleteMapping("{id}")
    public  Result delete(@PathVariable("id")String id){
        return Result.success(userService.delete(id));
    }
}
