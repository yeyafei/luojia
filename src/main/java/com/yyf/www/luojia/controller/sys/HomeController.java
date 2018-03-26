package com.yyf.www.luojia.controller.sys;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yyf.www.luojia.bean.sys.User;
import com.yyf.www.luojia.service.sys.UserService;

/**
 * @Description: TODO
 * @author yyf
 * @date 2018年3月24日 下午2:39:33
 * @version 1.0
 */
@Controller
public class HomeController {
	@Resource(name = "userServiceImpl")
	private UserService userService;

	@GetMapping("/")
	public String index(Model model) {
//		Msg msg = new Msg("测试标题", "测试内容", "欢迎来到HOME页面,您拥有 ROLE_HOME 权限");
//		model.addAttribute("msg", msg);
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();//获取spring security封装的当前用户信息对象  
        if("anonymousUser".equals(object)) //如果用户未登录或者登录信息过期，该对象是一个类型为String类型，内容为“anonymousUser”的字符串  
            return "redirect:/";//登录过期跳转至登录页面
        model.addAttribute("user", (User)object);
		return "home";
	}
//	User(id=2, name=admin2, password={bcrypt}123, roles=[Role(id=0, role=ROLE_USER, name=admin2, modules=7;, depict=null)], authorities=[SecurityGrantedAuthority(permissionUrl=/user/**, method=GET), SecurityGrantedAuthority(permissionUrl=/role/**, method=PUT)])

}
