package com.study.yang.user.manager.impl;

import com.google.common.collect.Lists;
import com.study.yang.base.manager.impl.BaseManagerImpl;
import com.study.yang.user.dao.IUserDAO;
import com.study.yang.user.dto.UserDTO;
import com.study.yang.user.entity.UserEntity;
import com.study.yang.user.manager.IUserManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户表 ManagerImpl
 * @author lzy
 * @version 1.0.0
 * @since 2017/10/16 17:11
 */
@Slf4j
@Component
public class UserManagerImpl extends BaseManagerImpl<IUserDAO, UserEntity, UserDTO> implements IUserManager {

    @Override
    protected List<UserDTO> transferToDTOList(List<UserEntity> userEntityList) {
        List<UserDTO> userDTOList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(userEntityList)) {
            for (UserEntity userEntity : userEntityList) {
                UserDTO userDTO = transferToDTO(userEntity);
                userDTOList.add(userDTO);
            }
        }
        return userDTOList;
    }

    @Override
    protected UserDTO transferToDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userEntity,userDTO);
        userEntity = null;
        return userDTO;
    }

    @Override
    protected List<UserEntity> transferToEntityList(List<UserDTO> userDTOList) {
        List<UserEntity> userEntityList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(userDTOList)) {
            for (UserDTO userDTO : userDTOList) {
                UserEntity userEntity = transferToEntity(userDTO);
                userEntityList.add(userEntity);
            }
        }
        return userEntityList;
    }

    @Override
    protected UserEntity transferToEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO,userEntity);
        userDTO = null;
        return userEntity;
    }
}
