package com.initera.mall.uitl;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author youngmate
 * @date 2021/7/25 15:26
 */
public class EncodeAndDecode {

    public static String md5Encode(String sourceCode) {
        return DigestUtils.md5DigestAsHex(sourceCode.getBytes(StandardCharsets.UTF_8));
    }

    public static String bcrypt(String sourceCode) {

        return null;

    }

}
