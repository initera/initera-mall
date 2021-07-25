package com.initera.mall.portal.controller;

import com.initera.api.UmsMemberService;
import com.initera.dto.UmsMemberLoginParamDTO;
import com.initera.dto.UmsMemberRegisterParamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author youngmate
 * @since 2021-07-23
 */
@RestController
@RequestMapping("/ums-member")
public class UmsMemberController {

    @Autowired
    UmsMemberService umsMemberService;

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("register")
    public String register(@RequestBody UmsMemberRegisterParamDTO registerParamDTO) {
        return umsMemberService.register(registerParamDTO);
    }

    @PostMapping("login")
    public String login(@RequestBody UmsMemberLoginParamDTO loginParamDTO) {
        return umsMemberService.login(loginParamDTO);
    }
}
