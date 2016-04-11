package com.alibaba.webx.adminx.user.module.screen;

import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.webx.adminx.biz.UserManager;
import com.alibaba.webx.adminx.dal.dataobject.ResultInfo;
import com.alibaba.webx.adminx.dal.dataobject.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wei on 2016/4/7.
 */
public class Register {
    private static final Logger logger = LoggerFactory.getLogger(Login.class);

    @Autowired
    private UserManager userManager;

    @Autowired
    private HttpServletResponse response;

    public void execute(@Param("userId") String userId,
                        @Param("email") String email,
                        @Param("password") String password) {

        logger.info("register " + userId);
        userManager.getUser("");
        logger.info("？");
        User user = new User(userId, password, email, User.TYPE_NORM, User.ROLE_USER);
        userManager.register(user);
        ResultInfo ri = new ResultInfo(ResultInfo.CODE_OK, "register ok");
        String result = JSON.toJSONString(ri);
        response.setContentType("text/json");
        try {
            PrintWriter out = response.getWriter();
            out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
