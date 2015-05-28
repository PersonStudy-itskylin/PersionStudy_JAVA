package com.hglq4.shopping.model.dto;

import java.util.List;

import com.hglq4.shopping.model.SaleItem;

public class OrderFormDto {
	private List<SaleItem> saleitems;

	public List<SaleItem> getSaleitems() {
		return saleitems;
	}

	public void setSaleitems(List<SaleItem> saleitems) {
		this.saleitems = saleitems;
	}
	
	
}
