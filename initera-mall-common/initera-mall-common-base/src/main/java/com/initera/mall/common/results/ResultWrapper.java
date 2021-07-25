package com.initera.mall.common.results;

import com.initera.mall.common.enums.StateCodeEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author youngmate
 * @date 2021/7/25 21:54
 */
@Data
@Builder
public class ResultWrapper<T> implements Serializable {
    /**
     * 状态码
     */
    private int code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

    /**
     * 成功时的wrapper
     */
    public static ResultWrapper.ResultWrapperBuilder getSuccessWrapper() {
        return ResultWrapper.builder().code(StateCodeEnum.SUCCESS.getCode()).msg(StateCodeEnum.SUCCESS.getMsg());
    }

    /**
     * 失败时的wrapper
     */
    public static ResultWrapper.ResultWrapperBuilder getFailWrapper() {
        return ResultWrapper.builder().code(StateCodeEnum.FAIL.getCode()).msg(StateCodeEnum.FAIL.getMsg());
    }

    /**
     * 通过StateCodeEnum获得wrapper
     */
    public static ResultWrapper.ResultWrapperBuilder getResultWrapper(StateCodeEnum stateCodeEnum) {
        return ResultWrapper.builder().code(stateCodeEnum.getCode()).msg(stateCodeEnum.getMsg());
    }

}
