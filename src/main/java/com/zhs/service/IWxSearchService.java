package com.zhs.service;

import com.github.pagehelper.PageInfo;
import com.zhs.entity.WxSearchRecord;
import com.zhs.vo.ExchangeRecordVo;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:41
 * @package: com.zhs.service
 * @description:
 */
public interface IWxSearchService {
     PageInfo<WxSearchRecord> list(Integer currentPage, Integer pageSize);
}
