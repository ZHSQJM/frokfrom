package com.zhs.auth;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/22 13:30
 * @package: com.zhs.auth
 * @description:
 */
public class ZhsUserDetails implements org.springframework.security.core.userdetails.UserDetails {


    /**用户名*/
    private String username;
    /**密码*/
    private String password;
    /**账号是否没过期*/
    private boolean  accountNonExpired;
    /**账号锁定*/
    private boolean accountNonLocked;
    /**密码*/
    private boolean credentialsNonExpired;

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
