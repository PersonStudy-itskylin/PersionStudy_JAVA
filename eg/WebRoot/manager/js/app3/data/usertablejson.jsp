<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@page import="cn.hglq4.eshop.dao.UserDAO"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	int start =0; //Integer.parseInt(request.getParameter("start"));
	int pageSize =12;// Integer.parseInt(request.getParameter("limit"));
	UserDAO user = new UserDAO();
	user.selectAll();
	
	String s="{totalProperty:"+ user.userlist.size() +",columns:[";
	
	StringBuffer str=new StringBuffer();
	
	int end = pageSize + start;	
	if(end>user.userlist.size()){
		end = user.userlist.size();
	}
	
	for(int i= start ; i < end ; i++){
	 	str.append("{userId:")
	 		.append(user.userlist.get(i).getUserId())
	 		.append(",loginName:'")
	 		.append(user.userlist.get(i).getLoginName())
	 		.append("',userName:'")
	 		.append(user.userlist.get(i).getUserName())
	 		.append("',userPwd:'")
	 		.append(user.userlist.get(i).getPwd())
	 		.append("',userSex:'")
	 		.append(user.userlist.get(i).getSex())
	 		.append("',birthdate:'")
	 		.append(user.userlist.get(i).getBirthdate())
	 		.append("',photo:'")
	 		.append(user.userlist.get(i).getPhoto())
	 		.append("',contry:'")
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
	 		.append("',pwdQuestion1:'")
	 		.append(user.userlist.get(i).getPwdQuestion1())
	 		.append("',pwdAnser1:'")
	 		.append(user.userlist.get(i).getPwdAnser1())
	 		.append("',pwdQuestion2:'")
	 		.append(user.userlist.get(i).getPwdQuestion2())
	 		.append("',pwdAnser2:'")
	 		.append(user.userlist.get(i).getPwdAnser2())
	 		.append("',pwdQuestion3:'")
	 		.append(user.userlist.get(i).getPwdQuestion3())
	 		.append("',pwdAnser3:'")
	 		.append(user.userlist.get(i).getPwdAnser3())
	 		.append("',married:")
	 		.append(user.userlist.get(i).getMarried())
	 		.append(",like:'")
	 		.append(user.userlist.get(i).getLike())
	 		.append("',decription:'")
	 		.append(user.userlist.get(i).getDescription())
	 		.append("',ethnic:'")
	 		.append(user.userlist.get(i).getEthnic())
	 		.append("',education:'")
	 		.append(user.userlist.get(i).getEducation())
	 		.append("',job:'")
	 		.append(user.userlist.get(i).getJob())
	 		.append("',party:'")
	 		.append(user.userlist.get(i).getParty())
	 		.append("',creator:'")
	 		.append(user.userlist.get(i).getCreator())
	 		.append("',editor:'")
	 		.append(user.userlist.get(i).getEditor())
	 		.append("',createtime:'")
	 		.append(user.userlist.get(i).getCreatetime())
	 		.append("',updatetime:'")
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