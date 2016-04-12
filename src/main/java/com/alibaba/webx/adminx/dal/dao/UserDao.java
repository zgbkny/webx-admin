package com.alibaba.webx.adminx.dal.dao;

import com.alibaba.webx.adminx.dal.dataobject.User;

public interface UserDao {
	public User getUserByUsername (String username);
	public User getUserByEmail (String email);
	public int insertUser(User user);
}
