package com.zhs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhs.entity.SysUser;
import com.zhs.entity.WxUser;
import com.zhs.mapper.SysUserMapper;
import com.zhs.mapper.WxUserMapper;
import com.zhs.service.IUserService;
import com.zhs.service.IWxUserService;
import com.zhs.vo.DataInfo;
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
public class WxUserServiceImpl implements IWxUserService {


    @Autowired
    private WxUserMapper wxUserMapper;


    @Override
    public  PageInfo<WxUser>  list(String nickName,Integer gender, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
       return new PageInfo(wxUserMapper.list(nickName,gender));
    }
}
