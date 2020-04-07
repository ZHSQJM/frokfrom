package com.zhs.controller;

import com.github.pagehelper.PageInfo;
import com.util.Result;
import com.zhs.dto.ResourceDto;
import com.zhs.entity.WxCategory;
import com.zhs.entity.WxUser;
import com.zhs.query.ResourceQuery;
import com.zhs.service.IWxCategoryService;
import com.zhs.service.IWxResourceService;
import com.zhs.service.IWxUserService;
import com.zhs.vo.DataInfo;
import com.zhs.vo.ResourceVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
public class WxResourceController {

    @Autowired
    private IWxResourceService wxResourceService;
    @Autowired
    private IWxCategoryService wxCategoryService;

    @GetMapping(value = "wx-resource")
    public ModelAndView list(ResourceQuery resourceQuery){
        ModelAndView modelAndView = new ModelAndView();
        final List<WxCategory> list = wxCategoryService.list();
        modelAndView.setViewName("admin/centrally/resource");
        modelAndView.addObject("categorys",list);
        modelAndView.addObject("title","集中地/资源列表");
        modelAndView.addObject("query",resourceQuery);
        return modelAndView;
    }

    @ResponseBody
    @PostMapping("resource")
    public Result add(ResourceDto resourceDto){
        return Result.success(wxResourceService.add(resourceDto));
    }
    @ResponseBody
    @GetMapping(value = "wx-resource/{id}")
    public Result getOne(@PathVariable("id")String id){
        return Result.success(wxResourceService.getOne(id));
    }

    @ResponseBody
    @PutMapping(value = "wx-resource/updateStatus")
    public Result updateStatus(int status,String id){
        return Result.success(wxResourceService.updateStatus(status,id));
    }

    @ResponseBody
    @GetMapping(value = "wx-resource-data")
    public DataInfo list(ResourceQuery resourceQuery, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize){
        final PageInfo<ResourceVo> list = wxResourceService.list(resourceQuery, page, pageSize);
        DataInfo<ResourceVo> dataInfo = new DataInfo<>();
        dataInfo.setTotal(list.getTotal());
        dataInfo.setRows(list.getList());
        return dataInfo;
    }
}
