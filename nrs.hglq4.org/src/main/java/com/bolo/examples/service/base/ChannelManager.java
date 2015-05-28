package com.bolo.examples.service.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolo.examples.dao.base.ChannelDao;

@Service
public class ChannelManager {
	
	@Autowired
	private ChannelDao channelDao;
	
	//public Set getAllArticle
}
