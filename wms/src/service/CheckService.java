package service;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import models.Bill;
import models.BillDetail;
import models.Intercourse;
import models.Stock;

public class CheckService {
	public static String checkBill(Integer billId, Integer userId) throws Exception{
		Bill bill = Bill.find(Bill.class, billId);
		String methodName = "check" + bill.getBillType();
		Method method = CheckService.class.getDeclaredMethod(methodName, Integer.class, Integer.class);
		String result = (String)method.invoke(CheckService.class, billId, userId);
		return result;
	}
	
	protected static String check1(Integer billId, Integer userId) throws Exception{
		Bill bill = Bill.find(Bill.class, billId);
		if (bill.getStatus() == 1){
			return "该单据已经审核过，不能再审核。";
		}
		try{
			Bill.beginTransaction();
			
			for(BillDetail billDetail: bill.getBillDetails()){
				if (billDetail.getBillCount() == null || billDetail.getBillCount() == 0){
					continue;
				}
				Stock stock = Stock.findFirst(Stock.class, "goodId=? and depotId=?", new Object[]{billDetail.getGoodId(), bill.getDepotId()});
				if (stock == null){
					stock = new Stock();
					stock.setDepotId(bill.getDepotId());
					stock.setGoodId(billDetail.getGoodId());
					stock.setCount(billDetail.getBillCount());
					stock.setPrice(billDetail.getBillPrice());
					stock.setCost(billDetail.getBillCost());
					stock.save();
				} else {
					stock.setCount(stock.getCount() + billDetail.getBillCount());
					if (stock.getCount() == 0){
						stock.destroy();
					} else {
						stock.setCost(stock.getCost().add(billDetail.getBillCost()));
						stock.setPrice(stock.getCost().divide(new BigDecimal(stock.getCount()), 4, BigDecimal.ROUND_HALF_UP));
						stock.save();
					}
				}
			}
			
			Intercourse intercourse = bill.getIntercourse();
			if (intercourse != null){
				if (intercourse.getPayCost() == null){
					intercourse.setPayCost(bill.getBillCost());
				} else {
					intercourse.setPayCost(intercourse.getPayCost().add(bill.getBillCost()));
				}
				intercourse.save();
			}
			
			bill.setCheckUserId(userId);
			bill.setCheckDate(new java.sql.Timestamp(System.currentTimeMillis()));
			bill.setStatus(1);
			bill.save();
			
			Bill.commit();
		} catch (Exception ex){
			Bill.rollback();
			return "审核单据出错：" + ex.getMessage();
		}
		return "ok";
	}
	
	protected static String check11(Integer billId, Integer userId) throws Exception{
		Bill bill = Bill.find(Bill.class, billId);
		if (bill.getStatus() == 1){
			return "该单据已经审核过，不能再审核。";
		}
		try{
			Bill.beginTransaction();
			
			for(BillDetail billDetail: bill.getBillDetails()){
				if (billDetail.getBillCount() == null || billDetail.getBillCount() == 0){
					continue;
				}
				BillDetail sourceDetail = BillDetail.find(BillDetail.class, billDetail.getBillDetailId());
				if (sourceDetail != null){
					if (sourceDetail.getRtnCount() == null){
						sourceDetail.setRtnCount(billDetail.getBillCount());
					} else {
						sourceDetail.setRtnCount(sourceDetail.getRtnCount() + billDetail.getBillCount());
					}
					sourceDetail.save();
				}
				
				Stock stock = Stock.findFirst(Stock.class, "goodId=? and depotId=?", new Object[]{billDetail.getGoodId(), bill.getDepotId()});
				if (stock == null){
					Bill.rollback();
					return "退货时仓库中找不到货物：" + billDetail.getGood().getName();
				}
				if (stock.getCount() < billDetail.getBillCount()){
					Bill.rollback();
					return "退货时库存数量不足：" + billDetail.getGood().getName();
				}
				stock.setCount(stock.getCount() - billDetail.getBillCount());
				if (stock.getCount() == 0){
					stock.destroy();
				} else {
					stock.setCost(stock.getCost().subtract(billDetail.getBillCost()));
					stock.setPrice(stock.getCost().divide(new BigDecimal(stock.getCount()), 4, BigDecimal.ROUND_HALF_UP));
					stock.save();
				}
			}
			
			Intercourse intercourse = bill.getIntercourse();
			if (intercourse != null){
				if (intercourse.getPayCost() != null){
					intercourse.setPayCost(intercourse.getPayCost().subtract(bill.getBillCost()));
				} else {
					intercourse.setPayCost(bill.getBillCost().multiply(new BigDecimal("-1")));
				}
				intercourse.save();
			}
			
			bill.setCheckUserId(userId);
			bill.setCheckDate(new java.sql.Timestamp(System.currentTimeMillis()));
			bill.setStatus(1);
			bill.save();
			
			Bill.commit();
		} catch(Exception ex){
			Bill.rollback();
			return "审核单据出错：" + ex.getMessage();
		}
		return "ok";
	}
	
