package com.zhs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhs.entity.WxExchangeRecord;
import com.zhs.entity.WxResource;
import com.zhs.mapper.WxExchangeRecordMapper;
import com.zhs.mapper.WxResourceMapper;
import com.zhs.query.ResourceQuery;
import com.zhs.service.IWxExchangerService;
import com.zhs.service.IWxResourceService;
import com.zhs.vo.ExchangeRecordVo;
import com.zhs.vo.ResourceVo;
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
public class WxExchangerServiceImpl implements IWxExchangerService {


    @Autowired
     private WxExchangeRecordMapper wxExchangeRecordMapper;

    @Override
    public PageInfo<ExchangeRecordVo> list(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo(wxExchangeRecordMapper.list());
    }
}
