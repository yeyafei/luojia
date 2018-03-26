package com.yyf.www.luojia.service;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import com.yyf.www.luojia.bean.sys.Permission;
/** 
* @Description: TODO
* @author  yyf 
* @date    2018年3月26日 下午8:51:07 
* @version 1.0 
*/
@Service
public class SecurityAccessDecisionManager implements AccessDecisionManager{
	  @Override
	    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
	        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
	        String url, method;
	        if ("anonymousUser".equals(authentication.getPrincipal())
	                || matchers("/images/**", request)
	                || matchers("/js/**", request)
	                || matchers("/css/**", request)
	                || matchers("/", request)
	                || matchers("/swagger-ui.html", request)
	                || matchers("/v2/**", request)
	                || matchers("/webjars/**", request)
	                || matchers("/swagger-resources/**", request)
	                || matchers("/login", request)) {
	            return;
	        } else {
	            for (GrantedAuthority ga : authentication.getAuthorities()) {
	                if (ga instanceof Permission) {
	                	Permission permission = (Permission) ga;
	                    url = permission.getUrl();
	                    method = permission.getMethod();
	                    if (matchers(url, request)) {
	                        if (method.equals(request.getMethod()) || "ALL".equals(method)) {
	                            return;
	                        }
	                    }
	                }
	            }
	        }
	        throw new AccessDeniedException("no right");
	    }


	    @Override
	    public boolean supports(ConfigAttribute attribute) {
	        return true;
	    }

	    @Override
	    public boolean supports(Class<?> clazz) {
	        return true;
	    }


	    private boolean matchers(String url, HttpServletRequest request) {
	        AntPathRequestMatcher matcher = new AntPathRequestMatcher(url);
	        if (matcher.matches(request)) {
	            return true;
	        }
	        return false;
	    }

}
