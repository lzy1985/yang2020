package com.study.yang.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/29 上午6:22
 * @Description
 */
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ControllerLog {
    String description() default "";
}
