package rbac.models;

import com.et.ar.ActiveRecordBase;
import com.et.ar.annotations.BelongsTo;
import com.et.ar.annotations.Column;
import com.et.ar.annotations.Id;
import com.et.ar.annotations.Table;

@Table(name="users")
public class User extends ActiveRecordBase{
	@Id private Integer id;
	@Column private Integer departmentId;
	@Column private String name;
	@Column private String sex;
	@Column private String login;
	@Column private String password;
	@Column private String moNumber;
	@Column private String shortNumber;
	@Column private java.sql.Date inTime;
	@Column private java.sql.Date outTime;
	@Column private String roleIds;
	
	@BelongsTo(foreignKey="departmentId")
	private Department department;
	
	public String getRoles() throws Exception {
		if (roleIds == null) return null;
		String s = "";
		String[] ids = roleIds.split(",");
		for(String id: ids){
			Role role = Role.find(Role.class, id);
			if (role != null){
				s += role.getName() + ",";
			} else {
				s += id + ",";
			}
		}
		if (s.equals("")){
			return "";
		} else {
			return s.substring(0, s.length() - 1);
		}
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMoNumber() {
		return moNumber;
	}
	public void setMoNumber(String moNumber) {
		this.moNumber = moNumber;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getShortNumber() {
		return shortNumber;
	}

	public void setShortNumber(String shortNumber) {
		this.shortNumber = shortNumber;
	}

	public java.sql.Date getInTime() {
		return inTime;
	}

	public void setInTime(java.sql.Date inTime) {
		this.inTime = inTime;
	}

	public java.sql.Date getOutTime() {
		return outTime;
	}

	public void setOutTime(java.sql.Date outTime) {
		this.outTime = outTime;
	}
}
