package com.alibaba.webx.adminx.blog.module.screen;

import com.alibaba.citrus.turbine.dataresolver.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wei on 2016/5/24.
 */
public class List {

    private static final Logger logger = LoggerFactory.getLogger(List.class);

    // url: blog/list.do?key=laj@163.com&page=ajfglkajhlfkjh
    public void execute(@Param("key") String key, @Param("page") int page) {
        logger.info("key:" + key + "; page" + page);

    }
}
