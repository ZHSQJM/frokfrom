package com.zhs.controller;

import com.github.pagehelper.PageInfo;
import com.zhs.entity.WxExchangeRecord;
import com.zhs.entity.WxSearchRecord;
import com.zhs.service.IWxExchangerService;
import com.zhs.service.IWxSearchService;
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
@RequestMapping("search")
public class WxSearchRecordController {

    @Autowired
    private IWxSearchService wxSearchService;

    @GetMapping(value = "record")
    public ModelAndView list( @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSzie, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/centrally/search");

        modelAndView.addObject("title","集中地/搜索记录");

        return modelAndView;
    }

    @ResponseBody
    @GetMapping(value = "wx-search-data")
    public DataInfo list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize){
        final PageInfo<WxSearchRecord> list = wxSearchService.list( page, pageSize);
        DataInfo<WxSearchRecord> dataInfo = new DataInfo<>();
        dataInfo.setTotal(list.getTotal());
        dataInfo.setRows(list.getList());
        return dataInfo;
    }
}
