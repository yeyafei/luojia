package com.yyf.www.luojia.controller.sys;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyf.www.luojia.bean.sys.User;
import com.yyf.www.luojia.beans.Results;
import com.yyf.www.luojia.exceptions.CheckException;
import com.yyf.www.luojia.service.sys.UserService;





/** 
* @Description: UserController
* @author  yyf 
* @date    2018年3月19日 下午11:23:23 
* @version 1.0 
*/
@RestController
@RequestMapping("/user")
public class UserController {
	@Resource(name = "userServiceImpl")
	private UserService userService;
	
	@GetMapping("/all")
	public Results<Collection<User>> getAll(){
		return new Results<Collection<User>>(userService.getAll());
	}
	
	@SuppressWarnings("unused")
	@GetMapping("/error")
	public Results<Collection<User>> errorTest(){
		if (true)
			throw new CheckException("测试自定义异常捕获");
		return null;
	}
}

