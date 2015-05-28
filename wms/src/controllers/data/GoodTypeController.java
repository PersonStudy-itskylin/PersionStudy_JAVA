package controllers.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.GoodType;

import com.et.mvc.JsonView;
import com.et.mvc.View;

import controllers.ApplicationController;

public class GoodTypeController extends ApplicationController{
	public void index(){
		
	}
	
	/**
	 * 获取树数据
	 * @return
	 * @throws Exception
	 */
	public View getTree() throws Exception{
		List<Map<String,Object>> nodes = new ArrayList<Map<String,Object>>();
		
		// 获取一级节点
		List<GoodType> types = GoodType.findAll(GoodType.class, "parentId=0", null, "sort");
		for(GoodType type: types){
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
				types = GoodType.findAll(GoodType.class, "parentId=?", new Object[]{item.get("id")}, "sort");
				if (types.isEmpty()) continue;
				
				List<Object> children = new ArrayList<Object>();
				for(GoodType type: types){
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
	
	/**
	 * 获取列表数据
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public View getItems(Integer parentId) throws Exception{
		String cond = null;
		if (parentId != null){
			cond = "parentId=" + parentId;
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("total", GoodType.count(GoodType.class, cond, null));
		result.put("rows", GoodType.findAll(GoodType.class, cond, null, "sort"));
		return new JsonView(result);
	}
	
	public View save(GoodType item) throws Exception{
		Integer sort = (Integer)GoodType.maximum(GoodType.class, "sort", null, null);
		if (sort == null){
			sort = 0;
		}
		item.setSort(++sort);
		item.save();
		return new JsonView(item);
	}
	
	public View update(int id, Map<String,Object> params) throws Exception{
		GoodType item = GoodType.find(GoodType.class, id);
		item = GoodType.updateModel(item, params);
		item.save();
		return new JsonView(item);
	}
	
	public View destroy(int id) throws Exception{
		GoodType item = GoodType.find(GoodType.class, id);
		item.destroy();
		return new JsonView("success:true");
	}
	
	/**
	 * 处理节点拖放操作
	 * @param id
	 * @param targetId
	 * @param point 'append','top','bottom'
	 * @return
	 * @throws Exception
	 */
	public View dnd(Integer id, Integer targetId, String point) throws Exception{
		GoodType type = GoodType.find(GoodType.class, id);
		if (point.equals("append")){
			Integer sort = (Integer)GoodType.maximum(GoodType.class, "sort", null, null);
			if (sort == null){
				sort = 0;
			}
			type.setParentId(targetId);
			type.setSort(++sort);
			type.save();
		} else {
			GoodType target = GoodType.find(GoodType.class, targetId);
			type.setParentId(target.getParentId());
			if (point.equals("top")){
				GoodType.execute("update goodTypes set sort=sort+1 where parentId=? and sort>=?", new Object[]{target.getParentId(), target.getSort()});
				type.setSort(target.getSort());
			} else {
				GoodType.execute("update goodTypes set sort=sort+1 where parentId=? and sort>?", new Object[]{target.getParentId(), target.getSort()});
				type.setSort(target.getSort() + 1);
			}
		}
		type.save();
		return new JsonView("success:true");
	}
}
