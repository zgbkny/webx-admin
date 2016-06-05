package com.alibaba.webx.adminx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Timer;
import com.alibaba.webx.adminx.biz.impl.UserManagerImpl.SessionTask;

/**
 * Created by wei on 2016/4/13.
 */
public class TimerListner implements ServletContextListener {
    private Timer timer;
    private static final Logger logger = LoggerFactory.getLogger(TimerListner.class);
    public void contextInitialized(ServletContextEvent event) {
        logger.info("this context Initialized");
        timer = new Timer(true);
        timer.schedule(new SessionTask(), 0, 4000);
    }

    public void contextDestroyed(ServletContextEvent event) {
        logger.info("this contextDestroyed");
        if (timer != null) {
            timer.cancel();
        }
    }
}
