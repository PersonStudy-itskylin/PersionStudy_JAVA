package controllers.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rbac.models.PrivilegeType;

import com.et.mvc.JsonView;
import com.et.mvc.View;

import controllers.ApplicationController;

public class PrivilegeTypeController extends ApplicationController {
	public void index(){
		
	}
	
	public View getAll() throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		List<PrivilegeType> items = PrivilegeType.findAll(PrivilegeType.class, null, null, "sort");
		result.put("total", items.size());
		result.put("rows", items);
		return new JsonView(result);
	}
	
	public View getTypes() throws Exception {
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		Map<String,Object> node = new HashMap<String,Object>();
		node.put("id", 0);
		node.put("text", "全部类型");
		result.add(node);
		List<Map<String,Object>> children = new ArrayList<Map<String,Object>>();
		List<PrivilegeType> items = PrivilegeType.findAll(PrivilegeType.class, null, null, "sort");
		for(PrivilegeType item: items){
			Map<String,Object> child = new HashMap<String,Object>();
			child.put("id", item.getId());
			child.put("text", item.getName());
			children.add(child);
		}
		node.put("children", children.toArray(new Object[children.size()]));
		return new JsonView(result);
	}
	
	public View save(PrivilegeType type) throws Exception {
		Integer sort = (Integer)PrivilegeType.maximum(PrivilegeType.class, "sort", null, null);
		if (sort == null){
			sort = 1;
		} else {
			sort += 1;
		}
		type.setSort(sort);
		type.save();
		return new JsonView(type);
	}
	
	public View update(int id, Map<String, Object> params) throws Exception {
		PrivilegeType type = PrivilegeType.find(PrivilegeType.class, id);
		type = PrivilegeType.updateModel(type, params);
		type.save();
		return new JsonView(type);
	}
	
	public View destroy(int id) throws Exception {
		PrivilegeType type = PrivilegeType.find(PrivilegeType.class, id);
		type.destroy();
		return new JsonView("success:true");
	}
}
