package rbac.models;

import com.et.ar.ActiveRecordBase;
import com.et.ar.annotations.Column;
import com.et.ar.annotations.Id;
import com.et.ar.annotations.Table;

@Table(name="roles")
public class Role extends ActiveRecordBase {
	@Id private Integer id;
	@Column private String name;
	@Column private String description;
	@Column private String privilegeIds;
	@Column private Integer sort;
	
	public String getPrivileges() throws Exception {
		if (privilegeIds == null) return null;
		String s = "";
		String[] ids = privilegeIds.split(",");
		for(String id: ids){
			Privilege privilege = Privilege.find(Privilege.class, id);
			if (privilege != null){
				s += privilege.getName() + ",";
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getPrivilegeIds() {
		return privilegeIds;
	}
	public void setPrivilegeIds(String privilegeIds) {
		this.privilegeIds = privilegeIds;
	}
}
