package com.yyf.www.luojia.service.sys;

import java.util.List;

import com.yyf.www.luojia.bean.sys.Role;

/** 
 * @Description: RoleService
 * @author  yyf 
 * @date    2018年3月21日 下午5:00:38 
 * @version 1.0 
 */
public interface RoleService {
	List<Role> getAll();
	
	Boolean add(Role role);

	Boolean delete(int id);

	Boolean update(Role role, int id);

	Role getRoleById(int id);

}

