package cn.hglq4.eshop.vo.menu;

import java.util.Map;
import java.util.Set;

public class MenuVO {

	private String state;
	private String pid;
	private String ptext;
	private Map<String, Object> attributes;

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPtext() {
		return ptext;
	}

	public void setPtext(String ptext) {
		this.ptext = ptext;
	}

	private String id;
	private String text;
	private String iconcls;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconcls() {
		return iconcls;
	}

	public void setIconcls(String iconcls) {
		this.iconcls = iconcls;
	}

	/** 
	 * 函 数 名 : 
	 * 功能描述： 
	 * 输入参数:
	 * 返 回 值: Set<Menu> 
	 * 异    常：  
	 * 创 建 人: Administrator
	 * 日    期: 2014年8月14日
	 * 修 改 人: Administrator
	 * 日    期: 2014年8月14日
	 */ 
		
	public Set<MenuVO> getTmenus() {
		// TODO Auto-generated method stub
		return null;
	}

}
