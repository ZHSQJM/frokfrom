package com.zhs.controller;

import com.github.pagehelper.PageInfo;
import com.util.Result;
import com.zhs.dto.MenuDto;
import com.zhs.entity.SysMenu;
import com.zhs.entity.SysUser;
import com.zhs.service.IMenuService;
import com.zhs.service.IUserService;
import com.zhs.vo.PermissionVo;
import com.zhs.vo.SysMenuVo;
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
@RequestMapping("menu")
public class MenuController {


    @Autowired
    private IMenuService menuService;


    @PostMapping
    @ResponseBody
    public Result add(MenuDto menuDto){
         return Result.success(menuService.add(menuDto));
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public Result delete(@PathVariable String id){
        return Result.success(menuService.delete(id));
    }
    @GetMapping
    public ModelAndView list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int pageSzie,HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        final List<SysMenuVo> list = menuService.findAll();

        modelAndView.setViewName("admin/menu/menu");
        modelAndView.addObject("data",list);
        modelAndView.addObject("title","系统管理/菜单管理");
        return modelAndView;
    }

    @GetMapping("/all")
    @ResponseBody
    private Result getAllPermissions(){
        return Result.success(menuService.findAll());
    }

    @GetMapping("/getPermission/{id}")
    @ResponseBody
    private Result getPermissionByRoleId(@PathVariable("id") String id){
        return Result.success(menuService.getPermissionByRoleId(id));
    }

    @GetMapping("/getPermission")
    @ResponseBody
    private Result getPermissionByRoleId(){
        return Result.success(menuService.list());
    }


    @GetMapping("{id}")
    @ResponseBody
    public  Result getOne(@PathVariable("id") String id){
          return Result.success(menuService.getOne(id));
    }
}
