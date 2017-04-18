package com.wechat.mp.service;

import com.wechat.mp.entity.WechatMqConfig;

/**
 * Created by akinoneko on 2017/4/14.
 */
public interface WechatMqConfigService {

    WechatMqConfig getCurrentWechatMqConfig(Integer configId);
}
