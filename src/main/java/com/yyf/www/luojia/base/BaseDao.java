package com.yyf.www.luojia.base;

import org.apache.ibatis.annotations.Param;

/**
 * @Description: TODO
 * @author yyf
 * @date 2018年3月20日 下午2:58:44
 * @version 1.0
 */
public interface BaseDao<T> {

	T getEntityById(@Param("id") int id);

	Boolean deleteById(@Param("id") int id);

	Boolean add(@Param("et") T t);

	Boolean update(@Param("et") T t);
}
