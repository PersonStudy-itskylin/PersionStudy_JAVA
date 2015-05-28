package rbac.models;

import com.et.ar.ActiveRecordBase;
import com.et.ar.annotations.BelongsTo;
import com.et.ar.annotations.Column;
import com.et.ar.annotations.Id;
import com.et.ar.annotations.Table;

@Table(name="privileges")
public class Privilege extends ActiveRecordBase {
	@Id private Integer id;
	@Column private Integer privilegeTypeId;
	@Column private String name;
	@Column private String description;
	@Column private String urls;
	@Column private Integer sort;
	
	@BelongsTo(foreignKey="privilegeTypeId")
	private PrivilegeType privilegeType;
	
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
	public String getUrls() {
		return urls;
	}
	public void setUrls(String urls) {
		this.urls = urls;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getPrivilegeTypeId() {
		return privilegeTypeId;
	}
	public void setPrivilegeTypeId(Integer privilegeTypeId) {
		this.privilegeTypeId = privilegeTypeId;
	}
	public PrivilegeType getPrivilegeType() {
		return privilegeType;
	}
	public void setPrivilegeType(PrivilegeType privilegeType) {
		this.privilegeType = privilegeType;
	}
}
