package com.initera.mall.common.enums;

/**
 * 接口统一状态码
 *
 * <p>4001-4099，用户相关</p>
 * <p>5001-5099，业务相关</p>
 * <p>6001-6099，支付相关</p>
 * <p>...</p>
 *
 * @author youngmate
 * @date 2021/7/25 21:46
 */
public enum StateCodeEnum {

    /**
     * 成功
     */
    SUCCESS(0, "OK"),
    /**
     * 失败
     */
    FAIL(4001, "FAIL");

    StateCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


}
