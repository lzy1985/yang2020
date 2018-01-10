package com.study.yang.userpermission.manager.impl;

import com.google.common.collect.Lists;
import com.study.yang.base.manager.impl.BaseManagerImpl;
import com.study.yang.userpermission.dao.IUserPermissionDAO;
import com.study.yang.userpermission.dto.UserPermissionDTO;
import com.study.yang.userpermission.entity.UserPermissionEntity;
import com.study.yang.userpermission.manager.IUserPermissionManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户权限表 ManagerImpl
 * @author lzy
 * @version 1.0.0
 * @since 2017/10/16 17:11
 */
@Slf4j
@Component
public class UserPermissionManagerImpl extends BaseManagerImpl<IUserPermissionDAO, UserPermissionEntity, UserPermissionDTO> implements IUserPermissionManager {

    @Override
    protected List<UserPermissionDTO> transferToDTOList(List<UserPermissionEntity> userpermissionEntityList) {
        List<UserPermissionDTO> userpermissionDTOList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(userpermissionEntityList)) {
            for (UserPermissionEntity userpermissionEntity : userpermissionEntityList) {
                UserPermissionDTO userpermissionDTO = transferToDTO(userpermissionEntity);
                userpermissionDTOList.add(userpermissionDTO);
            }
        }
        return userpermissionDTOList;
    }

    @Override
    protected UserPermissionDTO transferToDTO(UserPermissionEntity userpermissionEntity) {
        UserPermissionDTO userpermissionDTO = new UserPermissionDTO();
        BeanUtils.copyProperties(userpermissionEntity,userpermissionDTO);
        userpermissionEntity = null;
        return userpermissionDTO;
    }

    @Override
    protected List<UserPermissionEntity> transferToEntityList(List<UserPermissionDTO> userpermissionDTOList) {
        List<UserPermissionEntity> userpermissionEntityList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(userpermissionDTOList)) {
            for (UserPermissionDTO userpermissionDTO : userpermissionDTOList) {
                UserPermissionEntity userpermissionEntity = transferToEntity(userpermissionDTO);
                userpermissionEntityList.add(userpermissionEntity);
            }
        }
        return userpermissionEntityList;
    }

    @Override
    protected UserPermissionEntity transferToEntity(UserPermissionDTO userpermissionDTO) {
        UserPermissionEntity userpermissionEntity = new UserPermissionEntity();
        BeanUtils.copyProperties(userpermissionDTO,userpermissionEntity);
        userpermissionDTO = null;
        return userpermissionEntity;
    }
}
