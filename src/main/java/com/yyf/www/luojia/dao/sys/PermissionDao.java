package com.yyf.www.luojia.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yyf.www.luojia.base.BaseDao;
import com.yyf.www.luojia.bean.sys.Permission;

/** 
* @Description: TODO
* @author  yyf 
* @date    2018年3月24日 下午8:03:35 
* @version 1.0 
*/
@Mapper
public interface PermissionDao extends BaseDao<Permission>{
	List<Permission> getAll();
	List<Permission> findByUserId(int id);

}

