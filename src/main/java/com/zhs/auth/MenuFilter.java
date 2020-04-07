package com.zhs.auth;

import com.zhs.service.IMenuService;
import com.zhs.vo.SysMenuVo;
import org.apache.ibatis.annotations.One;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/31 14:43
 * @package: com.zhs.auth
 * @descrip
 */
@Controller
public class MenuFilter extends OncePerRequestFilter {

    @Autowired
    private IMenuService menuService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final HttpSession session = request.getSession();

         //加载右侧菜单以及权限
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final Object menu1 = session.getAttribute("menu");
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
           if(authentication!=null&&menu1==null){
               String currentUserName = authentication.getName();
               final List<SysMenuVo> menu = menuService.findMenuByUserName(currentUserName);
               session.setAttribute("menu",menu);
           }
        }

        filterChain.doFilter(request,response);
    }
}
