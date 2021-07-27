package com.initera.mall.uitl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author youngmate
 * @date 2021/7/27 21:51
 */
class JwtUtilTest {

    @Test
    void jwtTest() {
        String subject = "可心可爱";
        String token = JwtUtil.createAccessToken(subject);
        String s = JwtUtil.parseToken(token);
        Assertions.assertEquals(subject, s);
    }

}