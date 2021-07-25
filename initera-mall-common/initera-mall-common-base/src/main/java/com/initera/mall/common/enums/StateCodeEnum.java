package com.initera.mall.common.enums;

/**
 * @author youngmate
 * @date 2021/7/25 21:46
 */
public enum StateCodeEnum {

    /***/
    SUCCESS(0, "OK"),
    FAIL(4001, "FAIL");

    StateCodeEnum(int code, String msg) {
    }

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
