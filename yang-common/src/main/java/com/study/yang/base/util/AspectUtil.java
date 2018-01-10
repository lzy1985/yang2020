package com.study.yang.base.util;

import com.study.yang.base.annotation.ControllerLog;
import com.study.yang.base.annotation.ServiceLog;
import org.aspectj.lang.JoinPoint;

import java.lang.reflect.Method;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/30 上午6:04
 * @Description
 */
public class AspectUtil {

    /**
     * 根据传入的类找到当前连接点方法的描述
     *
     * @param joinPoint
     * @return
     */
    public static String getDescriptionMethod(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    if (null != method.getAnnotation(ControllerLog.class)) {
                        description = method.getAnnotation(ControllerLog.class).description();
                    } else if (null != method.getAnnotation(ServiceLog.class)) {
                        description = method.getAnnotation(ServiceLog.class).description();
                    }
                    break;
                }
            }
        }
        return description;
    }
}
