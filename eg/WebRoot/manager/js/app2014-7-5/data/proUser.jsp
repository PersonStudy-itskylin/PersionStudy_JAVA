<%@ page language="java" import="java.util.*,java.text.SimpleDateFormat" pageEncoding="UTF-8"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.FileUploadException"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="cn.hglq4.eshop.dao.UserDAO"%>
<%@page import="cn.hglq4.eshop.entity.User"%>
<%@page import="java.io.File"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");

	String result = "{success:";
	boolean success = false;
	String msg = null;
	
	String loginname = request.getParameter("loginname");
	String userName = request.getParameter("user_name");
	String userPwd = request.getParameter("pwd");
	int sex = Integer.parseInt(request.getParameter("sex"));
	String birthdate = request.getParameter("birthdate");
	String photo = request.getParameter("photo");
	String country = request.getParameter("country");
	String province = request.getParameter("province");
	String city = request.getParameter("city");
	String address = request.getParameter("address");
	String tel = request.getParameter("tel");
	String email = request.getParameter("email");
	String qq = request.getParameter("qq");
	String pwdQuestion1 = request.getParameter("pwd_question1");
	String pwdAnser1 = request.getParameter("pwd_anser1");
	String pwdQuestion2 = request.getParameter("pwd_question2");
	String pwdAnser2 = request.getParameter("pwd_anser2");
	String pwdQuestion3 = request.getParameter("pwd_question3");
	String pwdAnser3 = request.getParameter("pwd_anser3");
	int married = Integer.parseInt(request.getParameter("married"));
	String like = request.getParameter("like");
	String description = request.getParameter("description");
	String ethnic = request.getParameter("ethnic");
	String education = request.getParameter("education");
	String job = request.getParameter("job");
	String party = request.getParameter("party");
	String editor = request.getParameter("editor");
	String remark = request.getParameter("remark");
	
	User user = new User();
	try {
		//时间处理
		SimpleDateFormat sdf_birth = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1 = sdf_birth.parse(birthdate);
		java.sql.Date sqlDatebirth = new java.sql.Date(date1.getTime());
		//time  end 
	} catch (Exception ex) {
		System.out.println(ex.getMessage());
	}
	
	/*
	//upload
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	
	if (isMultipart) {//判断客户端是否发出file的请求
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = null;
		
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		for (FileItem item : items) {
			if (item.isFormField()) {
				String name = item.getFieldName();
				String value = item.getString();
			} else {
//---------以下开始处理图片上传-----------------------------
			String fileName = item.getName(); //c:/b/a.jpg
				System.out.println(request.getParameter("photo"));
					String myName = System.currentTimeMillis()
							+ fileName.substring(fileName.lastIndexOf("."));
					//网站URL转换成file物理路径
					String realPath = application.getRealPath("/")+ "manager\\upload\\images\\" + myName;
					File f = new File(realPath);
					try {
						item.write(f);
					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
						System.out.println("图片上传异常");
					}//将内存中文件写入到eshop的upload文件下
					user.setPhoto(realPath);//保存在数据库里面
					//---------结束处理图片上传-----------------------------				
			}
		}
	}else{
		user.setPhoto("");
	}
	*/

	user.setUserName(userName);
	user.setLoginName(loginname);
	user.setPwd(userPwd);
	user.setSex(sex);
	user.setBirthdate(new java.sql.Date(System.currentTimeMillis()));
	user.setCountry(country);
	user.setProvince(province);
	user.setCity(city);
	user.setAddress(address);
	user.setTel(tel);
	user.setEmail(email);
	user.setQq(qq);
	user.setPwdQuestion1(pwdQuestion1);
	user.setPwdAnser1(pwdAnser1);
	user.setPwdQuestion2(pwdQuestion2);
	user.setPwdAnser2(pwdAnser2);
	user.setPwdQuestion3(pwdQuestion3);
	user.setPwdAnser3(pwdAnser3);
	user.setMarried(married);
	user.setLike(like);
	user.setDescription(description);
	user.setEthnic(ethnic);
	user.setEducation(education);
	user.setJob(job);
	user.setParty(party);
	user.setEditor(editor);
	user.setRemark(remark);
	String photo_path = photo;
	user.setPhoto(photo_path);
	UserDAO userDAO = new UserDAO();
	if (userDAO.addUser(user)) {
		success = true;
		msg = "用户信息修改成功！";
	} else {
		msg = "用户信息修改失败,请重试！";
	}

	result += success + ",msg:'" + msg + "'}";
	response.getWriter().print(result);
%>