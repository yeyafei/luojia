package com.yyf.www.luojia.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.yyf.www.luojia.core.Core;

/**
 * @Description: BaseService
 * @author yyf
 * @date 2018年3月19日 下午11:14:48
 * @version 1.0
 */
public class BaseService<T extends BaseBean, D extends BaseDao<T>> {

	@Autowired
	public D dao;

	/**
	 * 保存
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public boolean baseSave(T t) {
		return dao.baseSave(BaseSQL.getInstance().baseSave(t));
	}

	/**
	 * 根据传人值进行查询操作 注：id为0时及TempField注解字段不参与查询
	 * 
	 * @param t
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> baseSearch(T t) {
		List<Map<String, Object>> maps = dao.baseSearch(BaseSQL.getInstance().baseSearch(t));
		List<Object> os = Core.ML2PL(maps, t);
		List<T> ts = new ArrayList<T>();
		for (int i = 0; i < os.size(); i++) {
			ts.add((T) os.get(i));
		}
		return ts;

	}

	/**
	 * 查询 根据实体类的Primary值或者ID【主键查询】（实体类顺序查找的第一个作为跟新依据） 实体类中有一个唯一值即可（Primary 或 ID）
	 * 注：此sql返回值为一个对象
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T baseParSelect(T t) {
		Map map = dao.baseParSelect(BaseSQL.getInstance().baseParSelect(t));
		return (T) Core.M2P(map, t);
	}

	/**
	 * 删除 根据实体类的Primary值或者ID 实体类中有一个唯一值即可（Primary 或 ID） 注：物理删除
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public boolean baseParDel(T t) {
		return dao.baseParDel(BaseSQL.getInstance().baseParDel(t));
	}

	/**
	 * 更新 根据实体类的Primary值或者ID（实体类顺序查找的第一个作为跟新依据） 实体类中有一个唯一值即可（Primary 或 ID）
	 * 注1：如果根据查到的第一个之后的唯一值来跟新前面的唯一值 此方法无效 注2: 由于实体类默认String为"",不支持更新""操作,如有必要可以更新" "
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public boolean baseUpdate(T t) {
		return dao.baseUpdate(BaseSQL.getInstance().baseUpdate(t));
	}

}
