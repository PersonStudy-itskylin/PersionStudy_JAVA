package hglq4.cn.ssh2.entity.customer;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "CUSTOMER", schema = "SCOTT")
public class Customer implements Serializable {

	// Fields

	private BigDecimal customerId;
	private String customerName;
	private String sex;
	private String country;
	private String province;
	private String city;
	private String address;
	private String postcode;
	private String phone;
	private String email;

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** minimal constructor */
	public Customer(BigDecimal customerId) {
		this.customerId = customerId;
	}

	/** full constructor */
	public Customer(BigDecimal customerId, String customerName, String sex,
			String country, String province, String city, String address,
			String postcode, String phone, String email) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.sex = sex;
		this.country = country;
		this.province = province;
		this.city = city;
		this.address = address;
		this.postcode = postcode;
		this.phone = phone;
		this.email = email;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="teacher")
	@SequenceGenerator(name="teacher",sequenceName="seq_customer")
	@Column(name = "CUSTOMER_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(BigDecimal customerId) {
		this.customerId = customerId;
	}

	@Column(name = "CUSTOMER_NAME", length = 127)
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "SEX", length = 2)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "COUNTRY", length = 35)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "PROVINCE", length = 35)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "CITY", length = 35)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "ADDRESS", length = 127)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "POSTCODE", length = 6)
	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name = "PHONE", length = 18)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "EMAIL", length = 35)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}