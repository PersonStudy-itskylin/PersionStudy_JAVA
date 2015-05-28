package controllers.data;

import java.util.Map;

import models.Depot;

import com.et.mvc.JsonView;
import com.et.mvc.View;

import controllers.ApplicationController;

public class DepotController extends ApplicationController{
	public void index(){
		
	}
	
	public View getItems() throws Exception{
		return new JsonView(Depot.findAll(Depot.class));
	}
	
	public View save(Depot item) throws Exception{
		item.save();
		return new JsonView(item);
	}
	
	public View update(int id, Map<String,Object> params) throws Exception{
		Depot item = Depot.find(Depot.class, id);
		item = Depot.updateModel(item, params);
		item.save();
		return new JsonView(item);
	}
	
	public View destroy(int id) throws Exception{
		Depot item = Depot.find(Depot.class, id);
		item.destroy();
		return new JsonView("success:true");
	}
}
