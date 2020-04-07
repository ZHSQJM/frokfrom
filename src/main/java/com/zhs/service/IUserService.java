package com.zhs.service;

import com.github.pagehelper.PageInfo;
import com.zhs.entity.SysUser;
import com.zhs.vo.DataInfo;

import java.util.List;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:41
 * @package: com.zhs.service
 * @description:
 */
public interface IUserService {

     PageInfo<SysUser> list(SysUser user, Integer currentPage, Integer pageSize);

     boolean delete(String id);
}
