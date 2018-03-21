package com.yyf.www.luojia.core.annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/** 
* @Description:  * 标识该字段是唯一字段
* 可以通过该字段来查找唯一数据 
* 可以通过该字段来删除唯一数据 
* 可以通过该字段来更新唯一数据
* @author  yyf 
* @date    2018年3月21日 下午9:19:29 
* @version 1.0 
*/

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Primary {

}