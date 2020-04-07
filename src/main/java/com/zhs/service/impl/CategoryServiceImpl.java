package com.zhs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhs.entity.Blog;
import com.zhs.entity.Category;
import com.zhs.mapper.BlogMapper;
import com.zhs.mapper.CategoryMapper;
import com.zhs.service.IBlogService;
import com.zhs.service.ICategoryService;
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
public class CategoryServiceImpl implements ICategoryService {


    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public PageInfo<Category> list(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return  new PageInfo(categoryMapper.selectAll());
    }

    @Override
    public List<Category> list() {
        return categoryMapper.selectAll();
    }
}
