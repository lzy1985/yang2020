package com.study.yang.role.manager.impl;

import com.google.common.collect.Lists;
import com.study.yang.base.manager.impl.BaseManagerImpl;
import com.study.yang.role.dao.IRoleDAO;
import com.study.yang.role.dto.RoleDTO;
import com.study.yang.role.entity.RoleEntity;
import com.study.yang.role.manager.IRoleManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  ManagerImpl
 * @author lzy
 * @version 1.0.0
 * @since 2017/10/16 17:11
 */
@Slf4j
@Component
public class RoleManagerImpl extends BaseManagerImpl<IRoleDAO, RoleEntity, RoleDTO> implements IRoleManager {

    @Override
    protected List<RoleDTO> transferToDTOList(List<RoleEntity> roleEntityList) {
        List<RoleDTO> roleDTOList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(roleEntityList)) {
            for (RoleEntity roleEntity : roleEntityList) {
                RoleDTO roleDTO = transferToDTO(roleEntity);
                roleDTOList.add(roleDTO);
            }
        }
        return roleDTOList;
    }

    @Override
    protected RoleDTO transferToDTO(RoleEntity roleEntity) {
        RoleDTO roleDTO = new RoleDTO();
        BeanUtils.copyProperties(roleEntity,roleDTO);
        roleEntity = null;
        return roleDTO;
    }

    @Override
    protected List<RoleEntity> transferToEntityList(List<RoleDTO> roleDTOList) {
        List<RoleEntity> roleEntityList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(roleDTOList)) {
            for (RoleDTO roleDTO : roleDTOList) {
                RoleEntity roleEntity = transferToEntity(roleDTO);
                roleEntityList.add(roleEntity);
            }
        }
        return roleEntityList;
    }

    @Override
    protected RoleEntity transferToEntity(RoleDTO roleDTO) {
        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(roleDTO,roleEntity);
        roleDTO = null;
        return roleEntity;
    }
}
