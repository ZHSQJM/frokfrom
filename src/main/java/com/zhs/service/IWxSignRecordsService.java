package com.zhs.service;

import com.github.pagehelper.PageInfo;
import com.zhs.entity.WxUser;
import com.zhs.vo.SignRecordsVo;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:41
 * @package: com.zhs.service
 * @description:
 */
public interface IWxSignRecordsService {
     PageInfo<SignRecordsVo> list( Integer currentPage, Integer pageSize);
}
