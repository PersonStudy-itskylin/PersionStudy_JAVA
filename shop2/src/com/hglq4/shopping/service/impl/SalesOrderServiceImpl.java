package com.hglq4.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hglq4.shopping.dao.SalesOrderDAO;
import com.hglq4.shopping.model.SalesOrder;
import com.hglq4.shopping.service.SalesOrderService;

@Transactional
//@Resource(name ="salesOrderService")
@Service("salesOrderService")
public class SalesOrderServiceImpl implements SalesOrderService {


	@Autowired(required=true)
	private SalesOrderDAO salesOrderDao;


	public boolean add(SalesOrder order) {
		// TODO Auto-generated method stub
		return salesOrderDao.save(order);
	}

	public List<SalesOrder> findALL() {
		// TODO Auto-generated method stub
		return salesOrderDao.findALL();
	}
	
	public List<SalesOrder> findALL(int start, int end) {
		// TODO Auto-generated method stub
		return salesOrderDao.findALL(start,end);
	}
	
	public List<SalesOrder> findByOderCode(String orderCode){
		return salesOrderDao.findByOderCode(orderCode);
	}

	/**作废*/
	public boolean remove(SalesOrder order) {
		// TODO Auto-generated method stub
		return salesOrderDao.delete(order);
	}

	public boolean verify(int id) {
		// TODO Auto-generated method stub
		return salesOrderDao.verify(id);
	}
	public List<SalesOrder> findByOderUser(String username)throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return salesOrderDao.findByOderUser(username);
	}
	public List<SalesOrder> findALL(String id) {
		// TODO Auto-generated method stub
		return salesOrderDao.findALL(id);
	}

}
