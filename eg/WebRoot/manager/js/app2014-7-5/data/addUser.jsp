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
	String loginname = "", userName = "", userPwd = "", birthdate = "", photo = "", country = "", province = "", city = "", address = "", tel = "", email = "", qq = "", pwdAnser1 = "", pwdAnser2 = "", pwdAnser3 = "", like = "", description = "", ethnic = "", education = "", job = "", party = "", creator = "", editor = "", remark = "";
	int sex = 0, pwdQuestion1 = 0, pwdQuestion2 = 0, pwdQuestion3 = 0, married = 0;

	User user = new User();
	user.setIpaddress(request.getLocalAddr());
	user.setCreatetime(new java.sql.Date(System.currentTimeMillis()));
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
				String form = item.getFieldName();
				String value = item.getString("utf-8");
				if (form.equals("loginname")) {
					loginname = value;
					user.setLoginName(loginname);
				}
				if (form.equals("user_name")) {
					userName = value;
					user.setUserName(userName);
				}
				if (form.equals("pwd")) {
					userPwd = value;
					user.setPwd(userPwd);
				}
				if (form.equals("sex")) {
					sex = Integer.parseInt(value);
					user.setSex(sex);
				}
				if (form.equals("birthdate")) {
					birthdate = value;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
					java.sql.Date bir = sdf.parse(birthdate).getTime();
					user.setBirthdate(bir);
				}
				if (form.equals("country")) {
					country = value;
					user.setCountry(country);
				}
				if (form.equals("province")) {
					province = value;
					user.setProvince(province);
				}
				if (form.equals("city")) {
					city = value;
					user.setCity(city);
				}
				if (form.equals("address")) {
					address = value;
					user.setAddress(address);
				}
				if (form.equals("tel")) {
					tel = value;
					user.setTel(tel);
				}
				if (form.equals("email")) {
					email = value;
					user.setEmail(email);
				}
				if (form.equals("qq")) {
					qq = value;
					user.setQq(qq);
				}
				if (form.equals("pwd_question1")) {
					pwdQuestion1 = Integer.parseInt(value);
					user.setPwdQuestion1(pwdQuestion1);
				}
				if (form.equals("pwd_anser1")) {
					pwdAnser1 = value;
					user.setPwdAnser1(pwdAnser1);
				}
				if (form.equals("pwd_question2")) {
					pwdQuestion2 = Integer.parseInt(value);
					user.setPwdQuestion2(pwdQuestion2);
				}
				if (form.equals("pwd_anser2")) {
					pwdAnser2 = value;
					user.setPwdAnser2(pwdAnser2);
				}
				if (form.equals("pwd_question3")) {
					pwdQuestion3 = Integer.parseInt(value);
					user.setPwdQuestion3(pwdQuestion3);
				}
				if (form.equals("pwd_anser3")) {
					pwdAnser3 = value;
					user.setPwdAnser3(pwdAnser3);
				}
				if (form.equals("married")) {
					married = Integer.parseInt(value);
					user.setMarried(married);
				}
				if (form.equals("like")) {
					like = value;
					user.setLike(like);
				}
				if (form.equals("description")) {
					description = value;
					user.setDescription(description);
				}
				if (form.equals("ethnic")) {
					ethnic = value;
					user.setEthnic(ethnic);
				}
				if (form.equals("education")) {
					education = value;
					user.setEducation(education);
				}
				if (form.equals("job")) {
					job = value;
					user.setJob(job);
				}
				if (form.equals("party")) {
					party = value;
					user.setParty(party);
				}
				if (form.equals("creator")) {
					creator = value;
					user.setCreator(creator);
				}
				if (form.equals("editor")) {
					editor = value;
					user.setEditor(editor);
				}
				if (form.equals("remark")) {
					remark = value;
					user.setRemark(remark);
				}
			} else {
				String fileName = item.getFileName(); 
				String realPath = "";
				String path = "";
				if(!fileName.equals("")){
					//---------以下开始处理图片上传---------------------
					String myName = System.currentTimeMillis()
							+ fileName.substring(fileName
									.lastIndexOf("."));
					//网站URL转换成file物理路径
					//basePath   项目绝对路径
					realPath = basePath + "manager\\upload\\images\\" + myName;
							
					path = classPath + "/manager/upload/images/" + myName;
					File f = new File(realPath);
					try {
						item.write(f);
						user.setPhoto(path);//保存在数据库里面
					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
						System.out.println("图片上传异常");
					}//将内存中文件写入到eshop的upload文件下
					//---------结束处理图片上传------------------
				}
			}
		}
	}

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