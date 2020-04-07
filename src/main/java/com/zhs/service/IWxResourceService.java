package com.zhs.service;

import com.github.pagehelper.PageInfo;
import com.zhs.dto.ResourceDto;
import com.zhs.entity.WxResource;
import com.zhs.entity.WxUser;
import com.zhs.query.ResourceQuery;
import com.zhs.vo.ResourceVo;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:41
 * @package: com.zhs.service
 * @description:
 */
public interface IWxResourceService {
     PageInfo<ResourceVo> list(ResourceQuery resourceQuery, Integer currentPage, Integer pageSize);

     WxResource getOne(String id);

     boolean updateStatus(int status,String id);

     boolean add(ResourceDto resourceDto);
}
