package com.zhs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhs.entity.WxSearchRecord;
import com.zhs.mapper.WxExchangeRecordMapper;
import com.zhs.mapper.WxSearchRecordMapper;
import com.zhs.service.IWxExchangerService;
import com.zhs.service.IWxSearchService;
import com.zhs.vo.ExchangeRecordVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:42
 * @package: com.zhs.service.impl
 * @description:
 */

@Service
@Slf4j
public class WxSearchServiceImpl implements IWxSearchService {


    @Autowired
     private WxSearchRecordMapper wxSearchRecordMapper;

    @Override
    public PageInfo<WxSearchRecord> list(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo(wxSearchRecordMapper.list());
    }
}
