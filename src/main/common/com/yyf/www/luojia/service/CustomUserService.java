package com.yyf.www.luojia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yyf.www.luojia.bean.sys.Permission;
import com.yyf.www.luojia.bean.sys.User;
import com.yyf.www.luojia.service.sys.PermissionService;
import com.yyf.www.luojia.service.sys.UserService;

/** 
* @Description: TODO
* @author  yyf 
* @date    2018年3月24日 下午3:03:22 
* @version 1.0 
*/
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    UserService userService;
    @Autowired
    PermissionService permissionService;
    
    
    public UserDetails loadUserByUsername(String username) {
        User user = userService.getUserByName(username);
        if (user != null) {
            List<Permission> permissions = permissionService.findByUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName()!=null) {

                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                grantedAuthorities.add(grantedAuthority);
                }
            }
            return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

    
}

