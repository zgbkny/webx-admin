package com.alibaba.webx.adminx.user.module.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.webx.adminx.biz.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wei on 2016/4/7.
 */
public class Register {
    @Autowired
    private UserManager userManager;

    private static final Logger logger = LoggerFactory.getLogger(Login.class);

    public void execute(@Param("name") String name, Context context) {

        logger.info("hello here" + name);
        userManager.getUser("");
        logger.info("？");


        context.put("name", name);
    }
}
