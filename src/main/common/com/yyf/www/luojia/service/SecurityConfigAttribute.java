package com.yyf.www.luojia.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;

/**
 * @Description: TODO
 * @author yyf
 * @date 2018年3月26日 下午9:21:31
 * @version 1.0
 */
public class SecurityConfigAttribute implements ConfigAttribute {

	private static final long serialVersionUID = 1L;
	private final HttpServletRequest httpServletRequest;

	public SecurityConfigAttribute(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	@Override
	public String getAttribute() {
		return null;
	}

	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}
}
