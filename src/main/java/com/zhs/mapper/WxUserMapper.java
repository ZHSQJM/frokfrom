package com.zhs.mapper;

import com.util.MyMapper;
import com.zhs.entity.WxUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxUserMapper extends MyMapper<WxUser> {

    List<WxUser> list(@Param("nickName") String nickName, @Param("gender") Integer gender);

    /**
     * 获取今日增加的用户
     * @return
     */
    Integer getTodaySum();
}