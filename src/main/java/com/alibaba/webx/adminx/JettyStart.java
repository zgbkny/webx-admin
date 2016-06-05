package com.alibaba.webx.adminx;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.webx.adminx.dal.dataobject.HelloHandler;
import com.alibaba.webx.adminx.dal.dataobject.User;


public class JettyStart {
	public static final String CONTEXT = "/";
	private static final String DEFAULT_WEBAPP_PATH = "src/main/webapp";
	private static final Logger logger = LoggerFactory.getLogger(JettyStart.class);
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Server server = new Server(8080);
		HelloHandler hh = null;
		User user = null;
		WebAppContext context = new WebAppContext(DEFAULT_WEBAPP_PATH, CONTEXT);  
		context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
        context.setResourceBase(DEFAULT_WEBAPP_PATH);  
        //context.setClassLoader(Thread.currentThread().getContextClassLoader());
        context.setParentLoaderPriority(true);  
        server.setHandler(context);  
        logger.info("server start here");
        server.start();  
        logger.info("server start over");
        server.join(); 
	}

}
