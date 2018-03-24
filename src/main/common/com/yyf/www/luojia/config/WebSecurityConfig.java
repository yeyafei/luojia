package com.yyf.www.luojia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.yyf.www.luojia.service.CustomUserService;
import com.yyf.www.luojia.service.MyFilterSecurityInterceptor;
import com.yyf.www.luojia.utils.MD5Util;

/**
 * @Description: TODO
 * @author yyf
 * @date 2018年3月24日 上午9:41:06
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
	    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;



		
		
	    @Bean
	    UserDetailsService customUserService(){ //注册UserDetailsService 的bean
	        return new CustomUserService();
	    }
	    
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(customUserService()).passwordEncoder(new PasswordEncoder(){

	            @Override
	            public String encode(CharSequence rawPassword) {
	                return MD5Util.encode((String)rawPassword);
	            }

	            @Override
	            public boolean matches(CharSequence rawPassword, String encodedPassword) {
	                return encodedPassword.equals((String)rawPassword);
	            }}); //user Details Service验证
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	                .anyRequest().authenticated() //任何请求,登录后可以访问
	                .and()
	                .formLogin()
	                .loginPage("/login")
	                .failureUrl("/login?error")
	                .permitAll() //登录页面用户任意访问
	                .and()
	                .logout().permitAll(); //注销行为任意访问
	        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
	    }
}
