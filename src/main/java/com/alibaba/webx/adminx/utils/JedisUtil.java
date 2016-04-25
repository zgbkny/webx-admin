package com.alibaba.webx.adminx.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by wei on 2016/4/24.
 */
public class JedisUtil {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    private static Map<String, JedisPool> mp = new HashMap<String, JedisPool>();

    private JedisUtil() {}

    private static class JedisUtilHolder {
        private static final JedisUtil instance = new JedisUtil();
    }

    public static JedisUtil getInstance() {
        return JedisUtilHolder.instance;
    }

    private static JedisPool getPool(String ip, int port) {
        String key = ip + ":" + port;
        JedisPool jedisPool = null;
        jedisPool = mp.get(key);
        if (null == jedisPool) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(RedisConfig.MAX_TOTAL);
            config.setMaxIdle(RedisConfig.MAX_IDLE);
            config.setMaxWaitMillis(RedisConfig.MAX_WAIT);
            config.setTestOnBorrow(true);
            config.setTestOnReturn(true);

            jedisPool = new JedisPool(config, ip, port, RedisConfig.TIMEOUT);
            mp.put(key, jedisPool);
        }
        return jedisPool;
    }

    public static int getValue() {
        return 9898;
    }

    public static Jedis getJedis(String ip, int port) {
        Jedis jedis = null;
        int count = 0;
        do {
            JedisPool jedisPool = getPool(ip, port);
            jedis = jedisPool.getResource();
        } while (null == jedis && count++ < RedisConfig.RETRY_NUM);
        return jedis;
    }

    public static void closeJedis(Jedis jedis, String ip, int port) {
        if (jedis != null) {
            getPool(ip, port).returnResource(jedis);
        }
    }

    public static class RedisConfig {
        //可用连接实例的最大数目，默认值为8；
        //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
        public static int MAX_TOTAL = 3;
        //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
        public static int MAX_IDLE = 8;
        //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。
        // 如果超过等待时间，则直接抛出JedisConnectionException；
        public static int MAX_WAIT = 10000;
        public static int RETRY_NUM = 5;


        public static int TIMEOUT = 10;
    }
}
