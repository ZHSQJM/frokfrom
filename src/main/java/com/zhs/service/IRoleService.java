package com.zhs.service;

import com.github.pagehelper.PageInfo;
import com.zhs.entity.SysRole;
import com.zhs.entity.SysUser;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:41
 * @package: com.zhs.service
 * @description:
 */
public interface IRoleService {

     PageInfo<SysRole> list( Integer currentPage, Integer pageSize);


     /**
      * 给用户分配权限
      * @param roleId
      * @param roles
      * @return
      */
     boolean allocation(String roleId,String roles);
}
