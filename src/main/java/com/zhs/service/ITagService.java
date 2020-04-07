package com.zhs.service;

import com.github.pagehelper.PageInfo;
import com.zhs.entity.Blog;
import com.zhs.entity.Tag;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:41
 * @package: com.zhs.service
 * @description:
 */
public interface ITagService {
     PageInfo<Tag> list(Integer currentPage, Integer pageSize);
}
