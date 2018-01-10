package ${conf.basePackage}.${table.lowerCamelName}.service.impl;

import ${conf.basePackage}.base.service.impl.BaseServiceImpl;
import ${conf.basePackage}.${table.lowerCamelName}.dto.${table.className}DTO;
import ${conf.basePackage}.${table.lowerCamelName}.manager.I${table.className}Manager;
import ${conf.basePackage}.${table.lowerCamelName}.service.I${table.className}Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * ${table.comment} ServiceImpl
 * @author ${conf.author}
 * @version ${conf.version}
 * @since ${conf.createDate}
 */
@Slf4j
@Service
public class ${table.className}ServiceImpl extends BaseServiceImpl<I${table.className}Manager, ${table.className}DTO> implements I${table.className}Service {

}
