package com.yyf.www.luojia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/** 
* @Description: TODO
* @author  yyf 
* @date    2018年3月24日 下午4:21:10 
* @version 1.0 
*/
@Configuration
@SuppressWarnings("deprecation")
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
}