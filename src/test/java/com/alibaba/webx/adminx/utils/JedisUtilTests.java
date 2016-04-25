package com.alibaba.webx.adminx.utils;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wei on 2016/4/25.
 */
public class JedisUtilTests {
    @Before()
    protected void setUp() {

    }

    @Test()
    public void testGetValue() {
        assert(JedisUtil.getValue() == 9898);
    }

    @Test()
    public void testGetValue1() {
        assert(JedisUtil.getValue() == 9898);
    }

    @After()
    protected void afterDo() {

    }
}
