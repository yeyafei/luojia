package com.yyf.www.luojia.bean.sys;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.yyf.www.luojia.base.BaseBean;
import com.yyf.www.luojia.core.annotation.TableName;

/**
 * @Description: Role
 * @author yyf
 * @date 2018年3月21日 下午4:52:03
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(name="sys_role")
public class Role extends BaseBean {
	private static final long serialVersionUID = 1L;
	/**
	 * id
	 */
	private int id;
	/**
	 * 角色
	 */
	private String role;
	/**
	 * 称号
	 */
	private String depict;

	public Role() {
	}

	public Role(int id) {
		this.id = id;
	}

}
