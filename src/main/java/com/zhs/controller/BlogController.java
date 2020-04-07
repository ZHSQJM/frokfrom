package com.zhs.controller;

import com.github.pagehelper.PageInfo;
import com.zhs.entity.Blog;
import com.zhs.entity.Category;
import com.zhs.entity.SysUser;
import com.zhs.service.IBlogService;
import com.zhs.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/30 09:46
 * @package: com.zhs.controller
 * @description:
 */

@Controller
@RequestMapping("blog")
public class BlogController {


    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;


    @GetMapping
    public ModelAndView list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSzie, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        final PageInfo<Blog> list = blogService.list(null, page, pageSzie);
        modelAndView.setViewName("admin/blog/list");
        modelAndView.addObject("data",list);
        modelAndView.addObject("title","博客管理/文章列表");
        return modelAndView;
    }
    @GetMapping("edit")
    public ModelAndView toEdit(){
        final List<Category> list = categoryService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/blog/edit");
        modelAndView.addObject("categorys",list);
        return modelAndView;
    }
}
