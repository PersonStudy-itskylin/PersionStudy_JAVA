package controllers.stock;

import java.util.Map;

import rbac.models.User;
import models.Bill;
import models.BillQuery;

import com.et.mvc.JsonView;
import com.et.mvc.View;

import controllers.BillController;

/**
 * 采购退货单
 *
 */
public class RtnPurchaseController extends BillController{
	public void index(){
		
	}
	
	public View getItems(BillQuery q, int rows, int page, String sort, String order) throws Exception{
		return super.getItems(11, q, rows, page, sort, order);
	}
	
	public View save(Bill item, String goods) throws Exception{
		User user = (User)rbac.getCurrentUser();
		
		item.setBillType(11);
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
