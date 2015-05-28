package models;

import java.math.BigDecimal;
import java.util.List;

import rbac.models.User;

import com.et.ar.ActiveRecordBase;
import com.et.ar.annotations.BelongsTo;
import com.et.ar.annotations.Column;
import com.et.ar.annotations.DependentType;
import com.et.ar.annotations.HasMany;
import com.et.ar.annotations.Id;
import com.et.ar.annotations.Table;

@Table(name="bills")
public class Bill extends ActiveRecordBase{
	@Id private Integer id;
	@Column private Integer billType;
	@Column private Integer intercourseId;
	@Column private Integer depotId;
	@Column private Integer depot2Id;
	@Column private String code;
	@Column private String summary;
	@Column private String remark;
	@Column private Integer billCount;
	@Column private BigDecimal billCost;
	@Column private Integer writeUserId;
	@Column private Integer checkUserId;
	@Column private java.sql.Timestamp writeDate;
	@Column private java.sql.Timestamp checkDate;
	@Column private java.sql.Date billDate;
	@Column private Integer status;
	
	@BelongsTo(foreignKey="intercourseId")
	private Intercourse intercourse;
	
	@BelongsTo(foreignKey="depotId")
	private Depot depot;
	
	@BelongsTo(foreignKey="depot2Id")
	private Depot depot2;
	
	@BelongsTo(foreignKey="writeUserId")
	private User writeUser;
	
	@BelongsTo(foreignKey="checkUserId")
	private User checkUser;
	
	@HasMany(foreignKey="billId", dependent=DependentType.DESTROY)
	private List<BillDetail> billDetails;
	
	/**
	 * 返回单据的下一个编码
	 * @param prefix
	 * @return
	 * @throws Exception
	 */
    public static String nextCode(String prefix) throws Exception{
        int serno = 1;
        
        String head = prefix + new java.text.SimpleDateFormat("yyyyMM").format(new java.util.Date());
        Bill item = findFirst(Bill.class, "code like ?", new Object[]{head + "%"}, "code desc");
        if (item != null){
        	String code = item.getCode();
        	serno = Integer.parseInt(code.substring(head.length())) + 1;
        }
        
        return head + new java.text.DecimalFormat("0000").format(serno);
    }

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBillType() {
		return billType;
	}
	public void setBillType(Integer billType) {
		this.billType = billType;
	}
	public Integer getIntercourseId() {
		return intercourseId;
	}
	public void setIntercourseId(Integer intercourseId) {
		this.intercourseId = intercourseId;
	}
	public Integer getDepotId() {
		return depotId;
	}
	public void setDepotId(Integer depotId) {
		this.depotId = depotId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getBillCount() {
		return billCount;
	}
	public void setBillCount(Integer billCount) {
		this.billCount = billCount;
	}
	public BigDecimal getBillCost() {
		return billCost;
	}
	public void setBillCost(BigDecimal billCost) {
		this.billCost = billCost;
	}
	public Integer getWriteUserId() {
		return writeUserId;
	}
	public void setWriteUserId(Integer writeUserId) {
		this.writeUserId = writeUserId;
	}
	public Integer getCheckUserId() {
		return checkUserId;
	}
	public void setCheckUserId(Integer checkUserId) {
		this.checkUserId = checkUserId;
	}
	public java.sql.Timestamp getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(java.sql.Timestamp writeDate) {
		this.writeDate = writeDate;
	}
	public java.sql.Timestamp getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(java.sql.Timestamp checkDate) {
		this.checkDate = checkDate;
	}
	public java.sql.Date getBillDate() {
		return billDate;
	}
	public void setBillDate(java.sql.Date billDate) {
		this.billDate = billDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public User getWriteUser() {
		return writeUser;
	}
	public void setWriteUser(User writeUser) {
		this.writeUser = writeUser;
	}
	public User getCheckUser() {
		return checkUser;
	}
	public void setCheckUser(User checkUser) {
		this.checkUser = checkUser;
	}

	public List<BillDetail> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}

	public Intercourse getIntercourse() {
		return intercourse;
	}

	public void setIntercourse(Intercourse intercourse) {
		this.intercourse = intercourse;
	}

	public Depot getDepot() {
		return depot;
	}

	public void setDepot(Depot depot) {
		this.depot = depot;
	}

	public Integer getDepot2Id() {
		return depot2Id;
	}

	public void setDepot2Id(Integer depot2Id) {
		this.depot2Id = depot2Id;
	}

	public Depot getDepot2() {
		return depot2;
	}

	public void setDepot2(Depot depot2) {
		this.depot2 = depot2;
	}
}
