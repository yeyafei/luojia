package com.yyf.www.luojia.exceptions;
/** 
* @Description: 自定义未知异常
* @author  yyf 
* @date    2018年3月19日 下午10:50:41 
* @version 1.0 
*/
public class UnknownException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UnknownException() {
		super();
	}

	public UnknownException(String message) {
		super(message);
	}

	public UnknownException(Throwable cause) {
		super(cause);
	}

	public UnknownException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

