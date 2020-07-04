package com.demo.user.service.impl;

import com.demo.user.entity.NUser;
import com.demo.user.mapper.NUserMapper;
import com.demo.user.service.INUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  user service implements
 * </p>
 *
 * @author Larry_lee
 * @since 2020-07-04
 */
@Service
public class NUserServiceImpl extends ServiceImpl<NUserMapper, NUser> implements INUserService {

}
