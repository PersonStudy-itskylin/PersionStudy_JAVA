package com.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ORM.Member;
import com.ORM.Memberlevel;
import com.ORM.MySessionFactory;
import com.base.BaseLog;

public class MemServiceImpl extends BaseLog implements MemService {

	/** 锟斤拷锟斤拷注锟斤拷锟皆�*/
	public boolean addMember(Member member) throws Exception {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		boolean result = false;
		try{
			tx = session.beginTransaction();
			session.save(member);
			tx.commit();
			result=true;
		}catch(Exception ex){
			if(tx!=null)tx.rollback();
			logger.info("锟斤拷执锟斤拷MemServiceImpl锟斤拷锟叫碉拷addMember锟斤拷锟斤拷时锟斤拷锟�\n");
			ex.printStackTrace();
		}finally{
			MySessionFactory.closeSession();
		}	
		return result;
	}

	/** 锟斤拷锟斤拷锟皆憋拷锟斤拷锟�*/
	public List browseMemberLevel() throws Exception {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		List list = null;
		try{
			Query query = session.createQuery("from Memberlevel as a order by a.id");
			tx = session.beginTransaction();
			list = query.list();
			tx.commit();
			if (!Hibernate.isInitialized(list))Hibernate.initialize(list);
		}catch(Exception ex){
			if(tx!=null)tx.rollback();
			logger.info("锟斤拷执锟斤拷MemServiceImpl锟斤拷锟叫碉拷browseMemberLevel锟斤拷锟斤拷时锟斤拷锟�\n");
			ex.printStackTrace();
		}finally{
			MySessionFactory.closeSession();
		}	
		return list;
	}

	/** 锟斤拷锟斤拷录锟绞猴拷锟角凤拷锟斤拷效 */
	public boolean chkLoginName(String loginName) throws Exception {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		boolean result = true;
		try{
			String hql = "select count(*) from Member as a where a.loginName=:loginName";
			Query query = session.createQuery(hql);
			query.setString("loginName", loginName);
			query.setMaxResults(1);
			tx = session.beginTransaction();
			if (((Integer)query.uniqueResult()).intValue()>0)result=false;
			tx.commit();
		}catch(Exception ex){
			if(tx!=null)tx.rollback();
			logger.info("锟斤拷执锟斤拷MemServiceImpl锟斤拷锟叫碉拷chkLoginName锟斤拷锟斤拷时锟斤拷锟�\n");
			ex.printStackTrace();
		}finally{
			MySessionFactory.closeSession();
		}	
		return result;
	}

	/** 装锟截伙拷员锟斤拷锟斤拷 */
	public Memberlevel loadMemberLevel(Integer id) throws Exception {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		Memberlevel level = null;
		try{
			tx = session.beginTransaction();
			level = (Memberlevel)session.get(Memberlevel.class, id);
			tx.commit();
		}catch(Exception ex){
			if(tx!=null)tx.rollback();
			logger.info("锟斤拷执锟斤拷MemServiceImpl锟斤拷锟叫碉拷loadMemberLevel锟斤拷锟斤拷时锟斤拷锟�\n");
			ex.printStackTrace();
		}finally{
			MySessionFactory.closeSession();
		}	
		return level;
	}

	/** 锟斤拷员锟斤拷录 */
	public Member memLogin(String loginName, String loginPwd) throws Exception {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		Member mem = null;
		try{
			String hql = "select a from Member as a where a.loginName=:loginName and a.loginPwd=:loginPwd";
			Query query = session.createQuery(hql);
			query.setString("loginName", loginName);
			query.setString("loginPwd", loginPwd);
			System.out.println(loginName + "    " + loginPwd);
			query.setMaxResults(1);
			tx = session.beginTransaction();
			mem = (Member)query.uniqueResult();
			mem.setLoginTimes(Integer.valueOf(mem.getLoginTimes().intValue()+1));
			mem.setLastDate(new Date());
			session.update(mem);
			tx.commit();
		}catch(Exception ex){
			if(tx!=null)tx.rollback();
			logger.info("锟斤拷执锟斤拷MemServiceImpl锟斤拷锟叫碉拷memLogin锟斤拷锟斤拷时锟斤拷锟�\n");
			ex.printStackTrace();
		}finally{
			MySessionFactory.closeSession();
		}	
		return mem;
	}

	/** 锟睫革拷注锟斤拷锟皆�*/
	public boolean updateMember(Member member) throws Exception {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		boolean result = false;
		try{
			tx = session.beginTransaction();
			session.update(member);
			tx.commit();
			result=true;
		}catch(Exception ex){
			if(tx!=null)tx.rollback();
			logger.info("锟斤拷执锟斤拷MemServiceImpl锟斤拷锟叫碉拷updateMember锟斤拷锟斤拷时锟斤拷锟�\n");
			ex.printStackTrace();
		}finally{
			MySessionFactory.closeSession();
		}	
		return result;
	}

	/** 锟斤拷锟阶�拷锟斤拷员*/
	public List browseMember() throws Exception {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		List list = null;
		try{
			Query query = session.createQuery("from Member as a order by a.id");
			tx = session.beginTransaction();
			list = query.list();
			tx.commit();
			if (!Hibernate.isInitialized(list))Hibernate.initialize(list);
		}catch(Exception ex){
			if(tx!=null)tx.rollback();
			logger.info("锟斤拷执锟斤拷MemServiceImpl锟斤拷锟叫碉拷browseMember锟斤拷锟斤拷时锟斤拷锟�\n");
			ex.printStackTrace();
		}finally{
			MySessionFactory.closeSession();
		}	
		return list;
	}

	/** 删锟斤拷注锟斤拷锟皆�*/
	public boolean delMember(Integer id) throws Exception {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		boolean status = false;
		try{
			tx = session.beginTransaction();
			Member member = (Member)session.load(Member.class, id);
			session.delete(member);
			tx.commit();
			status = true;
		}catch(Exception ex){
			if(tx!=null)tx.rollback();
			logger.info("锟斤拷执锟斤拷MemServiceImpl锟斤拷锟叫碉拷delMember锟斤拷锟斤拷时锟斤拷锟�\n");
			ex.printStackTrace();
		}finally{
			MySessionFactory.closeSession();
		}	
		return status;
	}

	/**装锟斤拷注锟斤拷锟皆�*/
	public Member loadMember(Integer id) throws Exception {
		Session session = MySessionFactory.getSession();
		Transaction tx = null;
		Member member = null;
		try{
			tx = session.beginTransaction();
			member = (Member)session.get(Member.class, id);
			tx.commit();
		}catch(Exception ex){
			if(tx!=null)tx.rollback();
			logger.info("锟斤拷执锟斤拷MemServiceImpl锟斤拷锟叫碉拷loadMember锟斤拷锟斤拷时锟斤拷锟�\n");
			ex.printStackTrace();
		}finally{
			MySessionFactory.closeSession();
		}	
		return member;
	}

}
