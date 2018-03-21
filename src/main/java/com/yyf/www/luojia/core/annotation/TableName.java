package com.yyf.www.luojia.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @Description: 标识一个实体类对应数据库表的表名
 * @author  yyf 
 * @date    2018年3月21日 下午2:24:43 
 * @version 1.0 
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TableName {
	String name();
}


