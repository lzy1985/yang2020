package com.study.yang.userrole.service.impl;

import com.study.yang.base.service.impl.BaseServiceImpl;
import com.study.yang.userrole.dto.UserRoleDTO;
import com.study.yang.userrole.manager.IUserRoleManager;
import com.study.yang.userrole.service.IUserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户角色中间表 ServiceImpl
 * @author lzy
 * @version 1.0.0
 * @since 2017/10/16 17:11
 */
@Slf4j
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<IUserRoleManager, UserRoleDTO> implements IUserRoleService {

}
