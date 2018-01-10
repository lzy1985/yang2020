package ${conf.basePackage}.${table.lowerCamelName}.manager.impl;

import com.google.common.collect.Lists;
import ${conf.basePackage}.base.manager.impl.BaseManagerImpl;
import ${conf.basePackage}.${table.lowerCamelName}.dao.I${table.className}DAO;
import ${conf.basePackage}.${table.lowerCamelName}.dto.${table.className}DTO;
import ${conf.basePackage}.${table.lowerCamelName}.entity.${table.className}Entity;
import ${conf.basePackage}.${table.lowerCamelName}.manager.I${table.className}Manager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ${table.comment} ManagerImpl
 * @author ${conf.author}
 * @version ${conf.version}
 * @since ${conf.createDate}
 */
@Slf4j
@Component
public class ${table.className}ManagerImpl extends BaseManagerImpl<I${table.className}DAO, ${table.className}Entity, ${table.className}DTO> implements I${table.className}Manager {

    @Override
    protected List<${table.className}DTO> transferToDTOList(List<${table.className}Entity> ${table.lowerCamelName}EntityList) {
        List<${table.className}DTO> ${table.lowerCamelName}DTOList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(${table.lowerCamelName}EntityList)) {
            for (${table.className}Entity ${table.lowerCamelName}Entity : ${table.lowerCamelName}EntityList) {
                ${table.className}DTO ${table.lowerCamelName}DTO = transferToDTO(${table.lowerCamelName}Entity);
                ${table.lowerCamelName}DTOList.add(${table.lowerCamelName}DTO);
            }
        }
        return ${table.lowerCamelName}DTOList;
    }

    @Override
    protected ${table.className}DTO transferToDTO(${table.className}Entity ${table.lowerCamelName}Entity) {
        ${table.className}DTO ${table.lowerCamelName}DTO = new ${table.className}DTO();
        BeanUtils.copyProperties(${table.lowerCamelName}Entity,${table.lowerCamelName}DTO);
        ${table.lowerCamelName}Entity = null;
        return ${table.lowerCamelName}DTO;
    }

    @Override
    protected List<${table.className}Entity> transferToEntityList(List<${table.className}DTO> ${table.lowerCamelName}DTOList) {
        List<${table.className}Entity> ${table.lowerCamelName}EntityList = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(${table.lowerCamelName}DTOList)) {
            for (${table.className}DTO ${table.lowerCamelName}DTO : ${table.lowerCamelName}DTOList) {
                ${table.className}Entity ${table.lowerCamelName}Entity = transferToEntity(${table.lowerCamelName}DTO);
                ${table.lowerCamelName}EntityList.add(${table.lowerCamelName}Entity);
            }
        }
        return ${table.lowerCamelName}EntityList;
    }

    @Override
    protected ${table.className}Entity transferToEntity(${table.className}DTO ${table.lowerCamelName}DTO) {
        ${table.className}Entity ${table.lowerCamelName}Entity = new ${table.className}Entity();
        BeanUtils.copyProperties(${table.lowerCamelName}DTO,${table.lowerCamelName}Entity);
        ${table.lowerCamelName}DTO = null;
        return ${table.lowerCamelName}Entity;
    }
}
