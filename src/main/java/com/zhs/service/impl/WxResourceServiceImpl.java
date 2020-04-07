package com.zhs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhs.dto.ResourceDto;
import com.zhs.entity.WxResource;
import com.zhs.entity.WxUser;
import com.zhs.mapper.WxResourceMapper;
import com.zhs.mapper.WxUserMapper;
import com.zhs.query.ResourceQuery;
import com.zhs.service.IWxResourceService;
import com.zhs.service.IWxUserService;
import com.zhs.vo.ResourceVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:42
 * @package: com.zhs.service.impl
 * @description:
 */

@Service
@Slf4j
public class WxResourceServiceImpl implements IWxResourceService {


    @Autowired
    private WxResourceMapper wxResourceMapper;


    @Override
    public  PageInfo<ResourceVo>  list(ResourceQuery resourceQuery, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);

       return new PageInfo(wxResourceMapper.list(resourceQuery));
    }

    @Override
    public WxResource getOne(String id) {
        return wxResourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateStatus(int status, String id) {
        wxResourceMapper.updateStatus(status,id);
        return true;
    }

    @Override
    public boolean add(ResourceDto resourceDto) {
        WxResource wxResource = new WxResource();

        BeanUtils.copyProperties(resourceDto,wxResource);
        wxResource.setCreateTime(new Date());
        wxResource.setUpdateTime(new Date());
        wxResource.setOpenId("111");
        wxResource.setRecords(0);
        wxResourceMapper.insert(wxResource);

        return true;
    }
}
