package com.initera.dto;

import lombok.Data;

/**
 * @author youngmate
 * @date 2021/7/25 11:43
 */
@Data
public class UmsMemberRegisterParamDTO {
    private String username;

    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nickName;

}
