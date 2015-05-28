package controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Bill;
import models.BillDetail;
import models.BillQuery;
import models.Good;
import rbac.models.User;
import service.CheckService;

import com.et.mvc.JsonView;
import com.et.mvc.View;

public class BillController extends ApplicationController{
	public View getInitDetails() throws Exception{
		List<Map<String,Object>> footer = new ArrayList<Map<String,Object>>();
		Map<String,Object> fitem = new HashMap<String,Object>();
		fitem.put("name", "合计");
		fitem.put("billCount", 0);
		fitem.put("billCost", 0);
		footer.add(fitem);
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("total", 0);
		result.put("rows", new Object[]{});
		result.put("footer", footer);
		return new JsonView(result);
	}
	
	public View getBillDetails(int billId) throws Exception{
		Bill bill = Bill.find(Bill.class, billId);
		
		List<Map<String,Object>> items = new ArrayList<Map<String,Object>>();
		for(BillDetail billDetail: bill.getBillDetails()){
			Map<String,Object> item = new HashMap<String,Object>();
			item.put("id", billDetail.getGoodId());
			Good good = billDetail.getGood();
			if (good != null){
				item.put("code", good.getCode());
				item.put("name", good.getName());
				item.put("spec", good.getSpec());
				item.put("model", good.getModel());
				item.put("color", good.getColor());
				item.put("unit", good.getUnit());
			}
			item.put("billCount", billDetail.getBillCount());
			item.put("billPrice", billDetail.getBillPrice());
			item.put("billCost", billDetail.getBillCost());
			item.put("billDetailId", billDetail.getBillDetailId());
			items.add(item);
		}
		
		List<Map<String,Object>> footer = new ArrayList<Map<String,Object>>();
		Map<String,Object> fitem = new HashMap<String,Object>();
		fitem.put("name", "合计");
		fitem.put("billCount", bill.getBillCount());
		fitem.put("billCost", bill.getBillCost());
		footer.add(fitem);
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("total", items.size());
		result.put("rows", items);
		result.put("footer", footer);
		return new JsonView(result);
	}
	
	public View getItems(int billType, BillQuery q,
			int rows, int page, String sort, String order) throws Exception{
		User user = (User)rbac.getCurrentUser();
		
		String orderBy = "id desc";
		if (sort != null && order != null){
			orderBy = sort + " " + order;
		}
		String cond = "billType=" + billType;
		List<Object> tmpArgs = new ArrayList<Object>();
		if (q != null){
			if (q.getCode() != null && !q.getCode().trim().equals("")){
				cond += " and (code like ?)";
				tmpArgs.add("%" + q.getCode().trim() + "%");
			}
			if (q.getCodeFrom() != null && !q.getCodeFrom().trim().equals("")){
				cond += " and code>=?";
				tmpArgs.add(q.getCodeFrom().trim());
			}
			if (q.getCodeTo() != null && !q.getCodeTo().trim().equals("")){
				cond += " and code<=?";
				tmpArgs.add(q.getCodeTo().trim());
			}
			if (q.getDateFrom() != null && !q.getDateFrom().trim().equals("")){
				cond += " and billDate>=?";
				tmpArgs.add(q.getDateFrom().trim());
			}
			if (q.getDateTo() != null && !q.getDateTo().trim().equals("")){
				cond += " and billDate<=?";
				tmpArgs.add(q.getDateTo().trim());
			}
			if (q.getIntercourseId() != null){
				cond += " and intercourseId=?";
				tmpArgs.add(q.getIntercourseId());
			}
			if (q.getDepotId() != null){
				cond += " and depotId=?";
				tmpArgs.add(q.getDepotId());
			}
			if (q.getDepot2Id() != null){
				cond += " and depot2Id=?";
				tmpArgs.add(q.getDepot2Id());
			}
		}
		Object[] args = tmpArgs.toArray();
		
		long total = Bill.count(Bill.class, cond, args);	// 查询到的记录数
		List<Map<String,Object>> items = new ArrayList<Map<String,Object>>();
		for(Bill bill: Bill.findAll(Bill.class, cond, args, orderBy, rows, (page-1)*rows)){
			Map<String,Object> item = new HashMap<String,Object>();
			item.put("id", bill.getId());
			item.put("code", bill.getCode());
			item.put("billDate", bill.getBillDate());
			item.put("status", bill.getStatus());
			if (bill.getIntercourse() != null){
				item.put("intercourseName", bill.getIntercourse().getShortName());
			}
			if (bill.getDepot() != null){
				item.put("depotName", bill.getDepot().getName());
			}
			if (bill.getDepot2() != null){
				item.put("depot2Name", bill.getDepot2().getName());
			}
			item.put("remark", bill.getRemark());
			item.put("billCount", bill.getBillCount());
			item.put("billCost", bill.getBillCost());
			// 确定该单据是否可编辑
			if (bill.getStatus() == 0 && bill.getWriteUserId() == user.getId().intValue()){
				item.put("editable", true);
			} else {
				item.put("editable", false);
			}
			items.add(item);
		}
			
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("total", total);
		result.put("rows", items);
		return new JsonView(result);
	}
	
