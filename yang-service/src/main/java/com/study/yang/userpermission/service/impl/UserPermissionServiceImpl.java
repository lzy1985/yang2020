package com.study.yang.userpermission.service.impl;

import com.study.yang.base.service.impl.BaseServiceImpl;
import com.study.yang.userpermission.dto.UserPermissionDTO;
import com.study.yang.userpermission.manager.IUserPermissionManager;
import com.study.yang.userpermission.service.IUserPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户权限表 ServiceImpl
 * @author lzy
 * @version 1.0.0
 * @since 2017/10/16 17:11
 */
@Slf4j
@Service
public class UserPermissionServiceImpl extends BaseServiceImpl<IUserPermissionManager, UserPermissionDTO> implements IUserPermissionService {

}
