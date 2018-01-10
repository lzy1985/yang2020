package com.study.yang.base.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/10/17 上午11:33
 * @Description
 */
@Slf4j
public class RequestContextHolder {
    /**
     * 当前请求的请求对象
     */
    private static ThreadLocal<HttpServletRequest> request = new ThreadLocal<HttpServletRequest>();

    /**
     * 当前请求的返回对象
     */
    private static ThreadLocal<HttpServletResponse> response = new ThreadLocal<HttpServletResponse>();

    /**
     * 当前请求的请求参数
     */
    private static ThreadLocal<Object> requestArgument = new ThreadLocal<Object>();

    /**
     * 当前请求的请求ID
     */
    private static ThreadLocal<String> requestId = new ThreadLocal<String>();

    public static HttpServletRequest getRequest() {
        return request.get();
    }

    public static void setRequest(HttpServletRequest request) {
        RequestContextHolder.request.set(request);
    }

    public static HttpServletResponse getResponse() {
        return response.get();
    }

    public static void setResponse(HttpServletResponse response) {
        RequestContextHolder.response.set(response);
    }

    public static Object getRequestArgument() {
        return requestArgument.get();
    }

    public static void setRequestArgument(Object requestArgument) {
        RequestContextHolder.requestArgument.set(requestArgument);
    }

    public static String getRequestId() {
        return requestId.get();
    }

    public static void setRequestId(String requestId) {
        RequestContextHolder.requestId.set(requestId);
    }

    public static void clear() {
        log.info("清除RequestContextHolder中数据");
        request.remove();
        response.remove();
        requestArgument.remove();
        requestId.remove();
    }
}
