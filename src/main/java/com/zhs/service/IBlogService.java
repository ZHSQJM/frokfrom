package com.zhs.service;

import com.github.pagehelper.PageInfo;
import com.zhs.dto.BlogDto;
import com.zhs.entity.Blog;
import com.zhs.entity.SysUser;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:41
 * @package: com.zhs.service
 * @description:
 */
public interface IBlogService {

     PageInfo<Blog> list(Blog blog, Integer currentPage, Integer pageSize);



     boolean add(BlogDto blogDto);
}
