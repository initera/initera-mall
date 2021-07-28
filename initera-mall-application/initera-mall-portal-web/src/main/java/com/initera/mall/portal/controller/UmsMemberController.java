package com.initera.mall.portal.controller;

import com.initera.dto.UmsMemberLoginParamDTO;
import com.initera.dto.UmsMemberRegisterParamDTO;
import com.initera.entity.UmsMember;
import com.initera.mall.common.anotations.TokenCheck;
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
        return umsMemberService.register(registerParamDTO);

    }

    @PostMapping("login")
    public ResultWrapper login(@RequestBody @Valid UmsMemberLoginParamDTO loginParamDTO) {
        return umsMemberService.login(loginParamDTO);
    }

    @PostMapping("editUmsInfo")
    @TokenCheck
    public ResultWrapper editUmsInfo(@RequestBody UmsMember umsMember) {
        return umsMemberService.eidt(umsMember);

    }
}
