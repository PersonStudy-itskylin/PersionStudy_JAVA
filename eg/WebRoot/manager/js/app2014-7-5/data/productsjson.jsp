<%@page import="cn.hglq4.eshop.dao.ProductsDAO"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@page import="cn.hglq4.eshop.dao.UserDAO"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	int start = Integer.parseInt(request.getParameter("start"));
	int pageSize = Integer.parseInt(request.getParameter("limit"));
	ProductsDAO products = new ProductsDAO();
	products.selectAll();
	
	String s="{totalProperty:"+ products.productslist.size() +",columns:[";
	
	StringBuffer str=new StringBuffer();
	
	int end = pageSize + start;	
	if(end>products.productslist.size()){
		end = products.productslist.size();
	}
	
	for(int i= start ; i < end ; i++){
	 	str.append("{id:")
	 		.append(products.productslist.get(i).getId())
	 		.append(",productCode:'")
	 		.append(products.productslist.get(i).getProductCode())
	 		.append("',productName:'")
	 		.append(products.productslist.get(i).getProductName())
	 		.append("',productPhoto:'")
	 		.append(products.productslist.get(i).getProductPhoto())
	 		.append("',desctiption:'")
	 		.append(products.productslist.get(i).getDesctiption())
	 		.append("',purchasingPrice:")
	 		.append(products.productslist.get(i).getPurchasingPrice())
	 		.append(",sellingPrice:")
	 		.append(products.productslist.get(i).getSellingPrice())
	 		.append(",quantity:")
	 		.append(products.productslist.get(i).getQuantity())
	 		.append(",category:'")
	 		.append(products.productslist.get(i).getCategory())
	 		.append("',creator:'")
	 		.append(products.productslist.get(i).getCreator())
	 		.append("',editor:'")
	 		.append(products.productslist.get(i).getEditor())
	 		.append("',createTime:'")
	 		.append(products.productslist.get(i).getCreatetime())
	 		.append("',updateTime:'")
	 		.append(products.productslist.get(i).getUpdatetime())
	 		.append("',remark:'")
	 		.append(products.productslist.get(i).getRemark())
	 		.append("'}");
	 	if(i!=end-1){
	str.append(",");
		} 
	}
	
	s+=str.toString()+"]}";
	response.getWriter().print(s);
	response.getWriter().flush();
%>