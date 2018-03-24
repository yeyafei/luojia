package com.yyf.www.luojia.controller.sys;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/** 
* @Description: TODO
* @author  yyf 
* @date    2018年3月24日 下午2:41:54 
* @version 1.0 
*/
@Controller
public class MenuController {
    @GetMapping("/menu")
    public String user(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "user/user";
    }
}

