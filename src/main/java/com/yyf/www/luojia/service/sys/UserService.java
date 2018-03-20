package com.yyf.www.luojia.service.sys;

import java.util.Collection;

import com.yyf.www.luojia.bean.sys.User;

/** 
* @Description: TODO
* @author  yyf 
* @date    2018年3月19日 下午11:25:40 
* @version 1.0 
*/
public interface UserService   {

	Collection<User> getAll();

	User getUserById(int id);
	
	User getUserByName(String name);

	Boolean add(User user);

	Boolean delete(int id);

	Boolean update(User user, int id);

	

}

