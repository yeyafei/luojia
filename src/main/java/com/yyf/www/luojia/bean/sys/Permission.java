package com.yyf.www.luojia.bean.sys;

import org.springframework.security.core.GrantedAuthority;

import com.yyf.www.luojia.base.BaseBean;
import com.yyf.www.luojia.core.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: TODO
 * @author yyf
 * @date 2018年3月24日 下午8:00:07
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(name = "sys_permission")
public class Permission extends BaseBean implements GrantedAuthority {
	private static final long serialVersionUID = 1L;
	private int id;
	// 权限名称
	private String name;

	// 权限描述
	private String descritpion;

	// 授权链接
	private String url;

	// 父节点id
	private int pid;

	// 提交方式
	private String method;

	@Override
	public String getAuthority() {
		return this.url + ";" + this.method + ";" + this.descritpion;
	}

	public Permission() {
	}

	public Permission(String url, String method, String descritpion) {
		this.url = url;
		this.method = method;
		this.descritpion = descritpion;
	}
}
