package com.initera.mall.common.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author youngmate
 * @date 2021/7/28 22:52
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenCheck {

    /**
     * 是否校验token，默认为true（校验）
     */
    boolean required() default true;
}
