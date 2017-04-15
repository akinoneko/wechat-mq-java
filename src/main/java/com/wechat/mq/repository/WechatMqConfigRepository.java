package com.wechat.mq.repository;

import com.wechat.mq.entity.WechatMqConfig;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by akinoneko on 2017/4/14.
 */
@SuppressWarnings("ALL")
@CacheConfig(cacheNames = "wechat_mq_config")
public interface WechatMqConfigRepository extends CrudRepository<WechatMqConfig,Integer> {

    @CachePut(key = "#p0.id")
    WechatMqConfig save(WechatMqConfig wechatMqConfig);

    @Cacheable(key = "#p0")
    WechatMqConfig findOne(Integer id);
}
