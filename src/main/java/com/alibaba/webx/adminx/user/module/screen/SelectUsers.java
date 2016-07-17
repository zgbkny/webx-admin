package com.alibaba.webx.adminx.user.module.screen;

import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.fastjson.JSON;
import com.alibaba.webx.adminx.biz.UserManager;
import com.alibaba.webx.adminx.dal.dataobject.ResultInfo;
import com.alibaba.webx.adminx.dal.dataobject.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by ww on 16-7-17.
 */
public class SelectUsers {
    private static final Logger logger = LoggerFactory.getLogger(SelectUsers.class);

    @Autowired
    private UserManager userManager;

    @Autowired
    private HttpServletResponse response;


    // url: user/selectUsers.do?role=laj@163.com&type=ajfglkajhlfkjh
    public void execute(@Param("role") String role, @Param("type") String type) {
        ResultInfo ri = new ResultInfo(ResultInfo.CODE_OK, "login ok");
        List<User> users = userManager.selectUsers(role, type);

        if (users == null) {
            ri.setCode(ResultInfo.CODE_ERR);
            ri.setInfo("not found users!");
        } else {
            ri.setInfo(JSON.toJSONString(users));
        }


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
