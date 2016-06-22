package com.alibaba.webx.adminx.dal.dao.mongo;

import org.junit.Test;

/**
 * Created by wei on 2016/6/6.
 */
public class MongoBlogDaoTests {

    @Test()
    public void testMongoBlog() throws InterruptedException {
        MongoBlogDao dao = new MongoBlogDao();
        dao.getBlogsByKey("");
    }
}
