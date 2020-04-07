package com.zhs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhs.entity.SysRole;
import com.zhs.entity.SysUser;
import com.zhs.mapper.SysRoleMapper;
import com.zhs.mapper.SysUserMapper;
import com.zhs.service.IRoleService;
import com.zhs.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:42
 * @package: com.zhs.service.impl
 * @description:
 */

@Service
@Slf4j
public class RoleServiceImpl implements IRoleService {


    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Override
    public PageInfo<SysRole> list( Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return  new PageInfo(sysRoleMapper.selectAll());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean allocation(String roleId, String roles) {
        sysRoleMapper.deleteRolesbyRoleIds(roleId);
        final String[] split = roles.split(",");
        for (String s : split) {
            sysRoleMapper.insertRoleMenu(roleId,s);
        }
        return true;
    }
}
