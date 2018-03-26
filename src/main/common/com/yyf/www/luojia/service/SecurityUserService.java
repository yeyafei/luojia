package com.yyf.www.luojia.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
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
 * @author yyf
 * @date 2018年3月26日 下午8:56:02
 * @version 1.0
 */
@Service
public class SecurityUserService implements UserDetailsService {
	@Resource(name = "userServiceImpl")
	private UserService userService;
	@Resource(name = "permissionServiceImpl")
	private PermissionService permissionService;

	@Override
	public UserDetails loadUserByUsername(String userName) { // 重写loadUserByUsername 方法获得 userdetails 类型用户

		User user = userService.getUserByName(userName);
		if (user != null) {
			List<Permission> permissions = permissionService.findByUserId(user.getId());
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			for (Permission permission : permissions) {
				if (permission != null && permission.getName() != null) {
					GrantedAuthority grantedAuthority = new Permission(permission.getUrl(), permission.getMethod(),
							permission.getDescritpion());
					grantedAuthorities.add(grantedAuthority);
				}
			}
			user.setGrantedAuthorities(grantedAuthorities);
			return user;
		} else {
			throw new UsernameNotFoundException("admin: " + userName + " do not exist!");
		}
	}
}
