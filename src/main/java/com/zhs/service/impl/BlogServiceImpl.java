package com.zhs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhs.dto.BlogDto;
import com.zhs.entity.Blog;
import com.zhs.entity.SysUser;
import com.zhs.mapper.BlogMapper;
import com.zhs.mapper.SysUserMapper;
import com.zhs.service.IBlogService;
import com.zhs.service.IUserService;
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
public class BlogServiceImpl implements IBlogService {


    @Autowired
    private BlogMapper blogMapper;


    @Override
    public PageInfo<Blog> list(Blog blog, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        return  new PageInfo(blogMapper.select(blog));
    }

    @Override
    public boolean add(BlogDto blogDto) {
        return false;
    }
}
