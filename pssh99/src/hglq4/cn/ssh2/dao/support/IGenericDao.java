/*
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 蓝桥科技有限公司.
 */
package hglq4.cn.ssh2.dao.support;

import java.io.Serializable;
import java.util.List;

/** 
 * CopyRright (c)2008-2014:   <蓝桥软件BlueSoft> 
 * Project:  pssh99
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package hglq4.cn.ssh2.dao.support;
 * Author：      林为 
 * Create Date： 2014年8月15日 下午4:14:53
 * Modified By：  林为 
 * Modified Date: 2014年8月15日 下午4:14:53
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
public interface IGenericDao<T,ID extends Serializable>{

	abstract void save(T entity);
	abstract void delete(T entity);
	abstract void update(T entity);
	abstract T get(ID id);
	abstract List<T> list();
}
