package com.bolo.examples.dao.base;

import org.springframework.stereotype.Repository;

import com.bolo.examples.common.orm.hibernate3.HibernateDao;
import com.bolo.examples.entity.base.Channel;

@Repository
public class ChannelDao extends HibernateDao<Channel> {
	
}
