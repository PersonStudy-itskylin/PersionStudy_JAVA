package controllers.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rbac.models.Department;
import rbac.models.User;

import com.et.mvc.JsonView;
import com.et.mvc.View;

import controllers.ApplicationController;

public class UserController extends ApplicationController {
	public void index(){
		
	}
	
	public View getItems(int page, int rows, Integer departmentId, String sort, String order) throws Exception {
		String orderBy = "id";
		if (sort != null && order != null){
			orderBy = sort + " " + order;
		}
		String cond = "1=1";
		if (departmentId != null){
			Department department = Department.find(Department.class, departmentId);
			cond += " and departmentId in (" + department.findChildIds() + ")";
		}
		
		long total = User.count(User.class, cond, null);
		List<User> items = User.findAll(User.class, cond, null, orderBy, rows, (page-1)*rows);
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("total", total);
		result.put("rows", items);
		
		return new JsonView(result);
	}
	
	public View save(User item, String[] rids) throws Exception {
		item.save();
		
		View view = new JsonView("success:true");
		view.setContentType("text/plain;charset=utf-8");
		return view;
	}
	
	public View update(int id, Map<String,Object> params, String[] rids) throws Exception {
		User item = User.find(User.class, id);
		item = User.updateModel(item, params);
		item.save();
		
		View view = new JsonView("success:true");
		view.setContentType("text/plain;charset=utf-8");
		return view;
	}
	
}
