package com.softeem.jingdong.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.softeem.jingdong.entity.ShoppingCarBean;
import com.softeem.jingdong.entity.UsersBean;

/**
 * 购物车 Action
 * @author Administrator
 *
 */
public class ShoppingCarAction extends ActionSupport {

	private static final long serialVersionUID = 5108850816643819815L;
	
	private String[] index;
	
	/**
	 * 删除购物车中的商品信息
	 * @return
	 */
	public String deleteGoods(){
		
		//获取用户 购物车集合 
		ShoppingCarBean shoppingCar = ((UsersBean)ActionContext.getContext().getSession().get("users")).getShoppingCar();
		
		for(int i=index.length - 1;i>=0;i--){
			
			//当前索引编号
			int j = Integer.parseInt( index[i] );
			
			//获取删除商品的单价
			double price = shoppingCar.getList().get(j).getPrice();
			
			//直接删除商品
			shoppingCar.getList().remove(j);
			
			//修改剩余数量
			shoppingCar.setNumber( shoppingCar.getNumber() - 1 );
			
			//修改剩余价格
			shoppingCar.setSumPrice( shoppingCar.getSumPrice() - price );
		}
			
		return SUCCESS;
	}

	public String[] getIndex() {
		return index;
	}

	public void setIndex(String[] index) {
		this.index = index;
	}
	
}
