package com.yyf.www.luojia.beans;

import java.io.Serializable;

import lombok.Data;

/**
 * @Description:返回类型
 * @author yyf
 * @date 2018年3月19日 下午10:32:19
 * @version 1.0
 */
@Data
public class Results<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 成功
	 */
	public static final int SUCCESS = 0;
	/**
	 * 失败
	 */
	public static final int FAIL = -1;
	/**
	 * 数据包
	 */
	private T data;
	
	private String msg="success";
	
	private int code=SUCCESS;

	public Results() {
		super();
	}

	public Results(T data) {
		super();
		this.data = data;
	}

	public Results(Throwable e) {
		super();
		this.msg = e.toString();
		this.code = FAIL;
	}
}
