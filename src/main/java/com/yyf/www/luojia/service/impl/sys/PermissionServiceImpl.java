package com.yyf.www.luojia.service.impl.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyf.www.luojia.base.BaseService;
import com.yyf.www.luojia.bean.sys.Permission;
import com.yyf.www.luojia.dao.sys.PermissionDao;
import com.yyf.www.luojia.service.sys.PermissionService;

/** 
* @Description: TODO
* @author  yyf 
* @date    2018年3月24日 下午8:08:46 
* @version 1.0 
*/
@Service(value="permissionServiceImpl")
public class PermissionServiceImpl extends BaseService<Permission, PermissionDao> implements PermissionService{

	@Autowired
	private PermissionDao permissionDao;
	@Override
	public List<Permission> findAll() {
		return permissionDao.getAll();
	}

	@Override
	public List<Permission> findByUserId(int id) {
		return permissionDao.findByUserId(id);
	}

}

