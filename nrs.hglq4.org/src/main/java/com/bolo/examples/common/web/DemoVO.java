package com.bolo.examples.common.web;

public class DemoVO {
	private String x;
	private String y;
	private String z;
	
	public DemoVO(String i, String j, String k) {
		this.x=i;
		this.y=j;
		this.z=k;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getY() {
		return y;
	}
	public void setY(String y) {
		this.y = y;
	}
	public String getZ() {
		return z;
	}
	public void setZ(String z) {
		this.z = z;
	}
}
