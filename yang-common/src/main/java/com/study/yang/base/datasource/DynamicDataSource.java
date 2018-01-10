package com.study.yang.base.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/6 上午11:52
 * @Description
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 获取数据源
     */
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.getDB();
    }
}
