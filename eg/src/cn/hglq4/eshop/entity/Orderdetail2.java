package cn.hglq4.eshop.entity;

public class Orderdetail2 {
/*
 * `id` INT(11) NOT NULL AUTO_INCREMENT,
  `order_id` INT(11) NOT NULL,
  `product_id` VARCHAR(45) NOT NULL,
  `quantity` INT(11) NOT NULL,
  `price` DOUBLE NOT NULL,
  `discount` VARCHAR(45) NOT NULL,
  `status` INT(1) NOT NULL,
  `pur_order_id` INT(11) NOT NULL,
  `stock` INT(11) NOT NULL,
 */
	private int id;
	private int order_id;
	private int product_id;
	private int quantity;
	private double price;
	private String discount;
	private int status;
	private int pur_order_id;
	private int stock;
	
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}






	/**
	 * @param id 要设置的 id
	 */
	public void setId(int id) {
		this.id = id;
	}






	/**
	 * @return order_id
	 */
	public int getOrder_id() {
		return order_id;
	}






	/**
	 * @param order_id 要设置的 order_id
	 */
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}






	/**
	 * @return product_id
	 */
	public int getProduct_id() {
		return product_id;
	}






	/**
	 * @param product_id 要设置的 product_id
	 */
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}






	/**
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}






	/**
	 * @param quantity 要设置的 quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}






	/**
	 * @return price
	 */
	public double getPrice() {
		return price;
	}






	/**
	 * @param price 要设置的 price
	 */
	public void setPrice(double price) {
		this.price = price;
	}






	/**
	 * @return discount
	 */
	public String getDiscount() {
		return discount;
	}






	/**
	 * @param discount 要设置的 discount
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}






	/**
	 * @return status
	 */
	public int getStatus() {
		return status;
	}






	/**
	 * @param status 要设置的 status
	 */
	public void setStatus(int status) {
		this.status = status;
	}






	/**
	 * @return pur_order_id
	 */
	public int getPur_order_id() {
		return pur_order_id;
	}






	/**
	 * @param pur_order_id 要设置的 pur_order_id
	 */
	public void setPur_order_id(int pur_order_id) {
		this.pur_order_id = pur_order_id;
	}






	/**
	 * @return stock
	 */
	public int getStock() {
		return stock;
	}






	/**
	 * @param stock 要设置的 stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public Orderdetail2(int id,int order_id,int product_id,int quantity,double price,String discount,int status,int pur_order_id,int stock) {
		// TODO 自动生成的构造函数存根
		super();
		this.id = id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
		this.status = status;
		this.pur_order_id = pur_order_id;
		this.stock = stock;
	}
	
	public Orderdetail2() {
		// TODO 自动生成的构造函数存根
		super();
	}
}
