package com.zhs.controller;

import com.github.pagehelper.PageInfo;
import com.zhs.entity.Blog;
import com.zhs.entity.Category;
import com.zhs.service.IBlogService;
import com.zhs.service.ICategoryService;
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
@RequestMapping("category")
public class CategoryController {


    @Autowired
    private ICategoryService categoryService;


    @GetMapping
    public ModelAndView list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSzie, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        final PageInfo<Category> list = categoryService.list( page, pageSzie);
        modelAndView.setViewName("admin/category/list");
        modelAndView.addObject("data",list);
        modelAndView.addObject("title","博客管理/分类列表");
        return modelAndView;
    }

}
