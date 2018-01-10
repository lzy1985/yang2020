package com.study.yang.shiro.cache;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.cache.CacheException;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/11 上午10:22
 * @Description
 */
@Slf4j
public class ShiroSpringCache<K, V> implements org.apache.shiro.cache.Cache<K, V> {

    private final org.springframework.cache.Cache cache;

    public ShiroSpringCache(Cache cache) {
        if (cache == null) {
            throw new IllegalArgumentException("Cache argument cannot be null.");
        }
        this.cache = cache;
    }

    @Override
    public V get(K key) throws CacheException {
        if (log.isTraceEnabled()) {
            log.trace("Getting object from cache [" + this.cache.getName() + "] for key [" + key + "]key type:" + key.getClass());
        }
        ValueWrapper valueWrapper = cache.get(key);
        if (valueWrapper == null) {
            if (log.isTraceEnabled()) {
                log.trace("Element for [" + key + "] is null.");
            }
            return null;
        }
        return (V) valueWrapper.get();
    }

    @Override
    public V put(K key, V value) throws CacheException {
        if (log.isTraceEnabled()) {
            log.trace("Putting object in cache [" + this.cache.getName() + "] for key [" + key + "]key type:" + key.getClass());
        }
        V previous = get(key);
        cache.put(key, value);
        return previous;
    }

    @Override
    public V remove(K key) throws CacheException {
        if (log.isTraceEnabled()) {
            log.trace("Removing object from cache [" + this.cache.getName() + "] for key [" + key + "]key type:" + key.getClass());
        }
        V previous = get(key);
        cache.evict(key);
        return previous;
    }

    @Override
    public void clear() throws CacheException {
        if (log.isTraceEnabled()) {
            log.trace("Clearing all objects from cache [" + this.cache.getName() + "]");
        }
        cache.clear();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return Collections.emptySet();
    }

    @Override
    public Collection<V> values() {
        return Collections.emptySet();
    }

    @Override
    public String toString() {
        return "ShiroSpringCache [" + this.cache.getName() + "]";
    }
}