	protected static String check2(Integer billId, Integer userId) throws Exception{
		Bill bill = Bill.find(Bill.class, billId);
		if (bill.getStatus() == 1){
			return "该单据已经审核过，不能再审核。";
		}
		try{
			Bill.beginTransaction();
			
			for(BillDetail billDetail: bill.getBillDetails()){
				if (billDetail.getBillCount() == null || billDetail.getBillCount() == 0){
					continue;
				}
				Stock stock = Stock.findFirst(Stock.class, "depotId=? and goodId=?", new Object[]{bill.getDepotId(), billDetail.getGoodId()});
				if (stock == null){
					Bill.rollback();
					return "出库时仓库中找不到货物：" + billDetail.getGood().getName();
				}
				if (billDetail.getBillCount() > stock.getCount().intValue()){
					Bill.rollback();
					return "出库时库存数量不足：" + billDetail.getGood().getName();
				}
				stock.setCount(stock.getCount() - billDetail.getBillCount());
				if (stock.getCount() == 0){
					stock.destroy();
				} else {
					stock.setCost(stock.getPrice().multiply(new BigDecimal(stock.getCount())));
					stock.save();
				}
				billDetail.setBasePrice(stock.getPrice());
				billDetail.save();
			}
			
			Intercourse intercourse = bill.getIntercourse();
			if (intercourse != null){
				if (intercourse.getRecvCost() == null){
					intercourse.setRecvCost(bill.getBillCost());
				} else {
					intercourse.setRecvCost(intercourse.getRecvCost().add(bill.getBillCost()));
				}
				intercourse.save();
			}
			
			bill.setCheckUserId(userId);
			bill.setCheckDate(new java.sql.Timestamp(System.currentTimeMillis()));
			bill.setStatus(1);
			bill.save();
			
			Bill.commit();
		} catch (Exception ex){
			Bill.rollback();
		}
		return "ok";
	}
	
	protected static String check3(Integer billId, Integer userId) throws Exception{
		Bill bill = Bill.find(Bill.class, billId);
		if (bill.getStatus() == 1){
			return "该单据已经审核过，不能再审核。";
		}
		try{
			Bill.beginTransaction();
			
			for(BillDetail billDetail: bill.getBillDetails()){
				if (billDetail.getBillCount() == null || billDetail.getBillCount() == 0){
					continue;
				}
				Stock stock = Stock.findFirst(Stock.class, "depotId=? and goodId=?", new Object[]{bill.getDepotId(), billDetail.getGoodId()});
				if (stock == null){
					Bill.rollback();
					return "调出仓库中找不到货物：" + billDetail.getGood().getName();
				}
				if (billDetail.getBillCount() > stock.getCount()){
					Bill.rollback();
					return "调出仓库商品数量不足：" + billDetail.getGood().getName();
				}
				stock.setCount(stock.getCount() - billDetail.getBillCount());
				if (stock.getCount() == 0){
					stock.destroy();
				} else {
					stock.setCost(stock.getPrice().multiply(new BigDecimal(stock.getCount())));
					stock.save();
				}
				Stock stock2 = Stock.findFirst(Stock.class, "depotId=? and goodId=?", new Object[]{bill.getDepot2Id(), billDetail.getGoodId()});
				if (stock2 == null){
					stock2 = new Stock();
					stock2.setDepotId(bill.getDepot2Id());
					stock2.setGoodId(billDetail.getGoodId());
					stock2.setCount(billDetail.getBillCount());
					stock2.setPrice(billDetail.getBillPrice());
					stock2.setCost(billDetail.getBillCost());
					stock2.save();
				} else {
					stock2.setCount(stock2.getCount() + billDetail.getBillCount());
					if (stock2.getCount() == 0){
						stock2.destroy();
					} else {
						stock2.setCost(stock2.getCost().add(billDetail.getBillCost()));
						stock2.setPrice(stock2.getCost().divide(new BigDecimal(stock2.getCount()), 4, BigDecimal.ROUND_HALF_UP));
						stock2.save();
					}
				}
				billDetail.setBasePrice(stock.getPrice());
				billDetail.save();
			}
			
			bill.setCheckUserId(userId);
			bill.setCheckDate(new java.sql.Timestamp(System.currentTimeMillis()));
			bill.setStatus(1);
			bill.save();
			
			Bill.commit();
		} catch(Exception ex){
			Bill.rollback();
			return "审核单据出错：" + ex.getMessage();
		}
		return "ok";
	}
}
