package controllers.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Intercourse;
import models.IntercourseType;

import com.et.mvc.JsonView;
import com.et.mvc.View;

import controllers.ApplicationController;

public class IntercourseController extends ApplicationController{
	public void index(){
		
	}
	
	public View getItems(int intercourseTypeId, String q, String code, String name, String addr,
			String sort, String order, int rows, int page) throws Exception{
		String orderBy = "id";
		if (sort != null && order != null){
			orderBy = sort + " " + order;
		}
		
		String cond = "1=1";
		List<Object> tmpArgs = new ArrayList<Object>();
		IntercourseType intercourseType = IntercourseType.find(IntercourseType.class, intercourseTypeId);
		if (intercourseType != null){
			cond += " and intercourseTypeId in (" + intercourseType.findChildIds() + ")";
		}
		if (q != null && !q.trim().equals("")){
			cond += " and (code like ? or shortName like ? or fullName like ? or help like ?)";
			tmpArgs.add("%" + q.trim() + "%");
			tmpArgs.add("%" + q.trim() + "%");
			tmpArgs.add("%" + q.trim() + "%");
			tmpArgs.add("%" + q.trim() + "%");
		}
        if (code != null && !code.equals("")){
            cond += " and (code like ?)";
            tmpArgs.add("%"+code+"%");
        }
        if (name != null && !name.equals("")){
            cond += " and (shortName like ? or fullName like ?)";
            tmpArgs.add("%"+name+"%");
            tmpArgs.add("%"+name+"%");
        }
        if (addr != null && !addr.equals("")){
        	cond += " and (addr like ?)";
        	tmpArgs.add("%"+addr+"%");
        }
		Object[] args = tmpArgs.toArray();
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("total", Intercourse.count(Intercourse.class, cond, args));
		result.put("rows", Intercourse.findAll(Intercourse.class, cond, args, orderBy, rows, (page-1)*rows));
		return new JsonView(result);
	}
	
	public View save(Intercourse item) throws Exception{
		item.save();
		View view = new JsonView("success:true");
		view.setContentType("text/plain;charset=utf-8");
		return view;
	}
	
	public View update(int id, Map<String,Object> params) throws Exception{
		Intercourse item = Intercourse.find(Intercourse.class, id);
		item = Intercourse.updateModel(item, params);
		item.save();
		View view = new JsonView("success:true");
		view.setContentType("text/plain;charset=utf-8");
		return view;
	}
}
