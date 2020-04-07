//package com.zhs.auth;
//
//import java.io.IOException;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.zhs.bo.ImageCode;
//import com.zhs.controller.CodeController;
//import com.zhs.exception.ValidateCodeException;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.social.connect.web.HttpSessionSessionStrategy;
//import org.springframework.social.connect.web.SessionStrategy;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.ServletRequestBindingException;
//import org.springframework.web.bind.ServletRequestUtils;
//import org.springframework.web.context.request.ServletWebRequest;
//import org.springframework.web.filter.OncePerRequestFilter;
///**
//
///**
// * @project: formwork
// * @author: zhs
// * @date: 2020/3/31 15:14
// * @package: com.zhs.auth
// * @description:
// */
//@Component
//@Slf4j
//public class KaptchaFilter extends OncePerRequestFilter {
//
//    /**
//     * 认证失败处理器
//     */
//    private AuthenticationFailureHandler authenticationFailureHandler;
//
//
//    /**
//     * 获取session工具类
//     */
//    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        //如果是 登录请求 则执行
//        if(StringUtils.equals("/loginIn", request.getRequestURI())
//                &&StringUtils.equalsIgnoreCase(request.getMethod(), "post")){
//            try {
//                validate(new ServletWebRequest(request));
//            } catch (ValidateCodeException e) {
//                //调用错误处理器，最终调用自己的
//                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
//                return ;//结束方法，不再调用过滤器链
//            }
//        }
//        //不是登录请求，调用其它过滤器链
//        filterChain.doFilter(request, response);
//    }
//    /**
//     * 校验验证码
//     * @Description: 校验验证码
//     * @param @param request
//     * @param @throws ServletRequestBindingException
//     * @return void
//     * @throws ValidateCodeException
//     * @author lihaoyang
//     * @date 2018年3月2日
//     */
//    private void validate(ServletWebRequest request) throws ServletRequestBindingException {
//        //拿出session中的ImageCode对象
//        ImageCode imageCodeInSession = (ImageCode) sessionStrategy.getAttribute(request, CodeController.SESSION_KEY);
//        //拿出请求中的验证码
//        String imageCodeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");
//        //校验
//        if(StringUtils.isBlank(imageCodeInRequest)){
//            throw new ValidateCodeException("验证码不能为空");
//        }
//        if(imageCodeInSession == null){
//            throw new ValidateCodeException("验证码不存在，请刷新验证码");
//        }
//        if(imageCodeInSession.isExpired()){
//            //从session移除过期的验证码
//            sessionStrategy.removeAttribute(request, CodeController.SESSION_KEY);
//            throw new ValidateCodeException("验证码已过期，请刷新验证码");
//        }
//        if(!StringUtils.equalsIgnoreCase(imageCodeInSession.getCode(), imageCodeInRequest)){
//            throw new ValidateCodeException("验证码错误");
//        }
//        //验证通过，移除session中验证码
//        sessionStrategy.removeAttribute(request, CodeController.SESSION_KEY);
//    }
//    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
//        return authenticationFailureHandler;
//    }
//    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
//        this.authenticationFailureHandler = authenticationFailureHandler;
//    }
//}
