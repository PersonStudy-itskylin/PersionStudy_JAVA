package controllers.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.IntercourseType;

import com.et.mvc.JsonView;
import com.et.mvc.View;

import controllers.ApplicationController;

public class IntercourseTypeController extends ApplicationController{
	public void index(){
		
	}
	
	public View getTree() throws Exception{
		List<Map<String,Object>> nodes = new ArrayList<Map<String,Object>>();
		
		// 获取一级节点
		List<IntercourseType> types = IntercourseType.findAll(IntercourseType.class, "parentId=0", null, "sort");
		for(IntercourseType type: types){
			Map<String,Object> node = new HashMap<String,Object>();
			node.put("id", type.getId());
			node.put("text", type.getName());
			nodes.add(node);
		}
		
		// 循环获取全部子节点
		List<Map<String,Object>> doing = new ArrayList<Map<String,Object>>();
		doing.addAll(nodes);
		while(!doing.isEmpty()){
			List<Map<String,Object>> todo = new ArrayList<Map<String,Object>>();
			for(Map<String,Object> item: doing){
				types = IntercourseType.findAll(IntercourseType.class, "parentId=?", new Object[]{item.get("id")}, "sort");
				if (types.isEmpty()) continue;
				List<Object> children = new ArrayList<Object>();
				for(IntercourseType type: types){
					Map<String,Object> node = new HashMap<String,Object>();
					node.put("id", type.getId());
					node.put("text", type.getName());
					children.add(node);
					todo.add(node);
				}
				item.put("children", children.toArray(new Object[children.size()]));
			}
			doing = todo;
		}
		
		return new JsonView(nodes);
	}
	
	public View getItems(Integer parentId) throws Exception{
		String cond = null;
		if (parentId != null){
			cond = "parentId=" + parentId;
		}
		return new JsonView(IntercourseType.findAll(IntercourseType.class, cond, null, "sort"));
	}
	
	public View save(IntercourseType item) throws Exception{
		Integer sort = (Integer)IntercourseType.maximum(IntercourseType.class, "sort", null, null);
		if (sort == null){
			sort = 0;
		}
		item.setSort(++sort);
		item.save();
		return new JsonView(item);
	}
	
	public View update(int id, Map<String,Object> params) throws Exception{
		IntercourseType item = IntercourseType.find(IntercourseType.class, id);
		item = IntercourseType.updateModel(item, params);
		item.save();
		return new JsonView(item);
	}
	
	public View destroy(int id) throws Exception{
		IntercourseType item = IntercourseType.find(IntercourseType.class, id);
		item.destroy();
		return new JsonView("success:true");
	}
	
	public View dnd(Integer id, Integer targetId, String point) throws Exception{
		IntercourseType item = IntercourseType.find(IntercourseType.class, id);
		if (point.equals("append")){
			Integer sort = (Integer)IntercourseType.maximum(IntercourseType.class, "sort", null, null);
			if (sort == null){
				sort = 0;
			}
			item.setParentId(targetId);
			item.setSort(++sort);
			item.save();
		} else {
			IntercourseType target = IntercourseType.find(IntercourseType.class, targetId);
			item.setParentId(target.getParentId());
			if (point.equals("top")){
				IntercourseType.execute("update intercourseTypes set sort=sort+1 where parentId=? and sort>=?", new Object[]{target.getParentId(), target.getSort()});
				item.setSort(target.getSort());
			} else {
				IntercourseType.execute("update intercourseTypes set sort=sort+1 where parentId=? and sort>?", new Object[]{target.getParentId(), target.getSort()});
				item.setSort(target.getSort() + 1);
				
			}
		}
		item.save();
		return new JsonView("success:true");
	}
}
