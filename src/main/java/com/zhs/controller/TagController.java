package com.zhs.controller;

import com.github.pagehelper.PageInfo;
import com.zhs.entity.Blog;
import com.zhs.entity.Tag;
import com.zhs.service.IBlogService;
import com.zhs.service.ITagService;
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
 * @date: 2020/3/30 09:46
 * @package: com.zhs.controller
 * @description:
 */

@Controller
@RequestMapping("tag")
public class TagController {


    @Autowired
    private ITagService tagService;


    @GetMapping
    public ModelAndView list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSzie, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        final PageInfo<Tag> list = tagService.list( page, pageSzie);
        modelAndView.setViewName("admin/tag/list");
        modelAndView.addObject("data",list);
        modelAndView.addObject("title","博客管理/标签列表");
        return modelAndView;
    }
    @GetMapping("edit")
    public ModelAndView toEdit(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/blog/edit");
        return modelAndView;
    }
}
