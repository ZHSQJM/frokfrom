package com.zhs.service;

import com.zhs.dto.MenuDto;
import com.zhs.entity.SysMenu;
import com.zhs.vo.PermissionVo;
import com.zhs.vo.SysMenuVo;

import java.util.List;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/23 17:24
 * @package: com.zhs.service
 * @description:
 */
public interface IMenuService {

    /**
     * 根据用户名查找用户的菜单
     * @param userName
     * @return
     */
    List<SysMenuVo> findMenuByUserName(String userName);


    /**
     * 获取所有菜单的列表
     * @return
     */
    List<SysMenuVo> findAll();


    /**
     * 新增菜单
     * @param menuDto
     * @return
     */
    boolean add(MenuDto menuDto);


    /**
     * 根据角色id获取角色权限
     * @param id
     * @return
     */
    List<PermissionVo> getPermissionByRoleId(String id);

    /**
     * 获取所有的菜单
     * @return
     */
    List<PermissionVo> list();

    /**
     * 删除菜单
     * @param id
     * @return
     */
    boolean delete(String id);


    SysMenu getOne(String id);
}
