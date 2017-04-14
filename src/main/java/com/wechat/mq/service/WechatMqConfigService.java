package com.wechat.mq.service;

import com.wechat.mq.entity.WechatMqConfig;

/**
 * Created by akinoneko on 2017/4/14.
 */
public interface WechatMqConfigService {

    WechatMqConfig getCurrentWechatMqConfig(Integer configId);
}
