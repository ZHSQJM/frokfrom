package com.zhs.service;

import com.github.pagehelper.PageInfo;
import com.zhs.entity.SysUser;
import com.zhs.entity.WxUser;
import com.zhs.vo.DataInfo;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:41
 * @package: com.zhs.service
 * @description:
 */
public interface IWxUserService {
     PageInfo<WxUser> list(String nickName,Integer gender, Integer currentPage, Integer pageSize);
}
