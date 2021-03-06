package com.alibaba.webx.adminx.biz;

import com.alibaba.webx.adminx.dal.dataobject.User;

import java.util.List;


/**
 * 有关用户的操作
 * 
 * @author ww
 *
 */
public interface UserManager {
	/**
     * 登录用户，如果用户名和密码正确，则返回相应的用户信息。
     *
     * @param userId   用户名
     * @param password 密码
     * @return 用户信息，如果用户名或密码不正确，则返回<code>null</code>
     */
    User login(String email, String password);

    /**
     * 注册用户。
     *
     * @param user 用户对象
     */
    void register(User user);


    /**
     * 更新用户的信息。
     *
     * @param user 用户对象
     */
    void update(User user);

    User checkSession(String sessionId);

    /**
     * 取得指定id的用户。
     *
     * @param userId 用户id
     * @return 指定id的用户
     */
    User getUser(String email);

    List<User> selectUsers(String role, String type);
}
