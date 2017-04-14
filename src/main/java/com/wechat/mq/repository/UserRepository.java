package com.wechat.mq.repository;

import com.wechat.mq.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by akinoneko on 2017/4/14.
 */
@SuppressWarnings("ALL")
@CacheConfig(cacheNames = "users")
public interface UserRepository extends CrudRepository<User, Integer> {

    @Cacheable(key = "#p0") //对查询的结果缓存到redis中
    @Query("select u from User u where u.user=:user")
    User findByUser(@Param("user") String user);

    @CachePut(key = "#p0.user") //缓存到redis
    User save(User user);
}
