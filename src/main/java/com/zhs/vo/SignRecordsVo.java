package com.zhs.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/25 10:52
 * @package: com.zhs.vo
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignRecordsVo {

    private String nickName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date dateTime;

    private Integer integral;

}
