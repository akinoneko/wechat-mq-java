package com.wechat.common.service.impl;

import com.wechat.common.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

/**
 * Created by akinoneko on 2017/4/15.
 */
@Service
public class RedisCacheService implements CacheService {

    @Autowired
    private JedisPool jedisPool;


    /**
     * 使用Redis缓存KV
     *
     * @param key
     * @param value
     * @param timeOutSeconds 存活时间,timeOutSeconds<=0时,设置为不过期
     */
    @Override
    public void setMap(String key, Map<String, String> value, int timeOutSeconds) {
        Jedis jedis = jedisPool.getResource();
        if (null != jedis) {
            try {
                jedis.hmset(key, value);
                if (timeOutSeconds > 0) {
                    jedis.expire(key, timeOutSeconds);
                }
            } catch (Exception e) {
                throw e;
            } finally {
                jedis.close();
            }
        }
    }

    /**
     * 根据Key获取Redis中的value
     *
     * @param key
     * @return
     */
    @Override
    public Map<String, String> getMap(String key) {
        Jedis jedis = jedisPool.getResource();
        if (null != jedis) {
            try {
                return jedis.hgetAll(key);
            } catch (Exception e) {
                throw e;
            } finally {
                jedis.close();
            }
        }
        return null;
    }

    @Override
    public void deleteElement(String key) {
        Jedis jedis = jedisPool.getResource();
        if (null != jedis) {
            try {
                jedis.del(key);
            } catch (Exception e) {
                throw e;
            } finally {
                jedis.close();
            }
        }
    }

    /**
     * 使用Redis缓存KV
     *
     * @param key
     * @param value
     * @param seconds 存活时间,seconds<=0时,设置为不过期
     */
    @Override
    public void setKeyValue(String key, String value, int seconds) {
        Jedis jedis = jedisPool.getResource();
        if (null != jedis) {
            try {
                jedis.set(key, value);
                if (seconds > 0) {
                    jedis.expire(key, seconds);
                }
            } catch (Exception e) {
                throw e;
            } finally {
                jedis.close();
            }
        }
    }

    /**
     * 根据Key获取Redis中的value
     *
     * @param key
     * @return
     */
    @Override
    public String getString(String key) {
        Jedis jedis = jedisPool.getResource();
        if (null != jedis) {
            try {
                return jedis.get(key);
            } catch (Exception e) {
                throw e;
            } finally {
                jedis.close();
            }
        }
        return null;
    }
}
