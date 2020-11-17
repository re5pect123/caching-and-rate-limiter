package com.example.caching.config;

import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
@EnableCaching
public class ApiConfig extends CachingConfigurerSupport {

    /*@Bean
    public ApiFilter apiFilter() {
        return new ApiFilter();
    }*/

    @Bean
    public net.sf.ehcache.CacheManager ehCacheManager() {
        CacheConfiguration tenSecondsCache = new CacheConfiguration();
        tenSecondsCache.setName("ten-second-cache");
        tenSecondsCache.setMaxEntriesLocalHeap(1000);
        tenSecondsCache.setMemoryStoreEvictionPolicy("LRU");
        tenSecondsCache.setTimeToLiveSeconds(10);

        CacheConfiguration twentySecondsCache = new CacheConfiguration();
        twentySecondsCache.setName("twenty-second-cache");
        twentySecondsCache.setMaxEntriesLocalHeap(1000);
        twentySecondsCache.setMemoryStoreEvictionPolicy("LRU");
        twentySecondsCache.setTimeToLiveSeconds(20);

        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(tenSecondsCache);
        config.addCache(twentySecondsCache);

        return net.sf.ehcache.CacheManager.newInstance(config);
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }

}
