package controllers.data;

import java.util.Map;

import models.MeasureUnit;

import com.et.mvc.JsonView;
import com.et.mvc.View;

import controllers.ApplicationController;

public class MeasureUnitController extends ApplicationController{
	public void index(){
		
	}
	
	public View getItems() throws Exception{
		return new JsonView(MeasureUnit.findAll(MeasureUnit.class));
	}
	
	public View save(MeasureUnit item) throws Exception{
		item.save();
		return new JsonView(item);
	}
	
	public View update(int id, Map<String,Object> params) throws Exception{
		MeasureUnit item = MeasureUnit.find(MeasureUnit.class, id);
		item = MeasureUnit.updateModel(item, params);
		item.save();
		return new JsonView(item);
	}
	
	public View destroy(int id) throws Exception{
		MeasureUnit item = MeasureUnit.find(MeasureUnit.class, id);
		item.destroy();
		return new JsonView("success:true");
	}
}
