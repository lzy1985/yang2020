package com.study.yang.permission.service.impl;

import com.study.yang.base.service.impl.BaseServiceImpl;
import com.study.yang.permission.dto.PermissionDTO;
import com.study.yang.permission.manager.IPermissionManager;
import com.study.yang.permission.service.IPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 权限表 ServiceImpl
 * @author lzy
 * @version 1.0.0
 * @since 2017/10/16 17:11
 */
@Slf4j
@Service
public class PermissionServiceImpl extends BaseServiceImpl<IPermissionManager, PermissionDTO> implements IPermissionService {

}
