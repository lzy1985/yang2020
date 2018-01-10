package com.study.yang.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/29 上午6:27
 * @Description
 */
@Target(ElementType.FIELD)
public @interface ServiceLog {
    String description() default "";
}
