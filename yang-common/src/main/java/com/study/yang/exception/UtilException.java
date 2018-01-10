package com.study.yang.exception;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/6 上午11:18
 * @Description
 */
public class UtilException extends RuntimeException {

    private static final long serialVersionUID = 8247610319171014183L;

    public UtilException(Throwable e) {
        super(e.getMessage(), e);
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
