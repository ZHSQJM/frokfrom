package com.util;


import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @project: springboot-mybatis
 * @author: zhs
 * @date: 2019/5/23 10:50
 * @package: tk.mybatis
 * @description: 通用mapper 注意不能被扫描到，否则会出错
 */
public interface MyMapper<T> extends tk.mybatis.mapper.common.Mapper<T>,MySqlMapper<T> {
}
