package com.zhs.controller;

import com.github.pagehelper.PageInfo;
import com.util.Result;
import com.zhs.entity.SysMenu;
import com.zhs.entity.SysRole;
import com.zhs.entity.SysUser;
import com.zhs.service.IMenuService;
import com.zhs.service.IRoleService;
import com.zhs.service.IUserService;
import com.zhs.vo.PermissionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/15 18:45
 * @package: com.zhs.controller
 * @description:
 */
@Controller
@Slf4j
@RequestMapping("role")
public class RoleController {

    @Autowired
    private IRoleService roleService;


    @GetMapping
    public ModelAndView list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSzie,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        final PageInfo<SysRole> list = roleService.list(page, pageSzie);
        modelAndView.setViewName("admin/role/role");
        modelAndView.addObject("data",list);
        modelAndView.addObject("title","系统管理/角色管理");
        return modelAndView;
    }

    @PostMapping("allocation")
    @ResponseBody
    public Result allocation(String roleId,String roleIds){
        return Result.success(roleService.allocation(roleId,roleIds));
    }
}
