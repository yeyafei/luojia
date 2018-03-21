package com.yyf.www.luojia.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.yyf.www.luojia.core.annotation.FieldName;
import com.yyf.www.luojia.core.annotation.Primary;
import com.yyf.www.luojia.core.annotation.TableName;
import com.yyf.www.luojia.core.annotation.TempField;
import com.yyf.www.luojia.exceptions.ReflectException;

/**
 * @Description: 要生成Sql的实体类
 * @author yyf
 * @date 2018年3月21日 下午2:16:15
 * @version 1.0
 */
public class SqlCore<T extends V> {

	private SqlCore() {
	}

	private static SqlCore<V> instance = null;

	public static synchronized SqlCore<V> getInstance() {
		if (instance == null)
			instance = new SqlCore<V>();
		return instance;
	}

	/**
	 * 获取实体类对应的表名
	 * 
	 * @param v
	 * @return
	 */
	public String getTableName(V v) {
		Class<? extends V> c = v.getClass();
		if (c.isAnnotationPresent(TableName.class)) {
			return c.getAnnotation(TableName.class).name();
		} else {
			throw new ReflectException(v.getClass().getName() + "没有TableName注解");
		}
	}

	/**
	 * 获取实体类的数据库里字段的名字和值
	 * 
	 * @param v
	 * @return
	 */
	public List<Pram> getPramList(V v) {
		List<Pram> list = new ArrayList<Pram>();
		Class<? extends V> thisClass = v.getClass();
		Field[] fields = thisClass.getDeclaredFields();
		for (Field f : fields) {
			String fName = f.getName();
			String fieldName = "";
			if (!fName.equalsIgnoreCase("ID")
					&& !f.isAnnotationPresent(TempField.class)
					&& !fName.equalsIgnoreCase("SERIALVERSIONUID")) {

				// 判断是否是boolean类型
				String getf = "get";
				String fieldType = f.getGenericType().toString();
				if (fieldType.indexOf("boolean") != -1
						|| fieldType.indexOf("Boolean") != -1) {
					getf = "is";
				}
				if (f.isAnnotationPresent(FieldName.class)) {
					fieldName = f.getAnnotation(FieldName.class).name();
				} else {
					fieldName = toTableString(fName);
				}
				Object getValue=null;
				try{
				Method get = thisClass.getMethod(getf
						+ fName.substring(0, 1).toUpperCase()
						+ fName.substring(1));
				getValue = get.invoke(v);
				}catch(Exception e){
					throw new ReflectException(thisClass.getName()+"获取实体类的数据库里字段的名字和值出错："+e.getMessage());
				}
				Pram pram = new Pram(fieldName, getValue);
				list.add(pram);
			}
		}
		return list;
	}

	
	public List<Pram> getAllPramList(V v) {
		List<Pram> list = new ArrayList<Pram>();
		Class<? extends V> thisClass = v.getClass();
		Field[] fields = thisClass.getDeclaredFields();
		for (Field f : fields) {
			String fName = f.getName();
			String fieldName = "";
			if (!f.isAnnotationPresent(TempField.class)&&!fName.equalsIgnoreCase("SERIALVERSIONUID")) {
				// 判断是否是boolean类型
				String getf = "get";
				String fieldType = f.getGenericType().toString();
				if (fieldType.indexOf("boolean") != -1
						|| fieldType.indexOf("Boolean") != -1) {
					getf = "is";
				}
				if (f.isAnnotationPresent(FieldName.class)) {
					fieldName = f.getAnnotation(FieldName.class).name();
				} else {
					fieldName = toTableString(fName);
				}
				Object getValue = null;
				try{
				Method get = thisClass.getMethod(getf
						+ fName.substring(0, 1).toUpperCase()
						+ fName.substring(1));
				getValue = get.invoke(v);
				}catch(Exception e){
					throw new ReflectException(thisClass.getName()+"获取实体类的数据库里字段的名字和值出错："+e.getMessage());
				}
				Pram pram = new Pram(fieldName, getValue);
				list.add(pram);
			}
		}
		return list;
	}
	
	/**
	 * 获取实体类对应的Primary和ID的值（唯一值） 只取最先取到的一个含有值的Primary 用于对单条数据的更新 、查找、 删除这些 动作
	 * 注:Primary不考虑boolean类型
	 * 
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public Pram getPrimaryName(V v)  {
		Pram pram = null;
		Class<? extends V> thisClass = v.getClass();
		Field[] fields = thisClass.getDeclaredFields();
		boolean type = false;
		for (Field f : fields) {
			if (!type
					&& (f.getName().equalsIgnoreCase("ID") || f
							.isAnnotationPresent(Primary.class))) {
				String fName = f.getName();
				String fieldName = "";
				if (f.isAnnotationPresent(FieldName.class)) {
					fieldName = f.getAnnotation(FieldName.class).name();
				} else {
					fieldName = toTableString(fName);
				}
				Object getValue=null;
				try {
				Method get = thisClass.getMethod("get"
						+ fName.substring(0, 1).toUpperCase()
						+ fName.substring(1));
				getValue = get.invoke(v);
				if (getValue != null && !"".equals(getValue)
						&& !"0".equals(getValue.toString())) {
					pram = new Pram(fieldName, getValue);
					type = true;
				}
				}catch (Exception e) {
					throw new ReflectException(thisClass.getName()+"获取实体类的数据库里字段的名字和值出错："+e.getMessage());
				}
			}
		}
		return pram;
	}
	
	/**
	 * 驼峰标识转下划线标识 非小写和数字加"_"
	 * 
	 * @param text
	 * @return
	 */
	private String toTableString(String text) {
		String tName = text.substring(0, 1).toLowerCase();
		for (int i = 1; i < text.length(); i++) {
			if (!Character.isLowerCase(text.charAt(i))
					&& !Character.isDigit(text.charAt(i))) {
				tName += "_";
			}
			tName += text.substring(i, i + 1);
		}
		return tName.toLowerCase();
	}
}