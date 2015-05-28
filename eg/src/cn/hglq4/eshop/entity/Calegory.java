package cn.hglq4.eshop.entity;

import java.util.HashSet;
import java.util.Set;

public class Calegory {
	
	private int id;
	private String text;
	private String description;
	private int parent;
	private boolean leaf = true;
	private int grade;
	private Set<Products> products = new HashSet<Products>();
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
	 * @return text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text 要设置的 text
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description 要设置的 description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return parent
	 */
	public int getParent() {
		return parent;
	}
	/**
	 * @param parent 要设置的 parent
	 */
	public void setParent(int parent) {
		this.parent = parent;
	}
	/**
	 * @return leaf
	 */
	public boolean isLeaf() {
		return leaf;
	}
	/**
	 * @param leaf 要设置的 leaf
	 */
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	/**
	 * @return grade
	 */
	public int getGrade() {
		return grade;
	}
	/**
	 * @param grade 要设置的 grade
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}
	/**
	 * @return products
	 */
	public Set<Products> getProducts() {
		return products;
	}
	/**
	 * @param products 要设置的 products
	 */
	public void setProducts(Set<Products> products) {
		this.products = products;
	}
}
