package com.yyf.www.luojia.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yyf.www.luojia.beans.Results;
import com.yyf.www.luojia.exceptions.CheckException;
import com.yyf.www.luojia.exceptions.UnknownException;

/**
 * @Description: aop 对异常信息捕获抛出自定义异常
 * @author yyf
 * @date 2018年3月19日 下午10:53:13
 * @version 1.0
 */
@Aspect
@Component
public class ControllerAop {
	private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

	@Pointcut("execution(public com.yyf.www.luojia.beans.Results *(.. ))")
	public void controllerMethod() {
	}

	@Around("controllerMethod()")
	public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
		Results<?> result;
		try {
			result = (Results<?>) pjp.proceed();
		} catch (Throwable e) {
			result = HandlerException(pjp, e);
		}
		return result;
	}

	/**
	 * 抛出自己定义的异常信息
	 * 
	 * @param pjp
	 * @param e
	 * @return
	 */
	private Results<?> HandlerException(ProceedingJoinPoint pjp, Throwable e) {
		Results<?> result = new Results<>();
		if (e instanceof CheckException) {
			result.setMsg(e.getLocalizedMessage());
			result.setCode(Results.FAIL);
		} else if (e instanceof UnknownException) {
			logger.error(pjp.getSignature() + " error ", e);
			result.setMsg(e.toString());
			result.setCode(Results.FAIL);
		} else {
			logger.error(pjp.getSignature() + " 未知异常 ", e);
			result.setMsg("抛出未知异常，检查日志修改异常信息！");
			result.setCode(Results.FAIL);
		}
		return result;
	}

}
