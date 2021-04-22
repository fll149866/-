package com.nysb.demo01.utils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.Cache;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class BaseCache {

    private Cache<String, Object> tenMinuteCache = CacheBuilder.newBuilder()
            //设置缓存初识大小，应该合理设置，后续扩容
        .initialCapacity(10)
            //最大值
        .maximumSize(100)
            //并发数设置
        .concurrencyLevel(5)
            //缓存过期时间，写入后10分钟过期
        .expireAfterWrite(600, TimeUnit.SECONDS)
            //统计缓存命中率
        .recordStats()
        .build();

    public Cache<String, Object> getTenMinuteCache() {
        return tenMinuteCache;
    }

    public void setTenMinuteCache(Cache<String, Object> tenMinuteCache) {
        this.tenMinuteCache = tenMinuteCache;
    }
}
