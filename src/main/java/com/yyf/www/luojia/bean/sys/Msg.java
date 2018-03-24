package com.yyf.www.luojia.bean.sys;

import lombok.Data;

/**
 * @Description: TODO
 * @author yyf
 * @date 2018年3月24日 下午4:17:59
 * @version 1.0
 */
@Data
public class Msg {
	private String title;
	private String content;
	private String etraInfo;

	public Msg() {
	}

	public Msg(String title, String content, String etraInfo) {
		super();
		this.title = title;
		this.content = content;
		this.etraInfo = etraInfo;
	}
}
