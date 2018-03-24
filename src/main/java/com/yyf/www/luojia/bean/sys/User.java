package com.yyf.www.luojia.bean.sys;

import java.util.List;

import com.yyf.www.luojia.base.BaseBean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: TODO
 * @author yyf
 * @date 2018年3月19日 下午11:17:58
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends BaseBean {
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

}
