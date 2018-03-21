package com.yyf.www.luojia.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @Description: 实体类字段约束注解  标有此注解的字段对应数据库中的字段名强制约束为该注解中的name值
 * @author  yyf 
 * @date    2018年3月21日 下午3:07:23 
 * @version 1.0 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldName {
	String name() ;
}

