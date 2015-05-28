package com.softeem.jingdong.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.softeem.jingdong.dao.GoodsDao;
import com.softeem.jingdong.entity.GoodsBean;

public class GoodsDaoImpl implements GoodsDao {
	
	private HibernateTemplate template;
	
	//查找所有商品
	@SuppressWarnings("unchecked")
	public List<GoodsBean> getAllGoods(){
		String hql = "FROM GoodsBean g";
		return getTemplate().find(hql);
	}
	
	//通过 id 查询该商品信息
	public GoodsBean getGoodsById(int id){
		return (GoodsBean)template.get(GoodsBean.class, id);
	}
	
	//模糊查询
	@SuppressWarnings("unchecked")
	public List<GoodsBean> getSearchList(String key){
		String hql = "FROM GoodsBean g WHERE g.type LIKE :key OR g.title LIKE :key OR g.manufacturer LIKE :key";
		return template.find(hql,new Object[]{"%" + key + "%"});
	}

	public HibernateTemplate getTemplate() {
		return template;
	}
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
}
