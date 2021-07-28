package com.initera.mall.portal.interceptor;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.initera.mall.common.anotations.TokenCheck;
import com.initera.mall.common.exceptions.TokenException;
import com.initera.mall.uitl.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author youngmate
 * @date 2021/7/28 22:57
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入拦截器");
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {
            throw new TokenException("Token 为空");
        }

//        入参中的handler为要处理的方法，将其转为HandlerMethod
        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        获取方法对象
        Method method = handlerMethod.getMethod();
//        判断方法是否含有TokenCheck注解
        if (method.isAnnotationPresent(TokenCheck.class)) {
//            包含的话，拿到注解对象
            TokenCheck annotation = method.getAnnotation(TokenCheck.class);
//            判断注解对象的required参数，若为true则需要进行token校验
            if (annotation.required()) {
//                校验token
                try {
                    JwtUtil.parseToken(token);
                } catch (Exception e) {
                    throw new TokenException("token 异常");
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
