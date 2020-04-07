package com.zhs.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/30 14:20
 * @package: com.zhs.vo
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionVo {

    private String id;

    @JsonProperty("pId")
    private String pId;

    private String name;

    private boolean open=true;


    private boolean checked = false;
}
