package com.alibaba.webx.adminx.utils;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wei on 2016/4/25.
 */
public class JedisUtilTests {
    private int k = 0;
    @Before()
    public void setUp() {
        k = 1000;
    }

    @Test()
    public void testGetValue() {
        //System.out.println("hello");
        assert(k == 1000);
        assert(JedisUtil.getValue() == 9898);
    }

    @Test()
    public void testGetValue1() {
        assert(JedisUtil.getValue() == 9898);
    }

    /*@After()
    protected void afterDo() {

    }*/
}
