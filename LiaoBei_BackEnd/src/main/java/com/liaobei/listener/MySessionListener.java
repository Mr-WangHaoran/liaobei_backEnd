package com.liaobei.listener;

import com.liaobei.util.MySessionContext;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author whr
 * @description session行为监听器
 */
public class MySessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        MySessionContext.AddSession(httpSessionEvent.getSession());
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        MySessionContext.DelSession(session);
    }
}
