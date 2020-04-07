package com.zhs.config;

import com.zhs.auth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/21 15:17
 * @package: com.zhs.config
 * @description:
 */
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {



    @Resource
    private ZhsAuthenticationSuccessHandler authenticationSuccessHandler;

    @Resource
    private ZhsAuthenticationFailureHandler authenticationFailureHandler;

    @Resource
    private ZhsUserDetailsService userDetailsService;


    @Autowired
    private MenuFilter menuFilter;

    //@Autowired
    //private KaptchaFilter kaptchaFilter;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.addFilterAfter(menuFilter,UsernamePasswordAuthenticationFilter.class);
       // http.addFilterBefore(kaptchaFilter,UsernamePasswordAuthenticationFilter.class);

        http.csrf().disable()
                .formLogin()
                .loginPage("/toLogin")
                .loginProcessingUrl("/loginIn")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/loginIn","/toLogin","/logout","/kaptcha").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().logoutSuccessUrl("/toLogin");
               // .and()
                //配置session的策略 以及session过期重新登录的地址
               // .sessionManagement()
               // .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                        //session创建的策略  每次登录session都会重新分发
                //.sessionFixation().migrateSession()
                        //最大同时1个用户在线
               // .maximumSessions(1);
                        //能够再登录
              //  .maxSessionsPreventsLogin(false)
              //  .expiredSessionStrategy(new ZhsExpiredSessionStrategy());


    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password(passwordEncoder().encode("123456"))
//                .roles("user")
//                .and()
//                .withUser("admin")
//                .password(passwordEncoder().encode("123456"))
//                //.authorities("sys:log","sys:user")
//                .roles("admin")
//                .and()
//                .passwordEncoder(passwordEncoder());
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity webSecurity){
        webSecurity.ignoring().antMatchers("/css/**","/js/**","/images/**","/fonts/**");
    }
}
