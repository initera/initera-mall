package com.initera.mall.portal.controller;

import com.initera.dto.UmsMemberLoginParamDTO;
import com.initera.dto.UmsMemberRegisterParamDTO;
import com.initera.mall.common.results.ResultWrapper;
import com.initera.service.impl.UmsMemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    UmsMemberServiceImpl umsMemberService;

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("register")
    public ResultWrapper register(@RequestBody UmsMemberRegisterParamDTO registerParamDTO) {
        umsMemberService.register(registerParamDTO);
        return ResultWrapper.getSuccessWrapper().data(null).build();

    }

    @PostMapping("login")
    public ResultWrapper ResultWrapper(@RequestBody @Valid UmsMemberLoginParamDTO loginParamDTO) {
        String token = umsMemberService.login(loginParamDTO);
        return ResultWrapper.getFailWrapper().data(token).build();
    }
}
