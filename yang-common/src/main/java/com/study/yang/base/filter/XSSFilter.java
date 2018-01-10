package com.study.yang.base.filter;

import com.study.yang.base.util.RequestContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/11 上午9:20
 * @Description
 */
public class XSSFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 强制类型转换 HttpServletRequest
        HttpServletRequest httpReq = (HttpServletRequest) request;
        // 构造HttpRequestWrapper对象处理XSS
        HttpRequestWrapper httpReqWarp = new HttpRequestWrapper(httpReq);
        RequestContextHolder.setRequest(httpReq);
        // 执行下一个过滤器
        chain.doFilter(httpReqWarp, response);
        RequestContextHolder.clear();
    }

    public void destroy() {
        RequestContextHolder.clear();
    }
}
