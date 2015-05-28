package cn.hglq4.eshop.vo.order;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import cn.hglq4.eshop.util.DateHelper;
import cn.hglq4.eshop.util.GernerateID;
import cn.hglq4.eshop.vo.product.ProductVO;


public class Shoppingcar {

	private Map<ProductVO, Integer> m = new HashMap<ProductVO, Integer>();
	private float total;
	//随机函数
	 public static int ranRan(int m, int n) {
	        Random random = new Random();
	        return random.nextInt(n - m) + m;
	    }
	

	// 增加产品
	public void addProduct(ProductVO p) {

		// 计算该购物车中是否存在该产品，如存在，数量加1，如不存在，则初始化为1
		if (m.containsKey(p)) {// 如存在
			int oldValue = m.get(p);
			m.put(p, oldValue + 1);
		} else {
			m.put(p, 1);// 数量初始化为1
		}
	}

	public void removeProduct(ProductVO p) {
	}

	public void clearCar() {

	}

	public void print() {
		System.out.println("\t\t\t\t\t\t\t\t订单号："+ GernerateID.id());
		System.out
				.println("——————————————————————————————————————————————————————————————————————————————————————————");
		System.out.println("\t序号\t\t产品名\t\t商品单价（￥）\t\t数量\t\t合计（￥）");
		System.out
				.println("——————————————————————————————————————————————————————————————————————————————————————————");
       
		
		
		
		Iterator<ProductVO> pit = m.keySet().iterator();
		int no = 0;
		while (pit.hasNext())//有重复商品
			{
		no++;
		ProductVO p = pit.next();
		int val = m.get(p);
		float htotal=val* p.getPrice();
		
		System.out.println("\t"+no + "\t\t" + p.getProductname() + "\t\t\t" + p.getPrice()
				+ "\t\t" + val+"\t\t"+htotal);
		System.out.println("——————————————————————————————————————————————————————————————————————————————————————————");
		
	   }
		System.out.println("\t总价（￥）"+getTotal());
		System.out.println("\t日期："+DateHelper.format("yyyy年MM月DD日hh时mm分ss秒"));
		
	}
	
	/*
	 * 统计总价
	 * */
	public float getTotal(){
		 total=0;
		Iterator<ProductVO> it= m.keySet().iterator();	
		while (it.hasNext()){//有重复商品
			ProductVO p=it.next();
			float price=p.getPrice();
			total+=m.get(p)*price;	
		}
		return total;
	}


	public Map<ProductVO, Integer> getM() {
		return m;
	}
	
	

	
}
