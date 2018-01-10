package com.study.yang.base.dao;

import com.study.yang.base.dao.entity.BaseEntity;

import java.util.List;
import java.util.Map;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/6 上午9:25
 * @Description
 */
public interface IBaseDAO<E extends BaseEntity> {

    /**
     * 插入
     */
    Integer insert(E entity);

    /**
     * 选择插入
     */
    Integer insertSelective(E entity);

    /**
     * 批量插入
     */
    Integer insertBatch(List<E> entityList);

    /**
     * 按主键ID更新
     */
    Integer updateByPrimaryKey(E entity);

    /**
     * 按主键ID选择更新
     */
    Integer updateByPrimaryKeySelective(E entity);

    /**
     * 通过id查询对象
     */
    E selectEntityById(Integer id);

    /**
     * 按map参数查询
     */
    List<E> selectByParams(Map<String, Object> params);

    /**
     * 按对象参数查询
     */
    List<E> selectByEntity(E entity);

    /**
     * 按参数批量删除
     */
    Integer deleteByParams(Map<String, Object> params);
    /**
     * 按id删除数据
     */
    Integer deleteById(Integer id);
}
