package com.study.yang.base.dto;


import lombok.Data;

import java.io.Serializable;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/7 14:39
 * @Description
 */
@Data
public class ResponseDto implements Serializable{
    private static final long serialVersionUID = -4823751808465357344L;

    /**
     * 成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 失败标识
     */
    public static final String FAIL = "1";

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回结果
     */
    private Object data;

    /**
     * 默认构造方法
     */
    public ResponseDto() {

    }

    public ResponseDto(String code,String message) {
        this.code = code;
        this.message =  message;
    }

    public ResponseDto(String code,Object data) {
        this.code = code;
        this.data = data;
    }

    public ResponseDto(String code,String message,Object data) {
        this.code = code;
        this.message =  message;
        this.data = data;
    }

    /**
     * 成功
     *
     * @return
     */
    public static ResponseDto bulidSuccess() {
        ResponseDto dto = new ResponseDto();
        dto.setCode(SUCCESS);
        return dto;
    }

    /**
     * 成功
     *
     * @param message 操作信息
     * @return
     */
    public static ResponseDto bulidSuccess(String message) {
        return new ResponseDto(SUCCESS,message);
    }

    /**
     * 成功
     *
     * @param data 返回结果信息
     * @return
     */
    public static ResponseDto bulidSuccess(Object data) {
        return new ResponseDto(SUCCESS,data);
    }

    /**
     * 成功
     *
     * @param message 操作信息
     * @param data    返回结果信息
     * @return
     */
    public static ResponseDto bulidSuccess(String message, Object data) {
        return new ResponseDto(SUCCESS,message,data);
    }

    /**
     * 失败
     *
     * @return
     */
    public static ResponseDto bulidFail() {
        ResponseDto dto = new ResponseDto();
        dto.setCode(FAIL);
        return dto;
    }

    /**
     * 失败
     *
     * @param message 操作信息
     * @return
     */
    public static ResponseDto bulidFail(String message) {
        return new ResponseDto(FAIL,message);
    }

    /**
     * 失败
     *
     * @param data 返回结果信息
     * @return
     */
    public static ResponseDto bulidFail(Object data) {
        return new ResponseDto(FAIL,data);
    }

    /**
     * 失败
     *
     * @param message 操作信息
     * @param data    返回结果信息
     * @return
     */
    public static ResponseDto bulidFail(String message, Object data) {
        return new ResponseDto(FAIL,message,data);
    }
}
