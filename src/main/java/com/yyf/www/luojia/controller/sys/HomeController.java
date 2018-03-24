package com.yyf.www.luojia.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyf.www.luojia.bean.sys.Msg;

/** 
* @Description: TODO
* @author  yyf 
* @date    2018年3月24日 下午2:39:33 
* @version 1.0 
*/
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model){
        Msg msg =  new Msg("测试标题","测试内容","欢迎来到HOME页面,您拥有 ROLE_HOME 权限");
        model.addAttribute("msg", msg);
        return "home";
    }
    @RequestMapping("/admin")
    @ResponseBody
    public String hello(){
        return "hello admin";
    }


}

