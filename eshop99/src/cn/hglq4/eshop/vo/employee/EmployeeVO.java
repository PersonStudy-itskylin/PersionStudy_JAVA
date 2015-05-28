/*   
 * Copyright (c) 2010-2020 蓝桥软件 Ltd. All Rights Reserved.     
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with 蓝桥科技有限公司.   
 *   
 */

package cn.hglq4.eshop.vo.employee;

/**
 * CopyRright (c)2008-2014: <蓝桥软件BlueSoft> Project: eshop99 Module ID:
 * <(模块)类编号，可以引用系统设计中的类编号> Comments: <对此类的描述，可以引用系统设计中的描述> JDK version used:
 * <JDK1.6> Namespace: cn.hglq4.eshop Author：张总监 Create Date： 2014年8月13日
 * Modified By： 张总监 Modified Date: 2014年8月13日 下午7:44:13 Why & What is modified:
 * <修改原因描述> Version: v1.0
 */

public class EmployeeVO {
	private Integer employeeId;
	private String account;
	private String pwd;
	private String roleId;
	private String lastLoginDate;
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	


}
