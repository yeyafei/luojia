package com.yyf.www.luojia.core;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yyf.www.luojia.exceptions.ReflectException;

public class Core implements Cloneable {
	/**
	 * map -> po
	 * 
	 * @param map
	 * @param o
	 * @return
	 * @throws Exception
	 */
	public static Object M2P(Map<String, Object> map, Object o) {
		try {
			if (!map.isEmpty()) {
				for (String k : map.keySet()) {
					Object v = "";
					if (!k.isEmpty()) {
						v = map.get(k);
					}
					Field[] fields = null;
					fields = o.getClass().getDeclaredFields();
					for (Field field : fields) {
						int mod = field.getModifiers();
						if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
							continue;
						}
						if (toTableString(field.getName()).equals(k)) { // 转驼峰
							field.setAccessible(true);
							field.set(o, v);
							continue;
						}
					}
				}
			}
		} catch (Exception e) {
			throw new ReflectException("Clone对象失败！");
		}

		return o;
	}

	/**
	 * mapList -> poList
	 * 
	 * @param map
	 * @param o
	 * @return
	 * @throws Exception
	 */
	public static List<Object> ML2PL(List<Map<String, Object>> maps, Object o) {

		List<Object> os = new ArrayList<Object>();
		try {
			for (Map<String, Object> map : maps) {
				Object o2 = new Object();
				o2 = Clone.deepClone(o); // 此处要进行复制操作到另外一个引用对象
				os.add(M2P(map, o2));
			}
		} catch (Exception e) {
			throw new ReflectException("Clone对象失败！");
		}
		return os;
	}

	/**
	 * po -> map
	 * 
	 * @param o
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> P2M(Object o) {
		Map<String, Object> map = new HashMap<String, Object>();
		Field[] fields = null;
		fields = o.getClass().getDeclaredFields();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				String proName = field.getName();
				Object proValue = field.get(o);
				map.put(proName, proValue);
			}
		} catch (Exception e) {
			throw new ReflectException("Clone对象失败！");
		}
		return map;
	}

	/**
	 * 驼峰标识转下划线标识 非小写和数字加"_"
	 * 
	 * @param text
	 * @return
	 */
	private static String toTableString(String text) {
		String tName = text.substring(0, 1).toLowerCase();
		for (int i = 1; i < text.length(); i++) {
			if (!Character.isLowerCase(text.charAt(i)) && !Character.isDigit(text.charAt(i))) {
				tName += "_";
			}
			tName += text.substring(i, i + 1);
		}
		return tName.toLowerCase();
	}

}
