package com.zhs.mapper;

import com.util.MyMapper;
import com.zhs.auth.ZhsUserDetails;
import com.zhs.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysUserMapper extends MyMapper<SysUser> {

    @Select("select username,password from sys_user where username = #{username}")
    ZhsUserDetails findByUserName(@Param("username") String userName);
}