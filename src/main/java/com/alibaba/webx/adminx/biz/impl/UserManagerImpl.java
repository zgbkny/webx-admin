package com.alibaba.webx.adminx.biz.impl;

import com.alibaba.webx.adminx.utils.MD5Util;
import com.alibaba.webx.adminx.utils.SerializeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.webx.adminx.biz.UserManager;
import com.alibaba.webx.adminx.dal.dao.UserDao;
import com.alibaba.webx.adminx.dal.dataobject.User;
import redis.clients.jedis.Jedis;

import java.util.List;
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
			updateUserCache(sessionId, user);
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
		return getUserCache(sessionId);
	}

	public User getUser(String email) {
		// TODO Auto-generated method stub
		User user = userDao.getUserByEmail(email);
		if (user != null) {
			logger.info("user:" + user.getPassword());
		}
		return null;
	}

	public List<User> selectUsers(String role, String type) {
		int roleInt = 0;
		int typeInt = 0;
		try {
			roleInt = Integer.parseInt(role);
			typeInt = Integer.parseInt(type);
		} catch (Exception e) {
			logger.warn("UserManagerImpl selectUsers format error");
			return null;
		}
		User user = new User();
		user.setRole(roleInt);
		user.setType(typeInt);
		return userDao.selectUsers(user);
	}

	public static class SessionTask extends TimerTask {

		@Override
		public void run() {
			logger.info("sesison task");
			sessionMap.clear();
		}
	}

	public void updateUserCache(String sessionId, User user) {

	}

	public User getUserCache(String sessionId) {

		return null;
	}

}
