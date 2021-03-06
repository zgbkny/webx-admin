package com.alibaba.webx.adminx.dal.dao.ibatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.webx.adminx.dal.dao.UserDao;
import com.alibaba.webx.adminx.dal.dataobject.User;

import java.util.List;

public class IbatisUserDao extends SqlMapClientDaoSupport implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(IbatisUserDao.class);
	public User getUserByUsername (String username) {
		// TODO Auto-generated method stub
		logger.info("ibatisUserDao getUser");
		return (User) getSqlMapClientTemplate().queryForObject("getUserByUsername", username);
	}


	public User getUserByEmail (String email) {
		return (User) getSqlMapClientTemplate().queryForObject("getUserByEmail", email);
	}

	public int insertUser(User user) {
		return getSqlMapClientTemplate().update("insertUser", user);
	}

	public List<User> selectUsers(User user) {
		logger.info(String.format("ibatisUserDao selectUsers role:%d type:%d", user.getRole(), user.getType()));
		return (List<User>) getSqlMapClientTemplate().queryForList("selectUsersByRoleAndType", user);
	}
}
