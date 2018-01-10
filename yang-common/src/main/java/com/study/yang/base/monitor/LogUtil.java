package com.study.yang.base.monitor;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/12 下午12:21
 * @Description
 */
public class LogUtil {

    public static final String TRACE_ID="traceId";
    public static String traceID(){
        return String.valueOf(System.currentTimeMillis());
    }
    public static String traceID(String name){
        return name+":"+String.valueOf(System.currentTimeMillis());
    }
}
