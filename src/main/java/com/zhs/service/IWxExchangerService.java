package com.zhs.service;

import com.github.pagehelper.PageInfo;
import com.zhs.entity.WxExchangeRecord;
import com.zhs.entity.WxResource;
import com.zhs.query.ResourceQuery;
import com.zhs.vo.ExchangeRecordVo;
import com.zhs.vo.ResourceVo;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:41
 * @package: com.zhs.service
 * @description:
 */
public interface IWxExchangerService {
     PageInfo<ExchangeRecordVo> list(Integer currentPage, Integer pageSize);


}
