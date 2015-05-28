package cn.hglq4.eshop.action;

import java.io.IOException;




import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;



public class BaseAction {
	public void writeJson(Object object) {
		try {
			String json=JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
