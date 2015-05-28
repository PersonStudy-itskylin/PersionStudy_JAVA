package controllers.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rbac.models.Department;

import com.et.mvc.JsonView;
import com.et.mvc.View;

import controllers.ApplicationController;

public class DepartmentController extends ApplicationController {
	public void index(){
		
	}
	
	public View getItems() throws Exception {
		List<Map<String,Object>> items = new ArrayList<Map<String,Object>>();
		
		List<Department> departments = Department.findAll(Department.class, "parentId=0", null, "sort");
		for(Department department: departments){
			Map<String,Object> item = new HashMap<String,Object>();
			item.put("id", department.getId());
			item.put("text", department.getName());
			items.add(item);
		}
		
		List<Map<String,Object>> doing = new ArrayList<Map<String,Object>>();
		doing.addAll(items);
		while(!doing.isEmpty()){
			List<Map<String,Object>> todo = new ArrayList<Map<String,Object>>();
			for(Map<String,Object> item: doing){
				departments = Department.findAll(Department.class, "parentId=?", new Object[]{item.get("id")}, "sort");
				if (departments.isEmpty()){
					continue;
				}
				List<Object> children = new ArrayList<Object>();
				for(Department department: departments){
					Map<String,Object> child = new HashMap<String,Object>();
					child.put("id", department.getId());
					child.put("text", department.getName());
					child.put("state", department.getChildCount() > 0 ? "closed" : "open");
					children.add(child);
					
					todo.add(child);
				}
				item.put("children", children.toArray(new Object[children.size()]));
			}
			doing = todo;
		}
		
		return new JsonView(items);
	}
	
	public View save(Department item) throws Exception {
		Integer sort = (Integer)Department.maximum(Department.class, "sort", null, null);
		if (sort == null){
			sort = 0;
		}
		item.setSort(++sort);
		item.save();
		
		Map<String, Object> result = new HashMap<String,Object>();
		result.put("success", true);
		result.put("action", "append");
		result.put("id", item.getId());
		result.put("text", item.getName());
		View view = new JsonView(result);
		view.setContentType("text/plain; charset=utf-8");
		return view;
	}
	
	public View update(int id, Map<String,Object> params) throws Exception {
		Department item = Department.find(Department.class, id);
		item = Department.updateModel(item, params);
		item.save();
		
		Map<String, Object> result = new HashMap<String,Object>();
		result.put("success", true);
		result.put("action", "update");
		result.put("id", item.getId());
		result.put("text", item.getName());
		View view = new JsonView(result);
		view.setContentType("text/plain; charset=utf-8");
		return view;
	}
	
	public View dnd(Integer id, Integer targetId, String point) throws Exception {
		Department item = Department.find(Department.class, id);
		if (point.equals("append")){
			Integer sort = (Integer)Department.maximum(Department.class, "sort", null, null);
			if (sort == null){
				sort = 0;
			}
			item.setSort(++sort);
			item.setParentId(targetId);
		} else {
			Department target = Department.find(Department.class, targetId);
			item.setParentId(target.getParentId());
			if (point.equals("top")){
				Department.execute("update departments set sort=sort+1 where parentId=? and sort>=?", new Object[]{target.getParentId(), target.getSort()});
				item.setSort(target.getSort());
			} else {
				Department.execute("update departments set sort=sort+1 where parentId=? and sort>?", new Object[]{target.getParentId(), target.getSort()});
				item.setSort(target.getSort() + 1);
			}
		}
		item.save();
		return new JsonView("success:true");
	}
}
