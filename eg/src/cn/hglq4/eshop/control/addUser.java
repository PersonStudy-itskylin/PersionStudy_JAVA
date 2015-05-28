package cn.hglq4.eshop.control;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.hglq4.eshop.dao.UserDAO;
import cn.hglq4.eshop.entity.User;

public class addUser extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5569199927068777804L;


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String loginName = req.getParameter("loginName");
		String userName = req.getParameter("userName");
		String userPwd = req.getParameter("userPwd");
		int userSex = Integer.parseInt(req.getParameter("userSex"));
		String birthdate = req.getParameter("birthdate");
		String country = req.getParameter("contry");
		String province = req.getParameter("province");
		String city = req.getParameter("city");
		String address = req.getParameter("address");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		String qq = req.getParameter("qq");
		int pwdQuestion1 = Integer.parseInt(req.getParameter("pwdQuestion1"));
		String pwdAnser1 = req.getParameter("pwdAnser1");
		int pwdQuestion2 = Integer.parseInt(req.getParameter("pwdQuestion2"));
		String pwdAnser2 = req.getParameter("pwdAnser2");
		int pwdQuestion3 = Integer.parseInt(req.getParameter("pwdQuestion3"));
		String pwdAnser3 = req.getParameter("pwdAnser3");
		int married = Integer.parseInt(req.getParameter("married"));
		String like = req.getParameter("like");
		String description = req.getParameter("decription");
		String ethnic = req.getParameter("ethnic");
		String education = req.getParameter("education");
		String job = req.getParameter("job");
		String party = req.getParameter("party");
		String creator = req.getParameter("creator");
		String editor = req.getParameter("editor");
		String createtime = req.getParameter("createTime");
		String remark = req.getParameter("remark");
		User user = new User();
		
		//时间处理
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.sql.Date date = Date.valueOf(createtime);
		String datetime = sdf.format(date);
		java.sql.Date createTime  = Date.valueOf(datetime);
		java.sql.Date birth = Date.valueOf(birthdate);
		String S_birth = sdf.format(birth);
		//time  end 
		
		user.setLoginName(loginName);
		user.setUserName(userName);
		user.setPwd(userPwd);
		user.setSex(userSex);
		user.setBirthdate(Date.valueOf(S_birth));
		//upload
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if(isMultipart){//判断客户端是否发出file的请求
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(req);
			} catch (FileUploadException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		  for(FileItem item:items){
		     if(item.isFormField()){
		           String name = item.getFieldName(); 
		           String value = item.getString();
		           
		     }else{
		      	//---------以下开始处理图片上传-----------------------------
	             String fileName = item.getName(); //c:/b/a.jpg
	             String myName=System.currentTimeMillis()+fileName.substring(fileName.lastIndexOf("."));
	             //网站URL转换成file物理路径
	             String realPath=req.getContextPath() +  "manager/upload"+"\\"+myName;
	             System.out.println(realPath);
	             File f=new File(realPath);
	             
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
		}
//		String photo_path=photo;
//		user.setPhoto(photo_path);
		//end upload
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
		user.setCreator(creator);
		user.setEditor(editor);
		user.setCreatetime(createTime);
		user.setRemark(remark);
		
		UserDAO userDAO = new UserDAO();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doPost(req,resp);
	}
}
