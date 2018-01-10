package com.study.yang.permission.manager.impl;

import com.google.common.collect.Lists;
import com.study.yang.base.manager.impl.BaseManagerImpl;
import com.study.yang.permission.dao.IPermissionDAO;
import com.study.yang.permission.dto.PermissionDTO;
import com.study.yang.permission.entity.PermissionEntity;
import com.study.yang.permission.manager.IPermissionManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 权限表 ManagerImpl
 * @author lzy
 * @version 1.0.0
 * @since 2017/10/16 17:11
 */
@Slf4j
@Component
public class PermissionManagerImpl extends BaseManagerImpl<IPermissionDAO, PermissionEntity, PermissionDTO> implements IPermissionManager {

    @Override
    protected List<PermissionDTO> transferToDTOList(List<PermissionEntity> permissionEntityList) {
        List<PermissionDTO> permissionDTOList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(permissionEntityList)) {
            for (PermissionEntity permissionEntity : permissionEntityList) {
                PermissionDTO permissionDTO = transferToDTO(permissionEntity);
                permissionDTOList.add(permissionDTO);
            }
        }
        return permissionDTOList;
    }

    @Override
    protected PermissionDTO transferToDTO(PermissionEntity permissionEntity) {
        PermissionDTO permissionDTO = new PermissionDTO();
        BeanUtils.copyProperties(permissionEntity,permissionDTO);
        permissionEntity = null;
        return permissionDTO;
    }

    @Override
    protected List<PermissionEntity> transferToEntityList(List<PermissionDTO> permissionDTOList) {
        List<PermissionEntity> permissionEntityList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(permissionDTOList)) {
            for (PermissionDTO permissionDTO : permissionDTOList) {
                PermissionEntity permissionEntity = transferToEntity(permissionDTO);
                permissionEntityList.add(permissionEntity);
            }
        }
        return permissionEntityList;
    }

    @Override
    protected PermissionEntity transferToEntity(PermissionDTO permissionDTO) {
        PermissionEntity permissionEntity = new PermissionEntity();
        BeanUtils.copyProperties(permissionDTO,permissionEntity);
        permissionDTO = null;
        return permissionEntity;
    }
}
