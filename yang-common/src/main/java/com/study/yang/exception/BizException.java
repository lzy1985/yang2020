package com.study.yang.exception;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/26 下午2:31
 * @Description
 */
public class BizException extends RuntimeException {


    public BizException(Throwable e) {
        super(e.getMessage(), e);
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable throwable) {
        super(message, throwable);
    }
}