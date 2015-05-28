package cn.hglq4.eshop.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class OrderDetail {
	private int id;
	private int order_id;
	private int product_id;
	private int quantity;
	private double price;
	private float discount;
	private int pur_order_id;
	private int stock;
	private Date distribudate;
	private int status;
	private String creator;
	private String editor;
	private Date createtime;
	private Timestamp updatetime;
	private String remark;
	
	public OrderDetail(int id,int order_id,int product_id,int quantity,double price,float discount,int pur_order_id,int stock,Date distribudate,int status,String creator,String editor,Date createtime,Timestamp updatetime,String remark) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
		this.pur_order_id = pur_order_id;
		this.stock = stock;
		this.distribudate = distribudate;
		this.status = status;
		this.creator = creator;
		this.editor = editor;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.remark = remark;
	}
	public OrderDetail() {
		// TODO 自动生成的构造函数存根
		super();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPur_order_id() {
		return pur_order_id;
	}
	public void setPur_order_id(int pur_order_id) {
		this.pur_order_id = pur_order_id;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Date getDistribudate() {
		return distribudate;
	}
	public void setDistribudate(Date distribudate) {
		this.distribudate = distribudate;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
