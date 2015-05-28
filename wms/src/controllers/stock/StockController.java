package controllers.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Depot;
import models.GoodType;
import models.Stock;

import com.et.mvc.JsonView;
import com.et.mvc.View;

import controllers.BillController;

/**
 * 库存状态查询
 *
 */
public class StockController extends BillController{
	/**
	 * 库存数量表
	 */
	public void index1(){
		
	}
	
	/**
	 * 库存状况表
	 */
	public void index2(){
		
	}
	
	public View getItem(Integer depotId, Integer goodId) throws Exception{
		String sql = "select * from stocks left join goods on goods.id=stocks.goodId";
		sql += " where depotId=" + depotId + " and goodId=" + goodId;
		List<Map<String,Object>> items = Stock.getResultMap(Stock.class, sql, null, null, 0, 0);
		if (items.size() == 0){
			return null;
		} else {
			return new JsonView(items.get(0));
		}
	}
	
	public View getItems(Integer depotId, Integer goodTypeId, String q,
			int rows, int page, String sort, String order) throws Exception{
		String orderBy = "stocks.id";
		if (sort != null && order != null){
			orderBy = sort + " " + order;
		}
		String sql = "select * from stocks left join goods on goods.id=stocks.goodId";
		String cond = "1=1";
		List<Object> tmpArgs = new ArrayList<Object>();
		if (depotId != null){
			cond += " and depotId=" + depotId;
		}
		if (goodTypeId != null){
			GoodType goodType = GoodType.find(GoodType.class, goodTypeId);
			if (goodType != null){
				String goodTypeIds = goodType.findChildIds();
				cond += " and goodId in (select id from goods where goodTypeId in (" + goodTypeIds + "))";
			}
		}
		if (q != null && !q.trim().equals("")){
			cond += " and goodId in (select id from goods where code like ? or name like ? or help like ?)";
			tmpArgs.add("%" + q.trim() + "%");
			tmpArgs.add("%" + q.trim() + "%");
			tmpArgs.add("%" + q.trim() + "%");
		}
		Object[] args = tmpArgs.toArray();
		
		long total = Stock.count(Stock.class, cond, args);
		List<Map<String,Object>> items = new ArrayList<Map<String,Object>>();
		for(Map<String,Object> item: Stock.getResultMap(Stock.class, sql + " where " + cond, args, orderBy, rows, (page-1)*rows)){
			Depot depot = Depot.find(Depot.class, item.get("depotid"));
			if (depot != null){
				item.put("depotName", depot.getName());
			}
			items.add(item);
		}
		
		List<Map<String,Object>> footer = new ArrayList<Map<String,Object>>();
		Map<String,Object> fitem = new HashMap<String,Object>();
		fitem.put("name", "合计");
		fitem.put("count", Stock.executeScalar("select sum(count) from stocks where " + cond, args));
		fitem.put("cost", Stock.executeScalar("select sum(cost) from stocks where " + cond, args));
		footer.add(fitem);
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("total", total);
		result.put("rows", items);
		result.put("footer", footer);
		return new JsonView(result);
	}
}
