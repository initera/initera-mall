package com.initera.mall.uitl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author youngmate
 * @date 2021/7/25 15:26
 */
public class JwtUtil {

    private static final String SECRET = "initera";

    /**
     * 创建Access Token，有效时间问7200秒
     */
    public static String createAccessToken(String subject) {
        return getToken(subject, 7200L);
    }

    /**
     * 创建RequestToken，有效时间为7天
     */
    public static String createRequestToken(String subject) {
        return getToken(subject, 86400 * 7L);
    }


    private static String getToken(String subject, Long seconds) {
        return Jwts.builder().setSubject(subject)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * seconds))
                .compact();
    }

    public static String parseToken(String token) {
        Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return body.getSubject();

    }

}
