package com.zhs.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/25 16:01
 * @package: com.zhs.query
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceQuery {

    private String name;

    private String nickName;

    private String typeId;

    private Integer status;
}
