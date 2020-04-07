package com.zhs.mapper;

import com.util.MyMapper;
import com.zhs.entity.WxSignRecords;
import com.zhs.vo.SignRecordsVo;

import java.util.List;

public interface WxSignRecordsMapper extends MyMapper<WxSignRecords> {

    List<SignRecordsVo> list();
}