package com.study.yang.base.service.impl;

import com.study.yang.base.dto.PageInfo;
import com.study.yang.base.manager.IBaseManager;
import com.study.yang.base.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/6 上午9:44
 * @Description
 */
public class BaseServiceImpl<M extends IBaseManager<T>, T> implements IBaseService<T> {

    @Autowired
    protected M manager;

    public List<T> query(T dto) {
        return manager.query(dto);
    }

    public T getById(Integer id) {
        return manager.getById(id);
    }

    public List<T> findByIds(List<Integer> ids) {
        return manager.findByIds(ids);
    }

    public PageInfo queryByPage(T dto, Integer pageNum, Integer pageSize) {
        return manager.queryByPage(dto, pageNum, pageSize);
    }

    public Integer save(T dto) {
        return manager.save(dto);
    }

    public Integer saveSelective(T dto) {
        return manager.saveSelective(dto);
    }

    public Integer saveBatch(List<T> dtoList) {
        return manager.saveBatch(dtoList);
    }

    public Integer modify(T dto) {
        return manager.modify(dto);
    }

    public Integer modifySelective(T dto) {
        return manager.modifySelective(dto);
    }

    public Integer remove(Integer id) {
        return manager.remove(id);
    }

    public Integer removeBatch(List<Integer> ids) {
        return manager.removeBatch(ids);
    }

    public Integer removeByParams(T dto) {
        return manager.removeByParams(dto);
    }
}
