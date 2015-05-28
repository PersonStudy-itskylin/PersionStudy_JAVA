package controllers.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rbac.models.PrivilegeType;
import rbac.models.Role;

import com.et.mvc.JsonView;
import com.et.mvc.View;

import controllers.ApplicationController;

public class RoleController extends ApplicationController {
	public void index() throws Exception {
		List<PrivilegeType> types = PrivilegeType.findAll(PrivilegeType.class, null, null, "sort");
		request.setAttribute("types", types);
	}
	
	public View getRoles() throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("total", Role.count(Role.class, null, null));
		result.put("rows", Role.findAll(Role.class, null, null, "sort"));
		return new JsonView(result);
	}
	
	public View getRoleList() throws Exception{
		List<Role> items = Role.findAll(Role.class, null, null, "sort");
		return new JsonView(items);
	}
	
	public View save(Role role, String[] pids) throws Exception {
		Integer sort = (Integer)Role.maximum(Role.class, "sort", null, null);
		if (sort == null){
			sort = 1;
		} else {
			sort += 1;
		}
		role.setSort(sort);
		if (pids == null){
			role.setPrivilegeIds(null);
		} else {
			role.setPrivilegeIds(join(pids));
		}
		role.save();
		View view = new JsonView("success:true");
		view.setContentType("text/plain;charset=utf-8");
		return view;
	}
	
	public View update(int id, Map<String,Object> params, String[] pids) throws Exception {
		Role role = Role.find(Role.class, id);
		role = Role.updateModel(role, params);
		if (pids == null){
			role.setPrivilegeIds(null);
		} else {
			role.setPrivilegeIds(join(pids));
		}
		role.save();
		View view = new JsonView("success:true");
		view.setContentType("text/plain;charset=utf-8");
		return view;
	}
	
	public View move(int id, String dir) throws Exception {
		Role item = Role.find(Role.class, id);
		Role target = null;
		if (dir.equals("down")){
			target = Role.findFirst(Role.class, "sort>?", new Object[]{item.getSort()}, "sort asc");
		} else {
			target = Role.findFirst(Role.class, "sort<?", new Object[]{item.getSort()}, "sort desc");
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
	
	private  String join(String[] items) {
		String s = "";
		for(String item: items){
			s += item + ",";
		}
		return s.substring(0, s.length() - 1);
	}
}
