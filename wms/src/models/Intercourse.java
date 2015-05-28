package models;

import com.et.ar.ActiveRecordBase;
import com.et.ar.annotations.BelongsTo;
import com.et.ar.annotations.Column;
import com.et.ar.annotations.Id;
import com.et.ar.annotations.Table;
import java.math.BigDecimal;

@Table(name="intercourses")
public class Intercourse extends ActiveRecordBase{
    @Id private Integer id;
    @Column private Integer intercourseTypeId;
    @Column private String code;
    @Column private String shortName;
    @Column private String fullName;
    @Column private String remark;
    @Column private String addr;
    @Column private String postcode;
    @Column private String phone;
    @Column private String fax;
    @Column private String www;
    @Column private String email;
    @Column private String answerMan;
    @Column private String contactMan;
    @Column private String licence;
    @Column private String bank;
    @Column private String taxCode;
    @Column private String account;
    @Column private String help;
    @Column private BigDecimal recvCost;
    @Column private BigDecimal payCost;

    @BelongsTo(foreignKey="intercourseTypeId")
    private IntercourseType intercourseType;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIntercourseTypeId() {
        return intercourseTypeId;
    }

    public void setIntercourseTypeId(Integer intercourseTypeId) {
        this.intercourseTypeId = intercourseTypeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnswerMan() {
        return answerMan;
    }

    public void setAnswerMan(String answerMan) {
        this.answerMan = answerMan;
    }

    public String getContactMan() {
        return contactMan;
    }

    public void setContactMan(String contactMan) {
        this.contactMan = contactMan;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public BigDecimal getRecvCost() {
        return recvCost;
    }

    public void setRecvCost(BigDecimal recvCost) {
        this.recvCost = recvCost;
    }

    public BigDecimal getPayCost() {
        return payCost;
    }

    public void setPayCost(BigDecimal payCost) {
        this.payCost = payCost;
    }

    public IntercourseType getIntercourseType() {
        return intercourseType;
    }

    public void setIntercourseType(IntercourseType intercourseType) {
        this.intercourseType = intercourseType;
    }

}
