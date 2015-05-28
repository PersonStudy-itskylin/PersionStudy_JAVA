package com.ssi.depot.action.common;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


/**
 * 
 * @author 林为
 *
 * @param <T>
 *            泛型实体类
 * @param <TService>
 *            泛型服务类
 */
public abstract class BaseAction<T> extends ActionSupport
		implements ApplicationContextAware, ServletContextAware,
		ServletResponseAware, ServletRequestAware, SessionAware, ModelDriven<T> {

	private static final long serialVersionUID = 5491145517170071684L;
	
	private Class<?> clazz;
	
	protected T entity;
	
	protected Map<String, Object> session;

	protected ApplicationContext applicationContext;

	protected ServletContext servletContext;

	protected HttpServletRequest request;

	protected HttpServletResponse response;

	protected HttpSession httpSession;

	protected Map<String, Object> result = new HashMap<String, Object>();
	
	protected ServletActionContext servletActionContext;

	protected boolean flag;
	
	protected Map<String,Object> json = new HashMap<String, Object>();
	
	
	@SuppressWarnings("unchecked")
	public BaseAction() {
		// TODO 自动生成的构造函数存根
		ParameterizedType ptype=(ParameterizedType)(this.getClass().getGenericSuperclass());
		clazz = (Class<?>)(ptype.getActualTypeArguments()[0]);
		try {
			entity = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	
	
	
/*****************************************************************************************************/
	public Map<String, Object> getSession() {
		return session;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public HttpSession getHttpSession() {
		return httpSession;
	}

	@JSON
	public Map<String, Object> getResult() {
		return result;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setHttpSession(HttpSession httpSession) {
		this.httpSession = httpSession;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public ServletActionContext getServletActionContext() {
		return servletActionContext;
	}

	public void setServletActionContext(ServletActionContext servletActionContext) {
		this.servletActionContext = servletActionContext;
	}

}