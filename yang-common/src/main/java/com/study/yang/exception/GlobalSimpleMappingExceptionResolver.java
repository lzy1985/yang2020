package com.study.yang.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/6 下午2:23
 * @Description
 */
@Slf4j
public class GlobalSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {


    /**
     * 异常处理
     */
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response, Object handler, Exception e) {
        //错误日记记录
        log.error("全局异常信息：", e);

        if(isAjaxRequest(request)) {
            //ajax请求
            writeJSON(response, "系统繁忙,请稍后重试!");
            return null;
        } else {
            //非ajax请求
            return getModelAndView("404", e, request);
        }
    }

    /**
     * 判断请求是否ajax请求
     * @param request
     * @return
     */
    private boolean isAjaxRequest(HttpServletRequest request) {
        if (null != request.getHeader("x-requested-with") && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * 向响应中写入数据
     * @param response
     * @param data
     */
    private void writeJSON(HttpServletResponse response, String data) {
        try {
            // 设置响应头
            response.setContentType("application/json"); // 指定内容类型为 JSON 格式
            response.setCharacterEncoding("UTF-8"); // 防止中文乱码
            // 向响应中写入数据
            PrintWriter writer = response.getWriter();
//            writer.write(jsonUtils.serialize(ResponseDto.bulidFail(data)));
            writer.flush();
            writer.close();
        } catch (Exception e) {
            log.error("在响应中写数据出错！", e);
        }
    }
}
