package com.yyf.www.luojia.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @Description: 标识某个字段不录入数据库中  标识该注解的字段将没有增删改查的功能。
 * @author  yyf 
 * @date    2018年3月21日 下午3:05:52 
 * @version 1.0 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TempField {

	 
}
