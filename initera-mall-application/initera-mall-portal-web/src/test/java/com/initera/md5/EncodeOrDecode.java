package com.initera.md5;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * @author youngmate
 * @date 2021/7/25 16:40
 */
public class EncodeOrDecode {

    @Test
    void md5Encode() {
        String sourceCode = "123456";
        String hex = DigestUtils.md5DigestAsHex(sourceCode.getBytes());
        System.out.println("第一次" + hex);
        hex = DigestUtils.md5DigestAsHex(sourceCode.getBytes());
        System.out.println("第二次" + hex);

    }

    @Test
    void bcrypt() {
        String sourceCode = "123456";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(sourceCode);
        System.out.println("第一次" + encode);
        System.out.println(encoder.matches(sourceCode, encode));
        encode = encoder.encode(sourceCode);
        System.out.println("第二次" + encode);
        System.out.println(encoder.matches(sourceCode, encode));
    }

}
