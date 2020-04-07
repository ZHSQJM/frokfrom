package com.zhs.mapper;

import com.util.MyMapper;
import com.zhs.entity.WxExchangeRecord;
import com.zhs.vo.ExchangeRecordVo;

import java.util.List;

public interface WxExchangeRecordMapper extends MyMapper<WxExchangeRecord> {


    List<ExchangeRecordVo> list();
}