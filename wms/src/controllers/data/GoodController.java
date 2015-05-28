package controllers.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Good;
import models.GoodType;

import com.et.mvc.JsonView;
import com.et.mvc.View;

import controllers.ApplicationController;

public class GoodController extends ApplicationController{
	public void index() throws Exception{
		
	}
	
	public View getItems(int goodTypeId, String q, String code, String name, String spec, String model,
			String sort, String order, int rows, int page) throws Exception{
		String orderBy = "id";
		if (sort != null && order != null){
			orderBy = sort + " " + order;
		}
		
		String cond = "1=1";
		List<Object> tmpArgs = new ArrayList<Object>();
		
		GoodType goodType = GoodType.find(GoodType.class, goodTypeId);
		if (goodType != null){
			cond += " and goodTypeId in (" + goodType.findChildIds() + ")";
		}
		if (q != null && !q.trim().equals("")){
			cond += " and (code like ? or name like ? or help like ?)";
			tmpArgs.add("%" + q.trim() + "%");
			tmpArgs.add("%" + q.trim() + "%");
			tmpArgs.add("%" + q.trim() + "%");
		}
        if (code != null && !code.equals("")){
            cond += " and (code like ?)";
            tmpArgs.add("%"+code+"%");
        }
        if (name != null && !name.equals("")){
            cond += " and (name like ?)";
            tmpArgs.add("%"+name+"%");
        }
        if (spec != null && !spec.equals("")){
            cond += " and (spec like ?)";
            tmpArgs.add("%"+spec+"%");
        }
        if (model != null && !model.equals("")){
        	cond += " and (model like ?)";
        	tmpArgs.add("%"+model+"%");
        }
		Object[] args = tmpArgs.toArray();
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("total", Good.count(Good.class, cond, args));
		result.put("rows", Good.findAll(Good.class, cond, args, orderBy, rows, (page-1)*rows));
		return new JsonView(result);
	}
	
	public View save(Good item) throws Exception{
		item.save();
		View view = new JsonView("success:true");
		view.setContentType("text/plain;charset=utf-8");
		return view;
	}
	
	public View update(int id, Map<String,Object> params) throws Exception{
		Good item = Good.find(Good.class, id);
		item = Good.updateModel(item, params);
		item.save();
		View view = new JsonView("success:true");
		view.setContentType("text/plain;charset=utf-8");
		return view;
	}
}
