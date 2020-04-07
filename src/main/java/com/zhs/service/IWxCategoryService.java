package com.zhs.service;

import com.github.pagehelper.PageInfo;
import com.zhs.entity.Category;
import com.zhs.entity.WxCategory;

import java.util.List;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:41
 * @package: com.zhs.service
 * @description:
 */
public interface IWxCategoryService {

     PageInfo<WxCategory> list(Integer currentPage, Integer pageSize);

     List<WxCategory> list();
}
