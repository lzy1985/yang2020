package com.study.yang.base.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/10/17 上午11:24
 * @Description
 */
public class SpringHolder implements ApplicationContextAware {

    public static ApplicationContext context;

    public void setApplicationContext(ApplicationContext appcontext)
            throws BeansException {
        SpringHolder.context = appcontext;
    }

    /**
     * 通过制定的名称获得Bean对象
     *
     * @param name
     */
    public synchronized static Object getBean(String name) {
        if (context == null) {
            initApplicationContext();
        }
        return context.getBean(name);
    }

    /**
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     *
     * @param name
     * @return boolean
     */
    public static boolean containsBean(String name) {
        return context.containsBean(name);
    }

    /**
     * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
     *
     * @param name
     * @return boolean
     * @throws NoSuchBeanDefinitionException
     */
    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return context.isSingleton(name);
    }

    /**
     * @param name
     * @return Class 注册对象的类型
     * @throws NoSuchBeanDefinitionException
     */
    public static Class getType(String name) throws NoSuchBeanDefinitionException {
        return context.getType(name);
    }

    /**
     * 如果给定的bean名字在bean定义中有别名，则返回这些别名
     *
     * @param name
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return context.getAliases(name);
    }

    /**
     * 手动初始化spring方法
     */
    public static void initApplicationContext() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext(
                    "classpath:spring/applicationContext-*.xml");
        }
    }
}
