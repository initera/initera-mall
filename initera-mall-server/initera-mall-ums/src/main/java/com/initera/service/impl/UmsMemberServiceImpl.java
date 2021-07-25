package com.initera.service.impl;

import com.initera.api.UmsMemberService;
import com.initera.dto.UmsMemberLoginParamDTO;
import com.initera.dto.UmsMemberRegisterParamDTO;
import com.initera.entity.UmsMember;
import com.initera.mapper.UmsMemberMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author youngmate
 * @since 2021-07-23
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String register(UmsMemberRegisterParamDTO registerParam) {
        UmsMember umsMember = new UmsMember();
        BeanUtils.copyProperties(registerParam, umsMember);
        umsMemberMapper.insert(umsMember);
        return "success";
    }

    @Override
    public String login(UmsMemberLoginParamDTO loginParamDTO) {
        UmsMember umsMember = umsMemberMapper.selectByName(loginParamDTO.getUsername());
        if (null != umsMember) {
            String password = umsMember.getPassword();
            if (!passwordEncoder.matches(loginParamDTO.getPassword(), password)) {
                return "密码不正确";
            }
        } else {
            return "用户不存在";
        }
        return "token";
    }
}
