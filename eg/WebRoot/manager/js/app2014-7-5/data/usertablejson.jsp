<%@page import="com.sun.xml.internal.fastinfoset.util.CharArray"%>
<%@page import="cn.hglq4.eshop.util.StringHelper"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@page import="cn.hglq4.eshop.dao.UserDAO"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	int start = Integer.parseInt(request.getParameter("start"));
	int pageSize = Integer.parseInt(request.getParameter("limit"));
	
	UserDAO user = new UserDAO();
	user.selectAll();
	
	String s="{totalProperty:"+ user.userlist.size() +",columns:[";
	StringBuffer str=new StringBuffer();
	
	int end = pageSize + start;	
	if(end>user.userlist.size()){
		end = user.userlist.size();
	}
	
	for(int i= start ; i < end ; i++){
	 	str.append("{user_id:")
	 		.append(user.userlist.get(i).getUserId())
	 		.append(",loginname:'")
	 		.append(user.userlist.get(i).getLoginName())
	 		.append("',user_name:'")
	 		.append(user.userlist.get(i).getUserName())
	 		.append("',pwd:'")
	 		.append(user.userlist.get(i).getPwd())
	 		.append("',sex:")
	 		.append(user.userlist.get(i).getSex())
	 		.append(",birthdate:'")
	 		.append(user.userlist.get(i).getBirthdate())
	 		.append("',photo:'")
	 		.append(user.userlist.get(i).getPhoto())
	 		.append("',country:'")
	 		.append(user.userlist.get(i).getCountry())
	 		.append("',province:'")
	 		.append(user.userlist.get(i).getProvince())
	 		.append("',city:'")
	 		.append(user.userlist.get(i).getCity())
	 		.append("',address:'")
	 		.append(user.userlist.get(i).getAddress())
	 		.append("',tel:'")
	 		.append(user.userlist.get(i).getTel())
	 		.append("',email:'")
	 		.append(user.userlist.get(i).getEmail())
	 		.append("',qq:'")
	 		.append(user.userlist.get(i).getQq())
	 		.append("',pwd_question1:")
	 		.append(user.userlist.get(i).getPwdQuestion1())
	 		.append(",pwd_anser1:'")
	 		.append(user.userlist.get(i).getPwdAnser1())
	 		.append("',pwd_question2:")
	 		.append(user.userlist.get(i).getPwdQuestion2())
	 		.append(",pwd_anser2:'")
	 		.append(user.userlist.get(i).getPwdAnser2())
	 		.append("',pwd_question3:")
	 		.append(user.userlist.get(i).getPwdQuestion3())
	 		.append(",pwd_anser3:'")
	 		.append(user.userlist.get(i).getPwdAnser3())
	 		.append("',married:")
	 		.append(user.userlist.get(i).getMarried())
	 		.append(",like:'")
	 		.append(user.userlist.get(i).getLike())
	 		.append("',description:'")
	 		.append(user.userlist.get(i).getDescription())
	 		.append("',ethnic:'")
	 		.append(user.userlist.get(i).getEthnic())
	 		.append("',education:'")
	 		.append(user.userlist.get(i).getEducation())
	 		.append("',job:'")
	 		.append(user.userlist.get(i).getJob())
	 		.append("',party:'")
	 		.append(user.userlist.get(i).getParty())
	 		.append("',ipaddress:'")
	 		.append(user.userlist.get(i).getIpaddress())
	 		.append("',creator:'")
	 		.append(user.userlist.get(i).getCreator())
	 		.append("',editor:'")
	 		.append(user.userlist.get(i).getEditor())
	 		.append("',createTime:'")
	 		.append(user.userlist.get(i).getCreatetime())
	 		.append("',updateTime:'")
	 		.append(user.userlist.get(i).getUpdatetime())
	 		.append("',remark:'")
	 		.append(user.userlist.get(i).getRemark())
	 		.append("'}");
	 	if(i!=end-1){
			str.append(",");
		} 
	}
	s+=str.toString()+"]}";
	response.getWriter().print(s);
	response.getWriter().flush();
%>