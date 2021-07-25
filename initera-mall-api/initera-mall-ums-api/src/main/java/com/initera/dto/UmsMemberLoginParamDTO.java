package com.initera.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author youngmate
 * @date 2021/7/25 16:56
 */
@Data
public class UmsMemberLoginParamDTO {
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;
    /**
     * 密码
     */
    private String password;
}
