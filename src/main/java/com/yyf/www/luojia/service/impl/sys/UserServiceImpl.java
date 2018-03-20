package com.yyf.www.luojia.service.impl.sys;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyf.www.luojia.bean.sys.User;
import com.yyf.www.luojia.dao.sys.UserDao;
import com.yyf.www.luojia.service.sys.UserService;

/**
 * @Description: UserServiceImpl
 * @author yyf
 * @date 2018年3月19日 下午11:26:06
 * @version 1.0
 */
@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Collection<User> getAll() {
		return userDao.findAll();
	}

	@Override
	public User getUserByName(String name) {
		return userDao.getUserByName(name);
	}
	
	@Override
	public User getUserById(int id) {
		return userDao.getEntityById(id);
	}

	@Override
	public Boolean add(User user ) {
		return userDao.add(user);
	}

	@Override
	public Boolean update(User user,int id) {
		user.setId(id);
		return userDao.update(user);
	}

	@Override
	public Boolean delete(int id) {
		return userDao.deleteById(id);
	}



}
