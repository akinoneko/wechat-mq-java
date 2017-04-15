package com.wechat.common.service;

import java.util.Map;

/**
 * Created by akinoneko on 2017/4/15.
 */
public interface CacheService {

    void setMap(String key, Map<String, String> value, int timeOutSeconds);

    Map<String, String> getMap(String key);

    void deleteElement(String key);

    void setKeyValue(String key, String value, int seconds);

    String getString(String key);
}
