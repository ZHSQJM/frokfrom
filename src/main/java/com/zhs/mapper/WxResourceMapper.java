package com.zhs.mapper;

import com.util.MyMapper;
import com.zhs.entity.WxResource;
import com.zhs.query.ResourceQuery;
import com.zhs.vo.ResourceVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxResourceMapper extends MyMapper<WxResource> {


    List<ResourceVo> list(ResourceQuery resourceQuery);


    void updateStatus(@Param("status") int status, @Param("id") String id);
}