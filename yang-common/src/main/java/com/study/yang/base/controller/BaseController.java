package com.study.yang.base.controller;

import com.study.yang.base.dto.PageInfo;
import com.study.yang.base.dto.ResponseDto;
import com.study.yang.base.service.IBaseService;
import com.study.yang.base.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/5 下午10:39
 * @Description
 */
public class BaseController<S extends IBaseService<T>, T> {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @Autowired
    protected S service;

    /**
     * 缓存service
     */
    @Autowired
    protected RedisUtil redisUtil;

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        /**
         * 自动转换日期类型的字段格式
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }


    /**
     * 查询数据list
     * @param dto
     */
    protected ResponseDto query(T dto) {
        List<T> items = service.query(dto);
        return ResponseDto.bulidSuccess(items);
    }

    /**
     * 分页查询
     * @param dto
     * @param pageNum
     * @param pageSize
     */
    protected ResponseDto queryByPage(T dto, Integer pageNum, Integer pageSize) {
        PageInfo items = service.queryByPage(dto, pageNum, pageSize);
        return ResponseDto.bulidSuccess(items);
    }

    /**
     * 保存
     * @param dto
     */
    protected ResponseDto save(T dto) {
        Integer result = service.save(dto);
        if(result > 0){
            return ResponseDto.bulidSuccess("添加成功");
        }else{
            return ResponseDto.bulidFail("添加失败");
        }
    }

    /**
     * 根据id查询数据详情
     * @param id
     */
    protected ResponseDto detail(Integer id) {
        T entity = service.getById(id);
        return ResponseDto.bulidSuccess(entity);
    }

    /**
     * 修改数据
     * @param dto
     */
    protected ResponseDto update(T dto) {
        int result = service.modify(dto);
        if(result > 0){
            return ResponseDto.bulidSuccess("修改成功");
        }else{
            return ResponseDto.bulidFail("修改失败");
        }
    }

    /**
     * 根据id删除数据
     * @param id
     */
    protected ResponseDto delete(Integer id) {
        int result = service.remove(id);
        if(result > 0){
            return ResponseDto.bulidSuccess("删除成功");
        }else{
            return ResponseDto.bulidFail("删除失败");
        }
    }

    protected final String responseRedirect(String url) {
        return "redirect:" + url;
    }
}
