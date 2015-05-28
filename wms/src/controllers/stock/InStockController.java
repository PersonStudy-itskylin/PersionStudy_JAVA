package controllers.stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Bill;
import models.BillDetail;
import models.BillQuery;
import models.Good;
import rbac.models.User;

import com.et.mvc.JsonView;
import com.et.mvc.View;

import controllers.BillController;

/**
 * 入库单管理
 *
 */
public class InStockController extends BillController{
	public void index(){
		
	}
	
	public View getItems(BillQuery q, int rows, int page, String sort, String order) throws Exception{
		return super.getItems(1, q, rows, page, sort, order);
	}
	
	public View getRtnGoods(Integer depotId, Integer intercourseId, String dateFrom, String dateTo,
			int rows, int page) throws Exception{
		List<Object> tmpArgs = new ArrayList<Object>();
		String cond = "(billCount>rtnCount or rtnCount is null) and billId in (select id from bills where billType=1 and status=1 ";
		if (depotId != null){
			cond += " and depotId=" + depotId;
		}
		if (intercourseId != null){
			cond += " and intercourseId=" + intercourseId;
		}
		if (dateFrom != null && !dateFrom.trim().equals("")){
			cond += " and billDate>=?";
			tmpArgs.add(dateFrom.trim());
		}
		if (dateTo != null && !dateTo.trim().equals("")){
			cond += " and billDate<=?";
			tmpArgs.add(dateTo.trim());
		}
		cond += ")";
		Object[] args = tmpArgs.toArray();
		
		long total = BillDetail.count(BillDetail.class, cond, args);
		List<Map<String,Object>> items = new ArrayList<Map<String,Object>>();
		for(BillDetail billDetail: BillDetail.findAll(BillDetail.class, cond, args, "id", rows, (page-1)*rows)){
			Map<String,Object> item = new HashMap<String,Object>();
			Good good = billDetail.getGood();
			if (good != null){
				item = good.getAttributes();
			} else {
				item.put("id", billDetail.getGoodId());
			}
			item.put("billDetailId", billDetail.getId());
			item.put("billCount", billDetail.getBillCount());
			item.put("rtnCount", billDetail.getRtnCount());
			item.put("billPrice", billDetail.getBillPrice());
			Bill bill = Bill.find(Bill.class, billDetail.getBillId());
			if (bill != null){
				item.put("billCode", bill.getCode());
				item.put("billDate", bill.getBillDate());
			}
			items.add(item);
		}
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("total", total);
		result.put("rows", items);
		return new JsonView(result);
	}
	
	public View save(Bill item, String goods) throws Exception{
		User user = (User)rbac.getCurrentUser();
		
		item.setBillType(1);
		item.setWriteUserId(user.getId());
		item.setWriteDate(new java.sql.Timestamp(System.currentTimeMillis()));
		item.setStatus(0);
		
		Map<String,Object> result = super.saveBill(item, goods);
		
		View view = new JsonView(result);
		view.setContentType("text/plain;charset=utf-8");
		return view;
	}
	
	public View update(int id, Map<String,Object> params, String goods) throws Exception{
		User user = (User)rbac.getCurrentUser();
		
		Bill item = Bill.find(Bill.class, id);
		item = Bill.updateModel(item, params);
		item.setWriteUserId(user.getId());
		item.setWriteDate(new java.sql.Timestamp(System.currentTimeMillis()));
		
		Map<String,Object> result = super.saveBill(item, goods);
		
		View view = new JsonView(result);
		view.setContentType("text/plain;charset=utf-8");
		return view;
	}
}
