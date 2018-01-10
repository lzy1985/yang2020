package com.study.yang.base.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.transaction.AbstractTransactionSupportingCacheManager;

import java.util.Collection;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/11 上午10:31
 * @Description
 */
public class GlobalCacheManager extends AbstractTransactionSupportingCacheManager {
    public GlobalCacheManager() {
    }

    private Collection<? extends Cache> caches;

    /**
     * Specify the collection of Cache instances to use for this CacheManager.
     */
    public void setCaches(Collection<? extends Cache> caches) {
        this.caches = caches;
    }

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return this.caches;
    }
}
