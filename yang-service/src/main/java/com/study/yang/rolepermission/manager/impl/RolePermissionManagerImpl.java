package com.study.yang.rolepermission.manager.impl;

import com.google.common.collect.Lists;
import com.study.yang.base.manager.impl.BaseManagerImpl;
import com.study.yang.rolepermission.dao.IRolePermissionDAO;
import com.study.yang.rolepermission.dto.RolePermissionDTO;
import com.study.yang.rolepermission.entity.RolePermissionEntity;
import com.study.yang.rolepermission.manager.IRolePermissionManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 角色权限表 ManagerImpl
 * @author lzy
 * @version 1.0.0
 * @since 2017/10/16 17:11
 */
@Slf4j
@Component
public class RolePermissionManagerImpl extends BaseManagerImpl<IRolePermissionDAO, RolePermissionEntity, RolePermissionDTO> implements IRolePermissionManager {

    @Override
    protected List<RolePermissionDTO> transferToDTOList(List<RolePermissionEntity> rolepermissionEntityList) {
        List<RolePermissionDTO> rolepermissionDTOList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(rolepermissionEntityList)) {
            for (RolePermissionEntity rolepermissionEntity : rolepermissionEntityList) {
                RolePermissionDTO rolepermissionDTO = transferToDTO(rolepermissionEntity);
                rolepermissionDTOList.add(rolepermissionDTO);
            }
        }
        return rolepermissionDTOList;
    }

    @Override
    protected RolePermissionDTO transferToDTO(RolePermissionEntity rolepermissionEntity) {
        RolePermissionDTO rolepermissionDTO = new RolePermissionDTO();
        BeanUtils.copyProperties(rolepermissionEntity,rolepermissionDTO);
        rolepermissionEntity = null;
        return rolepermissionDTO;
    }

    @Override
    protected List<RolePermissionEntity> transferToEntityList(List<RolePermissionDTO> rolepermissionDTOList) {
        List<RolePermissionEntity> rolepermissionEntityList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(rolepermissionDTOList)) {
            for (RolePermissionDTO rolepermissionDTO : rolepermissionDTOList) {
                RolePermissionEntity rolepermissionEntity = transferToEntity(rolepermissionDTO);
                rolepermissionEntityList.add(rolepermissionEntity);
            }
        }
        return rolepermissionEntityList;
    }

    @Override
    protected RolePermissionEntity transferToEntity(RolePermissionDTO rolepermissionDTO) {
        RolePermissionEntity rolepermissionEntity = new RolePermissionEntity();
        BeanUtils.copyProperties(rolepermissionDTO,rolepermissionEntity);
        rolepermissionDTO = null;
        return rolepermissionEntity;
    }
}
