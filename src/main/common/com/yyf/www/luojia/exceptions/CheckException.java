package com.yyf.www.luojia.exceptions;
/** 
* @Description: 自定义检查异常
* @author  yyf 
* @date    2018年3月19日 下午10:49:34 
* @version 1.0 
*/
public class CheckException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CheckException() {
		super();
	}

	public CheckException(String message) {
		super(message);
	}

	public CheckException(Throwable cause) {
		super(cause);
	}

	public CheckException(String message, Throwable cause) {
		super(message, cause);
	}

	public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

