package cn.hglq4.eshop.entity;

import java.sql.Date;
import java.sql.Timestamp;


public class Products {
	
	private int id;						//产品ID
	private String productCode;			//产品代码
	private String productName;			//产品名称
	private String productPhoto;		//产品照片
	private String desctiption;			//描述
	private double purchasingPrice;		//进价
	private double sellingPrice;		//售价
	private int quantity;				//产品数量,库存
	private String category;			//产品类别
	private String attachments;			//附件
	private String creator;				//创建者
	private String editor;				//修改者
	private Date createtime;			//创建时间
	private Timestamp updatetime;		//修改时间
	private String remark;				//备注
	
	public Products() {
		// TODO 自动生成的构造函数存根
		super();
	}
	public Products( int id,String productCode,String productName,String productPhoto,String desctiption,double purchasingPrice,double sellingPrice,int quantity,String category,String attachments,String creator,String editor,Date createtime,Timestamp updatetime,String remark) {
		// TODO 自动生成的构造函数存根
		super();
		this.id = id;
		this.productCode = productCode;
		this.productName = productName;
		this.productPhoto = productPhoto;
		this.desctiption = desctiption;
		this.purchasingPrice = purchasingPrice;
		this.sellingPrice = sellingPrice;
		this.quantity = quantity;
		this.creator = creator;
		this.editor = editor;
		this.createtime = createtime;
		this.updatetime = updatetime;
		this.remark = remark;
	}
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
	 * @return productCode
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * @param productCode 要设置的 productCode
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName 要设置的 productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return productPhoto
	 */
	public String getProductPhoto() {
		return productPhoto;
	}
	/**
	 * @param productPhoto 要设置的 productPhoto
	 */
	public void setProductPhoto(String productPhoto) {
		this.productPhoto = productPhoto;
	}
	/**
	 * @return desctiption
	 */
	public String getDesctiption() {
		return desctiption;
	}
	/**
	 * @param desctiption 要设置的 desctiption
	 */
	public void setDesctiption(String desctiption) {
		this.desctiption = desctiption;
	}
	/**
	 * @return purchasingPrice
	 */
	public double getPurchasingPrice() {
		return purchasingPrice;
	}
	/**
	 * @param purchasingPrice 要设置的 purchasingPrice
	 */
	public void setPurchasingPrice(double purchasingPrice) {
		this.purchasingPrice = purchasingPrice;
	}
	/**
	 * @return sellingPrice
	 */
	public double getSellingPrice() {
		return sellingPrice;
	}
	/**
	 * @param sellingPrice 要设置的 sellingPrice
	 */
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
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
	 * @return category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category 要设置的 category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return attachments
	 */
	public String getAttachments() {
		return attachments;
	}
	/**
	 * @param attachments 要设置的 attachments
	 */
	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}
	/**
	 * @return creator
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * @param creator 要设置的 creator
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * @return editor
	 */
	public String getEditor() {
		return editor;
	}
	/**
	 * @param editor 要设置的 editor
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}
	/**
	 * @return createtime
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * @param createtime 要设置的 createtime
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * @return updatetime
	 */
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	/**
	 * @param updatetime 要设置的 updatetime
	 */
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * @return remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark 要设置的 remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
