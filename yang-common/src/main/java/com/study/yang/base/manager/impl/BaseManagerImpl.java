package com.study.yang.base.manager.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.study.yang.base.dao.IBaseDAO;
import com.study.yang.base.dao.entity.BaseEntity;
import com.study.yang.base.dto.PageInfo;
import com.study.yang.base.manager.IBaseManager;
import com.study.yang.base.util.MapUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/6 上午9:48
 * @Description
 */
public abstract class BaseManagerImpl<D extends IBaseDAO<E>, E extends BaseEntity, T> implements IBaseManager<T> {

    @Autowired
    protected D dao;

    public List<T> query(T dto) {
        List<E> entityList = dao.selectByParams(MapUtil.beanToMap(dto));
        if (entityList == null) {
            return null;
        }
        return transferToDTOList(entityList);
    }

    public T getById(Integer id) {
        E entity = dao.selectEntityById(id);
        if (entity == null) {
            return null;
        }
        return transferToDTO(entity);
    }

    public List<T> findByIds(List<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            ids = Lists.newArrayList(0);
        }

        Map<String, Object> params = Maps.newHashMap();
        params.put("ids", ids);

        List<E> entityList = dao.selectByParams(params);
        return transferToDTOList(entityList);
    }

    public PageInfo queryByPage(T dto, Integer pageNum, Integer pageSize) {
        if(null == pageNum){
            pageNum = 1;
        }
        if(null == pageSize){
            pageSize = 15;
        }
        Page<E> pagelist = PageHelper.startPage(pageNum,pageSize);
        List<E> entityList = dao.selectByEntity(transferToEntity(dto));
        if (entityList == null) {
            return null;
        }
        List<T> list =  transferToDTOList(entityList);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setCurrentPage(pageNum);
        pageInfo.setPerPageRows(pageSize);
        pageInfo.setTotalRows(pagelist.getTotal());
        pageInfo.setPageList(list);
        return pageInfo;
    }

    public Integer save(T dto) {
        E entity = transferToEntity(dto);
        Integer result = dao.insert(entity);
        return result;
    }

    public Integer saveSelective(T dto) {
        E entity = transferToEntity(dto);
        Integer result = dao.insertSelective(entity);
        return result;
    }

    public Integer saveBatch(List<T> dtoList) {
        List<E> entityList = transferToEntityList(dtoList);
        if (CollectionUtils.isNotEmpty(entityList)) {
            Integer result = dao.insertBatch(entityList);
            return result;
        }
        return 0;
    }

    public Integer modify(T dto) {
        E entity = transferToEntity(dto);
        return dao.updateByPrimaryKey(entity);
    }

    public Integer modifySelective(T dto) {
        E entity = transferToEntity(dto);
        return dao.updateByPrimaryKeySelective(entity);
    }

    public Integer remove(Integer id) {

        return dao.deleteById(id);
    }

    public Integer removeByParams(T dto) {
        return dao.deleteByParams(MapUtil.beanToMap(dto));
    }

    public Integer removeBatch(List<Integer> ids) {
        Map<String, Object> params = Maps.newHashMap();
        params.put("ids", ids);

        int result =  dao.deleteByParams(params);
        return result;
    }

    /**
     * Entity对象转换为DTO对象
     * @param entity
     * @return
     */
    protected abstract T transferToDTO(E entity);

    /**
     * DTO对象转换为Entity对象
     * @param dto
     * @return
     */
    protected abstract E transferToEntity(T dto);

    protected abstract List<T> transferToDTOList(List<E> entityList);

    protected abstract List<E> transferToEntityList(List<T> dtoList);
}
