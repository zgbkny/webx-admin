package com.alibaba.webx.adminx.biz;

import com.alibaba.webx.adminx.dal.dataobject.User;

/**
 * Created by wei on 2016/4/13.
 */
public interface JedisManager {
    User getUserBySessionId(String sessionId);
}
