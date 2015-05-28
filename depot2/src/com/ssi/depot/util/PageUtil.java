/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.util;

import java.util.HashMap;
import java.util.Map;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.util;
 * Author：      林为 
 * Create Date： 2014年10月20日 下午2:43:06
 * Modified By：  林为 
 * Modified Date: 2014年10月20日 下午2:43:06
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
public class PageUtil {

	/** 
	 * 方  法 名: page
	 * 功能描述： 分页工具
	 * 输入参数: PageUtil
	 * 返 回 值:  PageUtil
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月20日 下午2:43:36
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月20日 下午2:43:36
	 */
	public static Map<String,Integer> page(String page,String start,String limit) {
		Map<String,Integer> result = new HashMap<String, Integer>();
		result.put("start", Integer.valueOf(start));
		result.put("pageSize", Integer.valueOf(limit));
		result.put("page", Integer.valueOf(page));
		return result;
	}
}
