package com.yyf.www.luojia.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yyf.www.luojia.base.BaseDao;
import com.yyf.www.luojia.bean.sys.User;



/** 
* @Description: UserDao
* @author  yyf 
* @date    2018年3月19日 下午11:32:23 
* @version 1.0 
*/
@Mapper
public interface UserDao extends BaseDao<User>{
	public  List<User> findAll();
	/**
	 * search:name->user
	 * @param name
	 * @return
	 */
	public User getUserByName(@Param("name") String name);
	
}

