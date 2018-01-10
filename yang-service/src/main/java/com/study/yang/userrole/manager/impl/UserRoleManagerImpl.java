package com.study.yang.userrole.manager.impl;

import com.google.common.collect.Lists;
import com.study.yang.base.manager.impl.BaseManagerImpl;
import com.study.yang.userrole.dao.IUserRoleDAO;
import com.study.yang.userrole.dto.UserRoleDTO;
import com.study.yang.userrole.entity.UserRoleEntity;
import com.study.yang.userrole.manager.IUserRoleManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户角色中间表 ManagerImpl
 * @author lzy
 * @version 1.0.0
 * @since 2017/10/16 17:11
 */
@Slf4j
@Component
public class UserRoleManagerImpl extends BaseManagerImpl<IUserRoleDAO, UserRoleEntity, UserRoleDTO> implements IUserRoleManager {

    @Override
    protected List<UserRoleDTO> transferToDTOList(List<UserRoleEntity> userroleEntityList) {
        List<UserRoleDTO> userroleDTOList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(userroleEntityList)) {
            for (UserRoleEntity userroleEntity : userroleEntityList) {
                UserRoleDTO userroleDTO = transferToDTO(userroleEntity);
                userroleDTOList.add(userroleDTO);
            }
        }
        return userroleDTOList;
    }

    @Override
    protected UserRoleDTO transferToDTO(UserRoleEntity userroleEntity) {
        UserRoleDTO userroleDTO = new UserRoleDTO();
        BeanUtils.copyProperties(userroleEntity,userroleDTO);
        userroleEntity = null;
        return userroleDTO;
    }

    @Override
    protected List<UserRoleEntity> transferToEntityList(List<UserRoleDTO> userroleDTOList) {
        List<UserRoleEntity> userroleEntityList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(userroleDTOList)) {
            for (UserRoleDTO userroleDTO : userroleDTOList) {
                UserRoleEntity userroleEntity = transferToEntity(userroleDTO);
                userroleEntityList.add(userroleEntity);
            }
        }
        return userroleEntityList;
    }

    @Override
    protected UserRoleEntity transferToEntity(UserRoleDTO userroleDTO) {
        UserRoleEntity userroleEntity = new UserRoleEntity();
        BeanUtils.copyProperties(userroleDTO,userroleEntity);
        userroleDTO = null;
        return userroleEntity;
    }
}
