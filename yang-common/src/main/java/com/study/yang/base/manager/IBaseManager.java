package com.study.yang.base.manager;

import com.study.yang.base.dto.PageInfo;

import java.util.List;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/6 上午9:40
 * @Description
 */
public interface IBaseManager<T> {

    /**
     * 查询
     */
    List<T> query(T dto);

    /**
     * ID查询
     */
    T getById(Integer id);

    /**
     * ID批量查询
     */
    List<T> findByIds(List<Integer> ids);

    /**
     * 参数分页查询
     */
    PageInfo queryByPage(T dto, Integer pageNum, Integer pageSize);

    /**
     * 保存
     */
    Integer save(T dto);

    /**
     * 选择保存
     */
    Integer saveSelective(T dto);

    /**
     * 批量保存
     */
    Integer saveBatch(List<T> dtoList);

    /**
     * 修改
     */
    Integer modify(T dto);

    /**
     * 选择修改
     */
    Integer modifySelective(T dto);

    /**
     * 删除
     */
    Integer remove(Integer id);

    /**
     * 参数删除
     */
    Integer removeByParams(T dto);

    /**
     * 批量删除
     */
    Integer removeBatch(List<Integer> ids);
}
