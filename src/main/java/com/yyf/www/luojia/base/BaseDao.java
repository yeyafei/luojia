package com.yyf.www.luojia.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * @Description: BaseDao
 * @author yyf
 * @date 2018年3月20日 下午2:58:44
 * @version 1.0
 */
public interface BaseDao<T> {

	T getEntityById(@Param("id") int id);

	Boolean deleteById(@Param("id") int id);

	Boolean add(@Param("et") T t);

	Boolean update(@Param("et") T t);
	
	//注解拼接sql
	Boolean baseSave(@Param("sql") String sql);
	
	List<Map<String, Object>> baseSearch(@Param("sql") String sql);
	
	Map<String, Object> baseParSelect(@Param("sql") String sql);
	
	Boolean baseParDel(@Param("sql") String sql);

	Boolean baseUpdate(@Param("sql") String sql);
}
