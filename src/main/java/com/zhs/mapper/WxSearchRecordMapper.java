package com.zhs.mapper;

import com.util.MyMapper;
import com.zhs.entity.WxSearchRecord;
import com.zhs.vo.SearchRecordVo;

import java.util.List;

public interface WxSearchRecordMapper extends MyMapper<WxSearchRecord> {

    List<SearchRecordVo> list();
}