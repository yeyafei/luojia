package com.yyf.www.luojia.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yyf.www.luojia.bean.sys.User;



/** 
* @Description: UserDao
* @author  yyf 
* @date    2018年3月19日 下午11:32:23 
* @version 1.0 
*/
@Mapper
public interface UserDao {
	public  List<User> findAll();
}

