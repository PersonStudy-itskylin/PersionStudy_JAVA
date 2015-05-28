package com.softeem.jingdong.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.softeem.jingdong.entity.GoodsBean;
import com.softeem.jingdong.entity.ShoppingCarBean;
import com.softeem.jingdong.entity.UsersBean;
import com.softeem.jingdong.service.GoodsService;
import com.softeem.jingdong.service.ShoppingCarService;

/***
 * 商品信息
 * @author Administrator
 *
 */
public class GoodsAction extends ActionSupport {

	private static final long serialVersionUID = 8979942382300596390L;
	private GoodsService goodsService;
	private ShoppingCarService scs;
	private int id;
	private List<GoodsBean> list = new ArrayList<GoodsBean>();
	private GoodsBean goods = new GoodsBean();
	private String key;
	
	/**
	 * 用户首页商品列表
	 */
	public String getGoodsList(){
		//调用方法获取商品集合
		list = goodsService.getAllGoods();
		return SUCCESS; 
	}
	
	/**
	 * 查看商品详细信息
	 * @return
	 */
	public String getGoodsInfo(){
		goods = goodsService.getGoodsById(id);
		return SUCCESS;
	}
	
	/**
	 * 购买商品
	 * @return
	 */
	public String buyGoods(){
		
		//获取 Session 
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		
		//获取用户
		UsersBean users = (UsersBean)session.getAttribute("users");
		
		//获取用户的购物车信息
		ShoppingCarBean shoppingCar = users.getShoppingCar();
		
		//将商品添加到购物车里面
		GoodsBean goods = scs.addGoodsToShoppingCar(id);
		shoppingCar.getList().add(goods);
		
		//设置购物车总价
		shoppingCar.setSumPrice( this.getShoppingCarSumPrice( shoppingCar.getList() ) );
		
		//设置商品总数量
		shoppingCar.setNumber( shoppingCar.getList().size() );
		
		return SUCCESS;
	}
	
	/**
	 * 求购物车总价
	 */
	public double getShoppingCarSumPrice(List<GoodsBean> list){
		
		double sum = 0;
		
		for(GoodsBean g : list){
			sum += g.getPrice();
		}
		
		return sum;
	}
	
	/**
	 * 模糊查询商品
	 * @return
	 */
	public String getSearchGoodsList(){
		list = goodsService.getSearchList(key);
		return SUCCESS;
	}

	
	public List<GoodsBean> getList() {
		return list;
	}
	public void setList(List<GoodsBean> list) {
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public GoodsBean getGoods() {
		return goods;
	}
	public void setGoods(GoodsBean goods) {
		this.goods = goods;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	public void setScs(ShoppingCarService scs) {
		this.scs = scs;
	}
	public GoodsService getGoodsService() {
		return goodsService;
	}
	public ShoppingCarService getScs() {
		return scs;
	}
	
}
