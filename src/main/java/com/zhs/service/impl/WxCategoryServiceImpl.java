package com.zhs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhs.entity.Category;
import com.zhs.entity.WxCategory;
import com.zhs.mapper.CategoryMapper;
import com.zhs.mapper.WxCategoryMapper;
import com.zhs.service.ICategoryService;
import com.zhs.service.IWxCategoryService;
import com.zhs.service.IWxSearchService;
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
public class WxCategoryServiceImpl implements IWxCategoryService {


    @Autowired
    private WxCategoryMapper wxCategoryMapper;


    @Override
    public PageInfo<WxCategory> list(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return  new PageInfo(wxCategoryMapper.selectAll());
    }

    @Override
    public List<WxCategory> list() {
        return wxCategoryMapper.selectAll();
    }
}
