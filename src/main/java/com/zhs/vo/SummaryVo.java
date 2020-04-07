package com.zhs.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/27 15:41
 * @package: com.zhs.vo
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SummaryVo {

    private String name;

    private int sum;
}
