package com.initera.mapper;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.initera.entity.UmsMember;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author youngmate
 * @since 2021-07-23
 */
@Repository
public interface UmsMemberMapper extends BaseMapper<UmsMember> {

    UmsMember selectByName(String name);
}
