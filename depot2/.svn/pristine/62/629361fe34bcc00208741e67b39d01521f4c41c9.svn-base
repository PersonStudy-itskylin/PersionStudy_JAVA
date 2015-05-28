/*
 * Copyright (c) 2005-2020 BeiJing Jidi Information Tech Co.,Ltd. All Rights Reserved.
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with 北京极地信息安全安全有限公司.
 */
package com.ssi.depot.util;

/** 
 * CopyRright (c)2005-2014:   <极地信息Jidi Information> 
 * Project:  depot
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>
 * Comments:  <对此类的描述，可以引用系统设计中的描述>
 * JDK version used: <JDK1.6>                              
 * Namespace: package com.ssi.depot.util;
 * Author：      林为 
 * Create Date： 2014年10月11日 上午10:53:03
 * Modified By：  林为 
 * Modified Date: 2014年10月11日 上午10:53:03
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
/**
 * @author 林为
 *
 */
public class StringUtil {

	/** 
	 * 方  法 名: ifNull
	 * 功能描述： 处理字符串为空，
	 * 输入参数: StringUtil
	 * 返 回 值:  不为空字符串
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月11日 上午10:53:18
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月11日 上午10:53:18
	 */
	public static String ifNull(String str) {
		if(str ==null || str.equals("null") || str.equals("")){
			str = "";
		}
		return str;
	}
	
	/** 
	 * 方  法 名: ifNumNull
	 * 功能描述： 
	 * 输入参数: StringUtil
	 * 返 回 值:  StringUtil
	 * 异    常：      <按照异常名字的字母顺序> 
	 * 创 建 人:  林为
	 * 创建日期: 2014年10月14日 下午4:40:38
	 * 修 改 人:  Blue_Sky
	 * 修改日期: 2014年10月14日 下午4:40:38
	 */
	public static Integer ifNumNull(String num) {
    	String str = ifNull(num);
    	if(str == ""){
    		str = "1";
    	}
    	return Integer.getInteger(str);
	}
}
