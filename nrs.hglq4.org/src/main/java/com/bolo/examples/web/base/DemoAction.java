package com.bolo.examples.web.base;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bolo.examples.common.web.DemoVO;
import com.bolo.examples.entity.base.User;
import com.bolo.examples.service.base.UserManager;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
@Controller
@ParentPackage("struts-default")
@Results({@Result(name="success",location="/index.jsp")})
@Namespace("/")
public class DemoAction extends ActionSupport {
	@Autowired
	private UserManager userManager;
	private String x;
	private List<DemoVO> list=new  ArrayList<DemoVO>();
	


	public List<DemoVO> getList() {
		return list;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	@Action(value="add",results={@Result(name="success",location="/index.jsp")})
	public String add(){
		System.out.println("-------5678-----------");
		return SUCCESS;
	}
	
	public String del(){
		System.out.println("---------2-----------");
		return SUCCESS;
	}
	
	@Action(value="list",results={@Result(name="success",location="/index.jsp")})
	public String list(){
		System.out.println("---------list-----------"+x);
		if(x.equals("a")){
			for(int i=0;i<10;i++){
			  DemoVO d=new DemoVO("1","2",(i++)+"");
			  list.add(d);
			}
		}else{
			for(int i=20;i<80;i++){
			  DemoVO d=new DemoVO("ad","ef",i+++"");
			  list.add(d);
			}	
		}
		User u =userManager.getUser(1);
		System.out.println(u);
		return SUCCESS;
	}

}
