package com.zhs.service;

import com.zhs.entity.QuartzEntity;

import java.util.List;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/16 10:23
 * @package: com.zhs.service
 * @description:
 */
public interface IJobService {


    //下载
    List<QuartzEntity> listQuartzEntity();

    Long listQuartzEntityOne();
}
