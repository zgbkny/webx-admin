package com.alibaba.webx.adminx.biz.impl;

import com.alibaba.webx.adminx.biz.BlogManager;
import com.alibaba.webx.adminx.dal.dao.BlogDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wei on 2016/6/6.
 */
public class BlogManagerImpl implements BlogManager {

    @Autowired
    private BlogDao blogDao;

    public List<String> getBlogsByKey() {
        return blogDao.getBlogsByKey("");
    }
}
