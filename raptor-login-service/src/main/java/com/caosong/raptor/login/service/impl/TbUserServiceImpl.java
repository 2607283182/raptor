package com.caosong.raptor.login.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caosong.raptor.login.entity.TbUser;
import com.caosong.raptor.login.mapper.TbUserMapper;
import com.caosong.raptor.login.service.ITbUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author caosong
 * @since 2021-04-08
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

}
