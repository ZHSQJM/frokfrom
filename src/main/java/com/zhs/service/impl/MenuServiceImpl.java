package com.zhs.service.impl;

import com.zhs.dto.MenuDto;
import com.zhs.vo.PermissionVo;
import com.zhs.vo.SysMenuVo;
import com.zhs.entity.SysMenu;
import com.zhs.mapper.SysMenuMapper;
import com.zhs.service.IMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/23 17:26
 * @package: com.zhs.service.impl
 * @description:
 */
@Service
public class MenuServiceImpl implements IMenuService {


    @Autowired
    private SysMenuMapper sysMenuMapper;
    /**
     * 通过用户名查找用户的菜单 树形结构
     * @param userName
     * @return
     */
    @Override
    public List<SysMenuVo> findMenuByUserName(String userName) {

        /**
         * 1：获取该用户的所有权限
         * 2:过滤出是type是0的并且parentid是1的菜单
         * 4：递归获取下级菜单
         */
        final List<SysMenu> userPermissionsList = sysMenuMapper.findMenuByUserName(userName);
        return   get(userPermissionsList);
    }

    @Override
    public List<SysMenuVo> findAll() {
        final List<SysMenu> userPermissionsList = sysMenuMapper.selectAll();
        List<SysMenuVo> list = new ArrayList<>();
        userPermissionsList.forEach(
                e->{
                    SysMenuVo sysMenuVo = new SysMenuVo();
                    BeanUtils.copyProperties(e,sysMenuVo);
                    list.add(sysMenuVo);
                }
        );
        return list;
    }

    @Override
    public boolean add(MenuDto menuDto) {
        SysMenu menu = new SysMenu();
        BeanUtils.copyProperties(menuDto,menu);
        if(menu.getPid()==null) menu.setPid(0);
        menu.setCreateTime(new Date());
        menu.setUpdateTime(new Date());
         sysMenuMapper.insert(menu);
        return true;
    }

    @Override
    public List<PermissionVo> getPermissionByRoleId(String id) {
        //这是所有的菜单
        final List<PermissionVo> list = list();
        final List<SysMenu> permissionByRoleId = sysMenuMapper.getPermissionByRoleId(id);
        final List<String> collect = permissionByRoleId.stream().map(e -> e.getId().toString()).collect(Collectors.toList());
     return    list.stream().map(e->{
            PermissionVo permissionVo = new PermissionVo();
            permissionVo.setId(e.getId());
            permissionVo.setName(e.getName());
            permissionVo.setOpen(true);
            permissionVo.setPId(e.getPId());
            if(collect.contains(e.getId())){
                permissionVo.setChecked(true);
            }
            return permissionVo;
        }).collect(Collectors.toList());
    }

    @Override
    public List<PermissionVo> list() {
        final List<SysMenu> permissionByRoleId = sysMenuMapper.selectAll();
        return permissionByRoleId.stream().map(e -> {
            PermissionVo permissionVo = new PermissionVo();
            permissionVo.setId(e.getId().toString());
            permissionVo.setName(e.getName());
            permissionVo.setOpen(true);
            permissionVo.setPId(e.getPid().toString());
            return permissionVo;
        }).collect(Collectors.toList());
    }

    @Override
    public boolean delete(String id) {
        sysMenuMapper.deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public SysMenu getOne(String id) {
        return sysMenuMapper.selectByPrimaryKey(id);
    }


    private  List<SysMenuVo> get(List<SysMenu> list){
        //所有的菜单
        final List<SysMenu> menulist = list.stream().filter(e -> e.getType() == 0 ).collect(Collectors.toList());
        final List<SysMenu> collect = list.stream().filter(e -> e.getType() == 0 && e.getPid() == 0).collect(Collectors.toList());
        List<SysMenuVo> result = new ArrayList<>(16);
        collect.forEach(e->{
            SysMenuVo vo = new SysMenuVo();
            BeanUtils.copyProperties(e, vo) ;
            result.add(vo);
        });
        //为一级菜单设置子菜单准备递归
        for (SysMenuVo menu:result) {
            //获取父菜单下所有子菜单调用getChildList
            List<SysMenuVo> childList = getChildList(menu.getId(),menulist);
            menu.setList(childList);
        }
        return result;
    }
    /**
     * 获取子节点
     * @param id 父节点id
     * @param collect 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    private List<SysMenuVo> getChildList(Integer id, List<SysMenu> collect) {

        //构建子菜单
        List<SysMenuVo> childList = new ArrayList<>();

        //遍历传入的list
        for (SysMenu menu:collect) {
            //所有菜单的父id与传入的根节点id比较，若相等则为该级菜单的子菜单
            if (menu.getPid().equals(id)){
                SysMenuVo vo = new SysMenuVo();
                BeanUtils.copyProperties(menu, vo) ;
                childList.add(vo);
            }
        }
        //递归
        for (SysMenuVo m:childList) {
            m.setList(getChildList(m.getId(),collect));
        }
        if (childList.size() == 0){
            return new ArrayList<SysMenuVo>();
        }
        return childList;
    }
}
