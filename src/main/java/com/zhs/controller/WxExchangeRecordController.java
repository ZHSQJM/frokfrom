package com.zhs.controller;

import com.github.pagehelper.PageInfo;
import com.util.Result;
import com.zhs.entity.WxExchangeRecord;
import com.zhs.query.ResourceQuery;
import com.zhs.service.IWxExchangerService;
import com.zhs.service.IWxResourceService;
import com.zhs.vo.DataInfo;
import com.zhs.vo.ExchangeRecordVo;
import com.zhs.vo.ResourceVo;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("exchange")
public class WxExchangeRecordController {

    @Autowired
    private IWxExchangerService wxExchangerService;

    @GetMapping(value = "record")
    public ModelAndView list( @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSzie, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/centrally/exchange");

        modelAndView.addObject("title","集中地/兑换记录");

        return modelAndView;
    }

//    @ResponseBody
//    @GetMapping(value = "wx-resource/{id}")
//    public Result getOne(@PathVariable("id")String id){
//        return Result.success(wxResourceService.getOne(id));
//    }
//
//    @ResponseBody
//    @PutMapping(value = "wx-resource/updateStatus")
//    public Result updateStatus(int status,String id){
//        return Result.success(wxResourceService.updateStatus(status,id));
//    }

    @ResponseBody
    @GetMapping(value = "wx-exchange-data")
    public DataInfo list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSize){
        final PageInfo<ExchangeRecordVo> list = wxExchangerService.list( page, pageSize);
        DataInfo<ExchangeRecordVo> dataInfo = new DataInfo<>();
        dataInfo.setTotal(list.getTotal());
        dataInfo.setRows(list.getList());
        return dataInfo;
    }
}
