package com.yyf.www.luojia.base;

import java.util.List;

import com.yyf.www.luojia.core.Pram;
import com.yyf.www.luojia.core.SqlCore;
import com.yyf.www.luojia.core.V;
import com.yyf.www.luojia.exceptions.ReflectException;

/** 
 * @Description: SQL拼接操作类
 * @author  yyf 
 * @date    2018年3月21日 下午2:13:17 
 * @version 1.0 
 */
public class BaseSQL<T extends 	V> {

	private SqlCore<?> sc;

	private BaseSQL() {
		this.sc = SqlCore.getInstance();
	}

	private static BaseSQL<V> instance = null;

	public static synchronized BaseSQL<V> getInstance() {
		if (instance == null)
			instance = new BaseSQL<V>();
		return instance;
	}

	/**
	 * 数据库新增操作
	 * 
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public String baseSave(T t)  {
	String tableName = this.sc.getTableName(t);
		String sql = "insert into " + tableName + " (";
		String prams = "";
		String values = "";
		List<Pram> pramList = this.sc.getPramList(t);
		for (int i = 0; i < pramList.size(); i++) {
			prams += pramList.get(i).getFile();
			if (pramList.get(i).getValue() == null) {
				values += "null";
			} else {
				values += "'" + pramList.get(i).getValue() + "'";
			}
			if (i < pramList.size() - 1) {
				prams += ",";
				values += ",";
			}
		}
		sql += prams + ") value (" + values + ");";
		System.out.println(sql);
		return sql;
	}
/**
 * 数据库查询操作 根据实体类的值进行绝对查询
 * @param t
 * @return
 */
	public String baseSearch(T t){
		String tableName = this.sc.getTableName(t);
		List<Pram> pramList = this.sc.getAllPramList(t);
		String sql = "select * from " + tableName + " where 1=1 ";
		for (int i = 0; i < pramList.size(); i++) {
			if ("id".equals(pramList.get(i).getFile().toLowerCase())) {
				if (!"0".equals(pramList.get(i).getValue().toString()))
					sql += "and " + pramList.get(i).getFile() + " = '"
							+ pramList.get(i).getValue() + "' ";
			} else {
				if (pramList.get(i).getValue() != null
						&& !"".equals(pramList.get(i).getValue().toString()
								.trim()))
					sql += "and " + pramList.get(i).getFile() + " = '"
							+ pramList.get(i).getValue() + "' ";
			}
		}
		System.out.println(sql);
		return sql;
	}
	
	/**
	 * 数据库查询操作 根据实体类的Primary值或者ID【主键查询】（实体类顺序查找的第一个作为跟新依据） 实体类中有一个唯一值即可（Primary 或 ID）
	 * 注：此sql返回值为一个对象
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public String baseParSelect(T t)  {
		String tableName = this.sc.getTableName(t);
		Pram pram = this.sc.getPrimaryName(t);
		if (pram == null) {
			throw new ReflectException("实体类无查询条件数据！");
		}
		String sql = "select * from " + tableName + " where " + pram.getFile()
				+ "='" + pram.getValue() + "'";
		System.out.println(sql);
		return sql;
	}

	/**
	 * 数据库删除操作 根据实体类的Primary值或者ID 实体类中有一个唯一值即可（Primary 或 ID） 注：物理删除
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public String baseParDel(T t){
		String tableName = this.sc.getTableName(t);
		Pram pram = this.sc.getPrimaryName(t);
		if (pram == null) {
			throw new ReflectException("实体类无查询条件数据！");
		}
		String sql = "delete from " + tableName + " where " + pram.getFile()
				+ "='" + pram.getValue() + "'";
		System.out.println(sql);
		return sql;
	}
	
	/**
	 * 数据库跟新操作 根据实体类的Primary值或者ID（实体类顺序查找的第一个作为跟新依据） 实体类中有一个唯一值即可（Primary 或 ID）
	 * 注1：如果根据查到的第一个之后的唯一值来跟新前面的唯一值 此方法无效 注2:
	 * 由于实体类默认String为"",不支持更新""操作,如有必要可以更新" "
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public String baseUpdate(T t) {
		String tableName = this.sc.getTableName(t);
		Pram pram = this.sc.getPrimaryName(t);
		if (pram == null) {
			throw new ReflectException("实体类无查询条件数据！");
		}
		List<Pram> pramList = this.sc.getPramList(t);
		String s = "";
		for (int i = 0; i < pramList.size(); i++) {
			if (pramList.get(i).getValue() != null
					&& !"".equals(pramList.get(i).getValue().toString().trim())) {
				s += pramList.get(i).getFile() + "= '"
						+ pramList.get(i).getValue() + "'";
				if (i < pramList.size() - 1) {
					s += ",";

				}
			}
		}
		if ("".equals(s)) {
			throw new ReflectException("实体类无更新数据！");
		}
		if (s.endsWith(",")) {
			s = s.substring(0, s.length() - 1);
		}
		String sql = "update " + tableName + " set " + s + " where "
				+ pram.getFile() + "='" + pram.getValue() + "'";
		System.out.println(sql);
		return sql;
	}

}
