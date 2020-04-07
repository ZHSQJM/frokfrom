package com.zhs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhs.entity.WxSignRecords;
import com.zhs.entity.WxUser;
import com.zhs.mapper.WxSignRecordsMapper;
import com.zhs.mapper.WxUserMapper;
import com.zhs.service.IWxSignRecordsService;
import com.zhs.service.IWxUserService;
import com.zhs.vo.SignRecordsVo;
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
public class WxSignRecordsServiceImpl implements IWxSignRecordsService {


    @Autowired
    private WxSignRecordsMapper wxSignRecordsMapper;

    @Override
    public  PageInfo<SignRecordsVo>  list(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
       return new PageInfo(wxSignRecordsMapper.list());
    }
}
