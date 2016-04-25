package com.alibaba.webx.adminx.biz.impl;

import com.alibaba.webx.adminx.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.webx.adminx.biz.UserManager;
import com.alibaba.webx.adminx.dal.dao.UserDao;
import com.alibaba.webx.adminx.dal.dataobject.User;
import redis.clients.jedis.Jedis;

import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public class UserManagerImpl implements UserManager {
	private static ConcurrentHashMap<String, User> sessionMap = new ConcurrentHashMap<String, User>();

	@Autowired
    private UserDao userDao;
	
	private static final Logger logger = LoggerFactory.getLogger(UserManagerImpl.class);
	public User login(String email, String password) {
		// TODO Auto-generated method stub
		User user = userDao.getUserByEmail(email);

		if (user != null && user.getPassword().equals(password)) {
			String sessionId = MD5Util.getMd5(email + password);
			user.setSessionId(sessionId);
			sessionMap.put(sessionId, user);
			return user;
		}
		else return null;
	}

	public void register(User user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	public User checkSession(String sessionId) {
		return sessionMap.get(sessionId);
	}

	public User getUser(String email) {
		// TODO Auto-generated method stub
		logger.info("UserManagerImpl getUser");
		Jedis jedis = new Jedis("localhost");
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		logger.info("UserManagerImpl login " + value);

		User user = userDao.getUserByEmail(email);
		if (user != null) {
			logger.info("user:" + user.getPassword());
		}
		return null;
	}

	public static class SessionTask extends TimerTask {

		@Override
		public void run() {
			sessionMap.clear();
		}
	}
}
