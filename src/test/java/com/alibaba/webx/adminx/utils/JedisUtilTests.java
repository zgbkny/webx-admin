package com.alibaba.webx.adminx.utils;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by wei on 2016/4/25.
 */
public class JedisUtilTests {
    private int k = 0;
    private Jedis jedis = null;
    @Before()
    public void beforeTest() {
        jedis = JedisUtil.getInstance().getJedis("192.168.80.128", 6379);
    }

    @Test()
    public void testGetValue() {
        //System.out.println("hello");
        assert(k == 0);
    }

    @Test()
    public void testKey() throws InterruptedException {
        System.out.println("清空数据："+jedis.flushDB());
        System.out.println("判断某个键是否存在："+jedis.exists("username"));
        System.out.println("新增<'username','zzh'>的键值对："+jedis.set("username", "zzh"));
        System.out.println(jedis.exists("name"));
        System.out.println("新增<'password','password'>的键值对："+jedis.set("password", "password"));
        System.out.print("系统中所有的键如下：");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println("删除键password:"+jedis.del("password"));
        System.out.println("判断键password是否存在："+jedis.exists("password"));
        System.out.println("设置键username的过期时间为5s:"+jedis.expire("username", 5));
        TimeUnit.SECONDS.sleep(6);
        System.out.println("查看键username的剩余生存时间kkk：" + jedis.get("username"));
        System.out.println("查看键username的剩余生存时间："+jedis.ttl("username"));
        System.out.println("移除键username的生存时间："+jedis.persist("username"));
        System.out.println("查看键username的剩余生存时间："+jedis.ttl("username"));
        System.out.println("查看键username所存储的值的类型："+jedis.type("username"));
    }

    @After()
    public void afterTest() {

    }
}
