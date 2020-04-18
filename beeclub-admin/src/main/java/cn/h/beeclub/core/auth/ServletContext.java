package cn.h.beeclub.core.auth;

import cn.h.beeclub.admin.system.domain.SysAdmin;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletContext {

    private static final ThreadLocal<ServletContext> SERVLET_CONTEXT_THREAD_LOCAL = new ThreadLocal<ServletContext>(){
        @Override
        protected ServletContext initialValue() {
            return new ServletContext();
        }
    };

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;


    public static void start(ServletRequest req, ServletResponse res){
        ServletContext.SERVLET_CONTEXT_THREAD_LOCAL.get().request = (HttpServletRequest) req;
        ServletContext.SERVLET_CONTEXT_THREAD_LOCAL.get().response = (HttpServletResponse) res;
        ServletContext.SERVLET_CONTEXT_THREAD_LOCAL.get().session = ((HttpServletRequest) req).getSession();
    }

    public static Object  getSessionAttr(String name){
        return ServletContext.SERVLET_CONTEXT_THREAD_LOCAL.get().session.getAttribute(name);
    }
    public static void setSessionAttr(String name, Object value){
        ServletContext.SERVLET_CONTEXT_THREAD_LOCAL.get().session.setAttribute(name, value);
    }

    public static SysAdmin getCurrentAdmin(){
        return (SysAdmin) getSessionAttr("SESSION_USER");
    }

    public static boolean isLogin(){
        return getSessionAttr("SESSION_USER") != null;
    }
}
