package com.yyf.www.luojia.controller.sys;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyf.www.luojia.bean.sys.User;
import com.yyf.www.luojia.beans.Results;
import com.yyf.www.luojia.service.sys.UserService;

/**
 * @Description: UserController
 * @author yyf
 * @date 2018年3月19日 下午11:23:23
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
@Api(value = "USER接口")
public class UserController {
	@Resource(name = "userServiceImpl")
	private UserService userService;

	@ApiOperation(value = "查询所有用户", notes = "sys_user表中所有数据")
	@GetMapping("/all")
	public Results<Collection<User>> getAll() {
		return new Results<Collection<User>>(userService.getAll());
	}

	/**
	 * 查找用户
	 * 
	 * @param name
	 * @return
	 */
	@ApiOperation(value = "查询用户", notes = "按用ID查找用户信息")
	@ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", required = true, dataType = "Integer")
	@GetMapping("/{id}")
	public Results<User> getUser(@PathVariable int id) {
		return new Results<User>(userService.getUserById(id));
	}

	/**
	 * 新建用户信息
	 * 
	 * @param user
	 * @return
	 */
	@ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User")
	@PostMapping("/add")
	public Results<Boolean> insertUser(@RequestBody User user) {
		return new Results<Boolean>(userService.add(user));
	}

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "更新用户", notes = "根据用户id更新用户")
	@ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", required = true, dataType = "Integer")
	@PutMapping("/{id}")
	public Results<Boolean> updateUser(@RequestBody User user, @PathVariable int id) {
		return new Results<Boolean>(userService.update(user,id));
	}

	/**
	 * 删除用户信息
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除用户", notes = "根据用户id删除用户")
	@ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", required = true, dataType = "Integer")
	@DeleteMapping("/{id}")
	public Results<Boolean> deleteUsers(@PathVariable int id) {
		return new Results<Boolean>(userService.delete(id));
	}
}
