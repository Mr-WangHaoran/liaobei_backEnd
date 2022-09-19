package com.liaobei.util;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author whr
 * @description java Servlet2.1后不支持直接使用sessionid获取session，所以要手动实现一个类
 */
public class MySessionContext {
    private static HashMap mymap = new HashMap();

    public static synchronized void AddSession(HttpSession session) {
        if (session != null) {
            mymap.put(session.getId(), session);
        }
    }

    public static synchronized void DelSession(HttpSession session) {
        if (session != null) {
            mymap.remove(session.getId());
        }
    }

    public static synchronized HttpSession getSession(String session_id) {
        if (session_id == null)
            return null;
        return (HttpSession) mymap.get(session_id);
    }
}
