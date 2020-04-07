package com.zhs.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/24 17:12
 * @package: com.zhs.vo
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataInfo<T> {

    private long total;

    private List<T> rows;

}
