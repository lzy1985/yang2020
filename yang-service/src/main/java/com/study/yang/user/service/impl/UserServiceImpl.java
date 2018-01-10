package com.study.yang.user.service.impl;

import com.study.yang.base.service.impl.BaseServiceImpl;
import com.study.yang.user.dto.UserDTO;
import com.study.yang.user.manager.IUserManager;
import com.study.yang.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户表 ServiceImpl
 * @author lzy
 * @version 1.0.0
 * @since 2017/10/16 17:11
 */
@Slf4j
@Service
public class UserServiceImpl extends BaseServiceImpl<IUserManager, UserDTO> implements IUserService {

}
