package com.zhs.mapper;

import com.util.MyMapper;
import com.zhs.entity.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysMenuMapper extends MyMapper<SysMenu> {


    @Select({
            "<script> select code from sys_menu m left join sys_role_menu rm on m.id = rm.menu_id left join sys_role r on r.id = rm.role_id where r.role_code in <foreach collection = 'roleCodes' item = 'roleCode' open='(' separator=',' close=')'> #{roleCode}</foreach> </script>"
    })
    List<String > findAuthorityByRoleCodes(@Param("roleCodes") List<String> roleCodes);


    List<SysMenu> findMenuByUserName(String userName);

    @Select("SELECT id, name, pid FROM sys_menu where id in (SELECT menu_id FROM sys_role_menu where role_id = #{id})")
    List<SysMenu> getPermissionByRoleId(@Param("id") String id);


}