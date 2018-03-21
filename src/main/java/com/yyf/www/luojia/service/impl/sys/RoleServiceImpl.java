package com.yyf.www.luojia.service.impl.sys;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yyf.www.luojia.base.BaseService;
import com.yyf.www.luojia.bean.sys.Role;
import com.yyf.www.luojia.dao.sys.RoleDao;
import com.yyf.www.luojia.service.sys.RoleService;

/**
 * @Description: TODO
 * @author yyf
 * @date 2018年3月21日 下午5:03:30
 * @version 1.0
 */
@Service(value = "roleServiceImpl")

public class RoleServiceImpl extends BaseService<Role, RoleDao> implements RoleService {

	@Override
	public List<Role> getAll() {
		return baseSearch(new Role());
	}

	@Override
	public Role getRoleById(int id) {
		return baseParSelect(new Role(id));
	}

	@Override
	public Boolean add(Role role) {
		return baseSave(role);
	}

	@Override
	public Boolean delete(int id) {

		return baseParDel(new Role(id));
	}

	@Override
	public Boolean update(Role role, int id) {
		role.setId(id);
		return baseUpdate(role);
	}

}
