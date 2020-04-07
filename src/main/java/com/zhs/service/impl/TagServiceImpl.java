package com.zhs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhs.entity.Blog;
import com.zhs.entity.Tag;
import com.zhs.mapper.BlogMapper;
import com.zhs.mapper.TagMapper;
import com.zhs.service.IBlogService;
import com.zhs.service.ITagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:42
 * @package: com.zhs.service.impl
 * @description:
 */

@Service
@Slf4j
public class TagServiceImpl implements ITagService {


    @Autowired
    private TagMapper tagMapper;


    @Override
    public PageInfo<Tag> list(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return  new PageInfo(tagMapper.selectAll());
    }
}
