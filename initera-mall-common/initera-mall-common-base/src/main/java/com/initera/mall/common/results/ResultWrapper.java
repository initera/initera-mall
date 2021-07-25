package com.initera.mall.common.results;

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
    private int code;
    private String msg;
    private T data;


}
