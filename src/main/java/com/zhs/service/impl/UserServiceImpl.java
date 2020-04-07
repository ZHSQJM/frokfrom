package com.zhs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhs.entity.SysUser;
import com.zhs.mapper.SysUserMapper;
import com.zhs.service.IUserService;
import com.zhs.vo.DataInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:42
 * @package: com.zhs.service.impl
 * @description:
 */

@Service
@Slf4j
public class UserServiceImpl implements IUserService {


    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public PageInfo<SysUser> list(SysUser user, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return  new PageInfo(sysUserMapper.select(user));
    }

    @Override
    public boolean delete(String id) {
        sysUserMapper.deleteByPrimaryKey(id);
        return true;
    }
}
