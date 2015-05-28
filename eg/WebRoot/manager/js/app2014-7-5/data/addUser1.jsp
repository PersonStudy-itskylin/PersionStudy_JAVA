<%@page import="cn.hglq4.eshop.util.MD5"%>
<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat"
	pageEncoding="UTF-8"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.FileUploadException"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="cn.hglq4.eshop.dao.UserDAO"%>
<%@page import="cn.hglq4.eshop.entity.User"%>
<%@page import="java.io.File"%>
<%
	String classPath = request.getContextPath();
	String basePath = application.getRealPath("/");

	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");

	String result = "{success:";
	boolean success = false;
	String msg = null;
	
	
	String loginname = request.getParameter("loginname");
	String userName = request.getParameter("user_name");
	String userPwd = request.getParameter("pwd");
	String tel = request.getParameter("tel");
	String email = request.getParameter("email");
	String qq = request.getParameter("qq");
	String creator = request.getParameter("creator");
	String editor = request.getParameter("editor");
	String remark = request.getParameter("remark");

	User user = new User();
	user.setLoginName(loginname);
	user.setUserName(userName);
	user.setPwd(MD5.encode(userPwd));
	user.setTel(tel);
	user.setEmail(email);
	user.setCreator(creator);
	user.setEditor(editor);
	user.setIpaddress(request.getLocalAddr());//添加IP
	user.setCreatetime(new java.sql.Date(System.currentTimeMillis()));//添加创建时间

	UserDAO userDAO = new UserDAO();
	//reg User
	if (userDAO.addUser(user)) {
		success = true;
		msg = "注册成功！";
	} else {
		msg = "注册失败,请重试！";
	}

	result += success + ",msg:'" + msg + "'}";
	response.getWriter().print(result);
%>