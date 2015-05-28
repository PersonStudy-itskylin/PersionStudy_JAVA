package com.bolo.examples.service.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolo.examples.dao.base.ArticleDao;
import com.bolo.examples.dao.base.RelatedarticleDao;
import com.bolo.examples.entity.base.Article;
import com.bolo.examples.entity.base.Relatedarticle;

/**
 * 
 * CopyRright (c)2013-2014:   <蓝桥软件BlueSoft>                          
 * Project:  nrs.hglq4.org                                          
 * Module ID: <(模块)类编号，可以引用系统设计中的类编号>    
 * Comments:  <对此类的描述，可以引用系统设计中的描述>                                           
 * JDK version used: <JDK1.6>                              
 * Namespace: cn.hglq4.eshop                                        
 * Author：XXX                
 * Create Date： 2014-8-13 
 * Modified By：  XXX                                        
 * Modified Date: 2014-8-13 下午3:22:27                                    
 * Why & What is modified:  <修改原因描述>    
 * Version: v1.0
 */
@Service
public class ArticleManager {
	
	@Autowired
	private ArticleDao articleDao;
	
	@Autowired
	private RelatedarticleDao relatedarticleDao;
	
	/**
	 * 
	 * 函 数 名: getArticleById
	 * 功能描述： 通过新闻编号获取文章
	 * 输入参数: id 新闻编号
	 * 返 回 值:  Article 
	 * 异    常：<按照异常名字的字母顺序> 
	 * 创 建 人: Administrator
	 * 日    期: 2014-8-13
	 * 修 改 人: Administrator
	 * 日    期: 2014-8-13
	 */
	public Article getArticleById(Serializable id){
		
		return articleDao.get(id);
	}
	
	public List<Article> getAllRelatedarticle(Article article){
		
//		String sql = "select * from relatedarticle where ARTId = ?";
//		
//		List<?> list = relatedarticleDao.createSQLQuery(sql, article.getArtid()).list();
//		
//		Iterator<?> it = list.iterator();
//		
//		List<Article> articles = new ArrayList<Article>();
//		Article art = null;
//		
//		while(it.hasNext()){
//			
//			art = new Article();
//			...
//			articles.add(art);
//		}
//		
//		return articles;
		
		Set<Relatedarticle> relatedarticles = articleDao.get(article.getArtid()).getRelatedarticlesForArtid();
		System.out.println(relatedarticles.size()+"------------");
		
		Iterator<Relatedarticle> it = relatedarticles.iterator();
		Relatedarticle relatedarticle = null;
		
		while(it.hasNext()){
			
			relatedarticle = it.next();
			
			System.out.println(relatedarticle.getArticleByArtArtid().getArtid()+" "+relatedarticle.getArticleByArtid().getArttitle());
		}
		
		return null;
	}
	
}
