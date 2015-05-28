/*
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 蓝桥科技有限公司.
 */
package com.bolo.examples.dao.base;

import org.springframework.stereotype.Repository;

import com.bolo.examples.common.orm.hibernate3.HibernateDao;
import com.bolo.examples.entity.base.Comments;

/** 
 * CopyRright (c)2008-2014:   <蓝桥软件BlueSoft> 
 * Project:  nrs.hglq4.org
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.bolo.examples.dao.base;
 * Author：      林为 
 * Create Date： 2014年8月14日 下午4:51:45
 * Modified By：  林为 
 * Modified Date: 2014年8月14日 下午4:51:45
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
@Repository
public class CommentsDao extends HibernateDao<Comments> {
	
}
