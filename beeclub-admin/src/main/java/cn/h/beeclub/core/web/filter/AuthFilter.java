package cn.h.beeclub.core.web.filter;

import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.core.auth.ServletContext;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {

    private String[] includes;
    private String[] excludes;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        includes = new String[]{};
        excludes = new String[]{"/login","/doLogin","/favicon.ico"};
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        System.out.println(uri);
        ServletContext.start(servletRequest, servletResponse);
        if(uri.contains("/login") || uri.contains("/doLogin") ||uri.contains("/favicon.ico")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        if(!ServletContext.isLogin()){
            if(isAjax(request)){
                SimpleResult<Integer> simpleResult = new SimpleResult<>(401,"未登录，请先登录。");
                servletResponse.getWriter().write(JSON.toJSONString(servletRequest));
                return;
            }
            response.sendRedirect("/login");
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println(uri);
    }

    @Override
    public void destroy() {

    }

    private boolean isAjax(HttpServletRequest request){
        String requestType = request.getHeader("X-Requested-With");
        if(requestType != null && requestType.equalsIgnoreCase("XMLHttpRequest")){
            return true;
        }
        return false;
    }
}
