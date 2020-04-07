package com.zhs.controller;

import com.github.pagehelper.PageInfo;
import com.zhs.entity.Category;
import com.zhs.entity.WxCategory;
import com.zhs.service.ICategoryService;
import com.zhs.service.IWxCategoryService;
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
@RequestMapping("centrally")
public class WxCategoryController {


    @Autowired
    private IWxCategoryService wxCategoryService;


    @GetMapping("/category")
    public ModelAndView list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSzie, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        final PageInfo<WxCategory> list = wxCategoryService.list( page, pageSzie);
        modelAndView.setViewName("admin/centrally/category");
        modelAndView.addObject("data",list);
        modelAndView.addObject("title","集中地/分类列表");
        return modelAndView;
    }

}
