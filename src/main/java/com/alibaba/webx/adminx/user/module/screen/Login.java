package com.alibaba.webx.adminx.user.module.screen;

import com.alibaba.fastjson.JSON;
import com.alibaba.webx.adminx.dal.dataobject.ResultInfo;
import com.alibaba.webx.adminx.dal.dataobject.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.webx.adminx.biz.UserManager;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login {
	private static final Logger logger = LoggerFactory.getLogger(Login.class);

	@Autowired
    private UserManager userManager;

	@Autowired
	private HttpServletResponse response;

	// url: user/login.do?email=laj@163.com&password=ajfglkajhlfkjh
	public void execute(@Param("email") String email, @Param("password") String password) {
		ResultInfo ri = new ResultInfo(ResultInfo.CODE_OK, "login ok");
		User user = userManager.login(email, password);

		if (user == null) {
			ri.setCode(ResultInfo.CODE_ERR);
			ri.setInfo("login error");
		} else {
			// 生成session
			ri.setInfo(user.getSessionId());
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
