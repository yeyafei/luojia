package com.yyf.www.luojia.exceptions;
/** 
 * @Description: 自定义反射异常（现用在注解检索）
 * @author  yyf 
 * @date    2018年3月21日 下午2:29:53 
 * @version 1.0 
 */
public class ReflectException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ReflectException() {
		super();
	}

	public ReflectException(String message) {
		super(message);
	}

	public ReflectException(Throwable cause) {
		super(cause);
	}

	public ReflectException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReflectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