	public void create() throws Exception{
		Bill bill = new Bill();
		bill.setCode("单据编号由系统自动生成");
		bill.setBillDate(new java.sql.Date(System.currentTimeMillis()));
		request.setAttribute("editable", true);
		request.setAttribute("checkable", false);
		request.setAttribute("bill", bill);
		request.setAttribute("detailUrl", "/bill/getInitDetails");
	}
	
	public void edit(int id) throws Exception{
		User user = (User)rbac.getCurrentUser();
		Bill bill = Bill.find(Bill.class, id);
		if (bill.getStatus() == 0 && bill.getWriteUserId() == user.getId().intValue()){
			request.setAttribute("editable", true);
		}
		if (bill.getStatus() == 0){
			request.setAttribute("checkable", true);
		}
		request.setAttribute("bill", bill);
		request.setAttribute("detailUrl", "/bill/getBillDetails?billId="+bill.getId());
	}
	
	public View checkBill(int id) throws Exception{
		User user = (User)rbac.getCurrentUser();
		String ok = CheckService.checkBill(id, user.getId());
		Map<String,Object> result = new HashMap<String,Object>();
		if (ok.equals("ok")){
			result.put("success", true);
			result.put("billId", id);
		} else {
			result.put("failure", true);
			result.put("msg", ok);
		}
		return new JsonView(result);
	}
	
	public View destroy(int id) throws Exception{
		User user = (User)rbac.getCurrentUser();
		
		Map<String,Object> result = new HashMap<String,Object>();
		Bill item = Bill.find(Bill.class, id);
		if (item.getStatus() == 0){
			if (item.getWriteUserId() != user.getId().intValue()){
				result.put("failure", true);
				result.put("msg", "对不起，你没有权限删除该单据。");
			} else {
				item.destroy();
				result.put("success", true);
			}
		} else {
			result.put("failure", true);
			result.put("msg", "该单据已经审核，不能删除。");
		}
		return new JsonView(result);
	}
	
	protected Map<String,Object> saveBill(Bill item, String goods) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		try{
			Bill.beginTransaction();
			
			if (item.getId() == null){
				switch(item.getBillType().intValue()){
					case 1:
						item.setCode(Bill.nextCode("RM"));
						break;
					case 11:
						item.setCode(Bill.nextCode("RP"));
						break;
					case 2:
						item.setCode(Bill.nextCode("SM"));
						break;
					case 3:
						item.setCode(Bill.nextCode("TR"));
						break;
				}
				item.save();
			}
			
			BillDetail.deleteAll(BillDetail.class, "billId=?", new Object[]{item.getId()});
			if (goods != null && !goods.trim().equals("")){
				int count = 0;
				BigDecimal cost = new BigDecimal(0);
				String[] rows = goods.trim().split(",");
				for(String row: rows){
					String[] fields = row.split(":");
					BillDetail detail = new BillDetail();
					detail.setBillId(item.getId());
					detail.setGoodId(Integer.parseInt(fields[0]));
					detail.setBillCount(Integer.parseInt(fields[1]));
					detail.setBillPrice(new BigDecimal(fields[2]));
					if (fields.length>=4){
						detail.setBillDetailId(Integer.valueOf(fields[3]));
					}
					detail.save();
					
					count += detail.getBillCount();
					cost = cost.add(detail.getBillPrice().multiply(new BigDecimal(detail.getBillCount())));
				}
				item.setBillCount(count);
				item.setBillCost(cost);
				item.save();
			} else {
				item.save();
			}
			
			Bill.commit();
			result.put("success", true);
			result.put("billId", item.getId());
		} catch(Exception ex){
			ex.printStackTrace();
			Bill.rollback();
			result.put("failure", true);
			result.put("msg", "单据保存过程出现错误：" + ex.getMessage());
		}
		return result;
	}

}
