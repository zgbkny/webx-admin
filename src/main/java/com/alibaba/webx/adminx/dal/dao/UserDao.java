package com.alibaba.webx.adminx.dal.dao;

import com.alibaba.webx.adminx.dal.dataobject.User;

public interface UserDao {
	public User getUserByUserId (String userId);
	public int insertUser(User user);
}
