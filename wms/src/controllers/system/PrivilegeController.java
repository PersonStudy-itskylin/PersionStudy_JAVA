package controllers.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rbac.models.Privilege;
import rbac.models.PrivilegeType;

import com.et.mvc.JsonView;
import com.et.mvc.View;

import controllers.ApplicationController;

public class PrivilegeController extends ApplicationController {
	public void index() throws Exception {
	}
	
	public View getPrivileges(int privilegeTypeId, String sort, String order) throws Exception {
		String orderBy = "sort";
		if (sort != null && order != null){
			orderBy = sort + " " + order;
		}
		
		String cond = null;
		Object[] args = null;
		if (privilegeTypeId > 0){
			cond = "privilegeTypeId=?";
			args = new Object[]{privilegeTypeId};
		}
		long total = Privilege.count(Privilege.class, cond, args);
		List<Privilege> items = Privilege.findAll(Privilege.class, cond, args, orderBy);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("total", total);
		result.put("rows", items);
		return new JsonView(result);
	}
	
	public View getPrivilegeTree() throws Exception {
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		List<PrivilegeType> types = PrivilegeType.findAll(PrivilegeType.class, null, null, "sort");
		for(PrivilegeType type: types){
			Map<String,Object> group = new HashMap<String,Object>();
			group.put("id", "group-" + type.getId());
			group.put("text", type.getName());
			
			List<Privilege> privileges = Privilege.findAll(Privilege.class, "privilegeTypeId=?", new Object[]{type.getId()}, "sort");
			if (privileges.size() > 0){
				List<Map<String,Object>> children = new ArrayList<Map<String,Object>>();
				for(Privilege privilege: privileges){
					Map<String,Object> node = new HashMap<String,Object>();
					node.put("id", privilege.getId());
					node.put("text", privilege.getName());
					children.add(node);
				}
				group.put("children", children.toArray(new Object[]{children.size()}));
				group.put("state", "open");
			}
			result.add(group);
		}
		return new JsonView(result.toArray(new Object[result.size()]));
	}
	
	public View save(Privilege item) throws Exception {
		Integer sort = (Integer)Privilege.maximum(Privilege.class, "sort", null, null);
		if (sort == null){
			sort = 1;
		} else {
			sort += 1;
		}
		item.setSort(sort);
		item.save();
		View view = new JsonView("success:true");
		view.setContentType("text/plain;charset=utf-8");
		return view;
	}
	
	public View update(int id, Map<String,Object> params) throws Exception {
		Privilege item = Privilege.find(Privilege.class, id);
		item = Privilege.updateModel(item, params);
		item.save();
		View view = new JsonView("success:true");
		view.setContentType("text/plain;charset=utf-8");
		return view;
	}
	
	public View move(int id, String dir) throws Exception {
		Privilege item = Privilege.find(Privilege.class, id);
		Privilege target = null;
		if (dir.equals("down")){
			target = Privilege.findFirst(Privilege.class, "sort>?", new Object[]{item.getSort()}, "sort asc");
		} else {
			target = Privilege.findFirst(Privilege.class, "sort<?", new Object[]{item.getSort()}, "sort desc");
		}
		if (target != null){
			Integer tmp = target.getSort();
			target.setSort(item.getSort());
			target.save();
			item.setSort(tmp);
			item.save();
		}
		return new JsonView("success:true");
	}
}
