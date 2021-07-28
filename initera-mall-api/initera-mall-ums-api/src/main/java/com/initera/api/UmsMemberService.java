package com.initera.api;

import com.initera.dto.UmsMemberLoginParamDTO;
import com.initera.dto.UmsMemberRegisterParamDTO;
import com.initera.entity.UmsMember;
import com.initera.mall.common.results.ResultWrapper;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author youngmate
 * @since 2021-07-23
 */
public interface UmsMemberService {

    /**
     * 用户注册
     *
     * @return 注册状态
     */
    ResultWrapper register(UmsMemberRegisterParamDTO registerParam);

    /**
     * 用户登录
     *
     * @param loginParamDTO 登录参数
     * @return 登录状态
     */
    ResultWrapper login(UmsMemberLoginParamDTO loginParamDTO);

    /**
     * 编辑用户信息
     */
    ResultWrapper eidt(UmsMember umsMember);
}
