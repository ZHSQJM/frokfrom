package com.zhs.mapper;

import com.util.MyMapper;
import com.zhs.entity.SysRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleMapper extends MyMapper<SysRole> {


    /**
     * 根据用户名查找用户的roleCode
     * @param username
     * @return
     */
    @Select("select role_code from sys_role r left join sys_user_role ur on r.id = ur.role_id left join sys_user u on u.id = ur.user_id where u.username = #{username}" )
    List<String> findRoleByUserName(@Param("username") String username);


    /**
     * 根据角色ID删除角色
     * @param roleId
     * @return
     */
    @Delete("delete  from  sys_role_menu where role_id = #{roleId}")
    boolean deleteRolesbyRoleIds(@Param("roleId") String roleId);


    /**
     * 给用户添加权限
     * @param roleId
     * @param menuId
     * @return
     */
    @Insert("INSERT INTO `sys_role_menu`(`role_id`, `menu_id`) VALUES ( #{roleId}, #{menuId});")
    boolean insertRoleMenu(@Param("roleId")String roleId,@Param("menuId")String menuId);
}