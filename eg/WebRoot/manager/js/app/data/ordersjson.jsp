<%@page import="cn.hglq4.eshop.entity.Products"%>
<%@page import="cn.hglq4.eshop.dao.ProductsDAO"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@page import="cn.hglq4.eshop.dao.UserDAO"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	int start = Integer.parseInt(request.getParameter("start"));
	int pageSize = Integer.parseInt(request.getParameter("limit"));
	
	ArrayList<Products> productslist = new ArrayList<Products>();
	productslist = new ProductsDAO().selectAll();
	
	String s="{totalProperty:"+ productslist.size() +",columns:[";
	
	StringBuffer str=new StringBuffer();
	
	int end = pageSize + start;	
	if(end>productslist.size()){
		end = productslist.size();
	}
	
	for(int i= start ; i < end ; i++){
	 	str.append("{id:")
	 		.append(productslist.get(i).getId())
	 		.append(",productCode:'")
	 		.append(productslist.get(i).getProductCode())
	 		.append("',productName:'")
	 		.append(productslist.get(i).getProductName())
	 		.append("',productPhoto:'")
	 		.append(productslist.get(i).getProductPhoto())
	 		.append("',desctiption:'")
	 		.append(productslist.get(i).getDesctiption())
	 		.append("',purchasingPrice:")
	 		.append(productslist.get(i).getPurchasingPrice())
	 		.append(",sellingPrice:")
	 		.append(productslist.get(i).getSellingPrice())
	 		.append(",quantity:")
	 		.append(productslist.get(i).getQuantity())
	 		.append(",category:'")
	 		.append(productslist.get(i).getAttachments())
	 		.append("',attachments:'")
	 		.append(productslist.get(i).getCategory())
	 		.append("',creator:'")
	 		.append(productslist.get(i).getCreator())
	 		.append("',editor:'")
	 		.append(productslist.get(i).getEditor())
	 		.append("',createTime:'")
	 		.append(productslist.get(i).getCreatetime())
	 		.append("',updateTime:'")
	 		.append(productslist.get(i).getUpdatetime())
	 		.append("',remark:'")
	 		.append(productslist.get(i).getRemark())
	 		.append("'}");
	 	if(i!=end-1){
	str.append(",");
		} 
	}
	
	s+=str.toString()+"]}";
	response.getWriter().print(s);
	response.getWriter().flush();
%>