package com.zhs.service.impl;

import com.zhs.entity.WxResource;
import com.zhs.entity.WxUser;
import com.zhs.mapper.WxResourceMapper;
import com.zhs.mapper.WxUserMapper;
import com.zhs.service.IWxUserService;
import com.zhs.vo.SummaryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/27 15:44
 * @package: com.zhs.service.impl
 * @description:
 */
@Service
public class SummaryService {

    @Autowired
    private WxUserMapper wxUserMapper;

    @Autowired
    private WxResourceMapper wxResourceMapper;


    public Integer summaryUser(){
            return wxUserMapper.list(null, null).size();
    }

    public Integer summaryResource(){
        return wxResourceMapper.list(null).size();
    }
}
