package models;

import java.math.BigDecimal;

import com.et.ar.ActiveRecordBase;
import com.et.ar.annotations.BelongsTo;
import com.et.ar.annotations.Column;
import com.et.ar.annotations.Id;
import com.et.ar.annotations.Table;

@Table(name="billDetails")
public class BillDetail extends ActiveRecordBase{
	@Id private Integer id;
	@Column private Integer billId;
	@Column private Integer goodId;
	@Column private Integer billCount;
	@Column private BigDecimal billPrice;
	@Column private BigDecimal basePrice;
	@Column private Integer rtnCount;
	@Column private Integer billDetailId;
	@Column private String remark;
	
	@BelongsTo(foreignKey="goodId")
	private Good good;
	
	public BigDecimal getBillCost(){
		if (billCount != null && billPrice != null){
			return billPrice.multiply(new BigDecimal(billCount));
		} else {
			return null;
		}
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	public Integer getGoodId() {
		return goodId;
	}
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	public Integer getBillCount() {
		return billCount;
	}
	public void setBillCount(Integer billCount) {
		this.billCount = billCount;
	}
	public BigDecimal getBillPrice() {
		return billPrice;
	}
	public void setBillPrice(BigDecimal billPrice) {
		this.billPrice = billPrice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public Integer getBillDetailId() {
		return billDetailId;
	}

	public void setBillDetailId(Integer billDetailId) {
		this.billDetailId = billDetailId;
	}

	public Integer getRtnCount() {
		return rtnCount;
	}

	public void setRtnCount(Integer rtnCount) {
		this.rtnCount = rtnCount;
	}
}
