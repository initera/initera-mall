package com.initera.dto;

import lombok.Data;

/**
 * @author youngmate
 * @date 2021/7/25 16:56
 */
@Data
public class UmsMemberLoginParamDTO {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
