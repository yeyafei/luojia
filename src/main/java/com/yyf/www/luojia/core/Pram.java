package com.yyf.www.luojia.core;

import lombok.Data;

/** 
 * @Description: 用于获取实体类的属性
 * @author  yyf 
 * @date    2018年3月21日 下午3:00:29 
 * @version 1.0 
 */
@Data
public class Pram {
	private String file;

	private Object value;

	public Pram() {
	}

	public Pram(String file, Object value) {
		this.file = file;
		this.value = value;
	}
}

