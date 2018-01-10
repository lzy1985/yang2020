package com.study.yang.base.aspect;

import com.study.yang.base.monitor.LogUtil;
import com.study.yang.base.util.AspectUtil;
import com.study.yang.base.util.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/29 上午6:31
 * @Description
 */
@Slf4j
@Aspect
@Component
public class LogControllerAdvice {

    @Around(value = "execution(* com.study.yang.*.controller..*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = null;
        if(!"initBinder".equals(joinPoint.getSignature().getName())) {
            MDC.put(LogUtil.TRACE_ID, LogUtil.traceID());
            log.info("-----通知开始-----");
            log.info("请求方法    :【" + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "】");
            StringBuilder params = new StringBuilder();
            if (null != joinPoint.getArgs() && joinPoint.getArgs().length > 0) {
                for (int i = 0; i < joinPoint.getArgs().length; i++) {
                    //判断如果为文件，只打印文件的名字
                    if( joinPoint.getArgs()[i] instanceof CommonsMultipartFile){
                        CommonsMultipartFile commonsMultipartFile =(CommonsMultipartFile)joinPoint.getArgs()[i];
                        FileItem fileItem = commonsMultipartFile.getFileItem();
                        params.append("文件:").append(fileItem.getName());
                    }else{
                        if(params.length()>0){
                            params.append(",");
                        }
                        params.append(JSONUtils.toJson(joinPoint.getArgs()[i]));
                    }

                }
            }
            log.info("请求参数    :【" + params.toString() + "】");
            log.info("请求方法描述 :【" + AspectUtil.getDescriptionMethod(joinPoint) + "】");
            obj = joinPoint.proceed(joinPoint.getArgs());
            try {
                MDC.put(LogUtil.TRACE_ID, LogUtil.traceID());
            } catch (Exception e) {
                //记录本地异常日志
                log.info("----通知异常-----");
                log.error("通知异常信息:{}", e.getMessage());
            } finally {
                log.info("-----通知结束-----");
                MDC.remove(LogUtil.TRACE_ID);
            }
        }
        return obj;
    }


}
