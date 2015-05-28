package rbac.models;

import java.util.ArrayList;
import java.util.List;

import com.et.ar.ActiveRecordBase;
import com.et.ar.annotations.Column;
import com.et.ar.annotations.Id;
import com.et.ar.annotations.Table;

@Table(name="departments")
public class Department extends ActiveRecordBase {
	@Id private Integer id;
	@Column private Integer parentId;
	@Column private String name;
	@Column private Integer sort;
	
	public int getChildCount() throws Exception {
		return (int)count(Department.class, "parentId=?", new Object[]{id});
	}
	
	public String findChildIds() throws Exception {
		String s = "";
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(id);
		while(!ids.isEmpty()){
			int id = ids.remove(0);
			s += id + ",";
			for(Department department: Department.findAll(Department.class, "parentId=?", new Object[]{id})){
				ids.add(department.getId());
			}
		}
		if (!s.equals("")){
			s = s.substring(0, s.length() - 1);
		}
		return s;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
