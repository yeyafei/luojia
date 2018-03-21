package com.yyf.www.luojia.base;

import java.io.Serializable;

import com.yyf.www.luojia.core.V;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** 
* @Description: BaseEntity
* @author  yyf 
* @date    2018年3月19日 下午11:12:42 
* @version 1.0 
*/
@Data
@EqualsAndHashCode(callSuper=false)
public class BaseBean extends V  implements Serializable {
	private static final long serialVersionUID = 1L;

}

