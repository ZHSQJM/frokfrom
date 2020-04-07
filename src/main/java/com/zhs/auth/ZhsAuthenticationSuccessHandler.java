package com.zhs.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/21 20:31
 * @package: com.zhs.auth
 * @description: 自定义登录成功逻辑
 */
@Component
public class ZhsAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {


    @Value("${spring.security.loginType}")
    private String loginType;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

         if(loginType.equalsIgnoreCase("JSON")) {
             response.setContentType("application/json;charset=UTF-8");
             response.getWriter().write(objectMapper.writeValueAsString("成功"));
         }else {
             super.onAuthenticationSuccess(request,response,authentication);
         }
    }
}
