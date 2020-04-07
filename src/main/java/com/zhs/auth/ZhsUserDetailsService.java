package com.zhs.auth;


import com.zhs.mapper.SysMenuMapper;
import com.zhs.mapper.SysRoleMapper;
import com.zhs.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/22 15:02
 * @package: com.zhs.auth
 * @description:
 */
@Component
public class ZhsUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

          //加载用户信息
        ZhsUserDetails userDetails = sysUserMapper.findByUserName(username);

        if(userDetails==null){
            //todo
        }
        //加载用户角色列表
         List<String> roleCodes = sysRoleMapper.findRoleByUserName(username);
        //通过用户角色列表加载用户额资源权限列表
         List<String> authorties = sysMenuMapper.findAuthorityByRoleCodes(roleCodes);

        //角色是一个特殊的权限 ROLE_前缀
         roleCodes = roleCodes.stream()
                .map(e->"ROLE_"+e).collect(Collectors.toList());
          authorties.addAll(roleCodes);
         // userDetails.s
        userDetails.setAuthorities(
                AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",",authorties))
        );
        return userDetails;
    }
}
