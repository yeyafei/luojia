package com.yyf.www.luojia.service.sys;

import java.util.List;

import com.yyf.www.luojia.bean.sys.Permission;

/** 
* @Description: TODO
* @author  yyf 
* @date    2018年3月24日 下午8:06:44 
* @version 1.0 
*/
public interface PermissionService {
List<Permission> findAll();
List<Permission> findByUserId(int id);

}

