package com.alibaba.webx.adminx.dal.dao.ibatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.webx.adminx.dal.dao.UserDao;
import com.alibaba.webx.adminx.dal.dataobject.User;

public class IbatisUserDao extends SqlMapClientDaoSupport implements UserDao {
	private static final Logger logger = LoggerFactory.getLogger(IbatisUserDao.class);
	public User getUserById (String userId) {
		// TODO Auto-generated method stub
		logger.info("ibatisUserDao getUser");
		return (User) getSqlMapClientTemplate().queryForObject("getUserByUserId", userId);
	}
}
