package com.alibaba.webx.adminx.utils;

import com.alibaba.webx.adminx.dal.dataobject.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by wei on 2016/4/26.
 */
public class SerializeUtilTests {
    private User user = null;
    private Jedis jedis = JedisUtil.getInstance().getJedis("192.168.80.128", 6379);
    @Before
    public void beforeTest() {

    }

    @Test
    public void testSerialize() {
        user = new User("name1", "password1", "email134", 2, 3);
        int type = 9;
        int role = 12;
        user.setType(type);
        user.setRole(role);
        jedis.flushDB();
        String reply = jedis.set("user".getBytes(), SerializeUtil.serialize(user));
        System.out.println(reply);
        System.out.println(jedis.get("user".getBytes()));
        user = (User)SerializeUtil.unserialize(jedis.get("user".getBytes()));
        /*assert(user.getUsername().equals("name1"));
        assert(user.getPassword().equals("password1"));
        assert(user.getEmail().equals("email134"));
        assert(user.getType() == type);
        assert(user.getRole() == role);*/
    }

    @After
    public void afterTest() {

    }
}
