package com.yyf.www.luojia.controller.sys;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yyf.www.luojia.bean.sys.Role;
import com.yyf.www.luojia.beans.Results;
import com.yyf.www.luojia.service.sys.RoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;

/** 
 * @Description: RoleController
 * @author  yyf 
 * @date    2018年3月21日 下午5:10:04 
 * @version 1.0 
 */
@RestController
@RequestMapping("/role")
@Api(value = "Role接口")
public class RoleController{
	@Resource(name = "roleServiceImpl")
	private RoleService roleService;
	
	/**
	 * 新建角色信息
	 * @param role
	 * @return
	 */
	@PostMapping("/add")
	@ApiImplicitParam(name = "role", value = "角色信息", required = true, dataType = "Role")
	public Results<Boolean> insertRole(@RequestBody Role role){
		return new Results<Boolean>(roleService.add(role));
	}
	
	@GetMapping("/all")
	public Results<List<Role>> getAll() {
		return new Results<List<Role>>(roleService.getAll());
	}
	@GetMapping("/{id}")
	public Results<Role> getRole(@PathVariable int id){
		return new Results<Role>(roleService.getRoleById(id));
	}
	
	@PutMapping("/{id}")
	public Results<Boolean> updateRole(@RequestBody Role role, @PathVariable int id) {
		return new Results<Boolean>(roleService.update(role,id));
	}

	@DeleteMapping("/{id}")
	public Results<Boolean> deleteRole(@PathVariable int id) {
		return new Results<Boolean>(roleService.delete(id));
	}
	
}

