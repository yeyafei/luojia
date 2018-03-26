package com.yyf.www.luojia.bean.sys;

import java.util.Collection;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yyf.www.luojia.base.BaseBean;

/**
 * @Description: TODO
 * @author yyf
 * @date 2018年3月19日 下午11:17:58
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends BaseBean implements UserDetails  {
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private int id;
	/**
	 * 登录名
	 */
	private String name;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 角色
	 */
	private List<Role> roles;
	
	private List<? extends GrantedAuthority> authorities;
	 @Override
	    @JsonIgnore
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    @JsonIgnore
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    @JsonIgnore
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    @JsonIgnore
	    public boolean isEnabled() {
	        return true;
	    }


	    @JsonIgnore
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
	    }

	    public void setGrantedAuthorities(List<? extends GrantedAuthority> authorities) {
	        this.authorities = authorities;
	    }

		@Override
		public String getUsername() {
			return this.name;
		}
}
