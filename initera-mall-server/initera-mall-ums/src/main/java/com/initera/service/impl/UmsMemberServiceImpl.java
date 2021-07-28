package com.initera.service.impl;

import com.initera.api.UmsMemberService;
import com.initera.dto.UmsMemberLoginParamDTO;
import com.initera.dto.UmsMemberRegisterParamDTO;
import com.initera.entity.UmsMember;
import com.initera.mall.common.results.ResultWrapper;
import com.initera.mall.uitl.JwtUtil;
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
    public ResultWrapper register(UmsMemberRegisterParamDTO registerParam) {
        UmsMember umsMember = new UmsMember();
        BeanUtils.copyProperties(registerParam, umsMember);
        umsMemberMapper.insert(umsMember);
        return ResultWrapper.getSuccessWrapper().data("success").build();
    }

    @Override
    public ResultWrapper login(UmsMemberLoginParamDTO loginParamDTO) {
        UmsMember umsMember = umsMemberMapper.selectByName(loginParamDTO.getUsername());
        if (null != umsMember) {
            String password = umsMember.getPassword();
            if (!passwordEncoder.matches(loginParamDTO.getPassword(), password)) {
                return ResultWrapper.getFailWrapper().data("密码不正确").build();
            }
        } else {
            return ResultWrapper.getFailWrapper().data("用户不存在").build();
        }

        return ResultWrapper.getSuccessWrapper().data(JwtUtil.createRequestToken(loginParamDTO.getUsername())).build();
    }

    @Override
    public ResultWrapper eidt(UmsMember umsMember) {
        umsMemberMapper.updateById(umsMember);
        return ResultWrapper.getSuccessWrapper().build();
    }
}
