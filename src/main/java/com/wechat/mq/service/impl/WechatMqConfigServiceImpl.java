package com.wechat.mq.service.impl;

import com.wechat.mq.entity.WechatMqConfig;
import com.wechat.mq.repository.WechatMqConfigRepository;
import com.wechat.mq.service.WechatMqConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by akinoneko on 2017/4/14.
 */
public class WechatMqConfigServiceImpl implements WechatMqConfigService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatMqConfigServiceImpl.class);

    @Autowired
    private WechatMqConfigRepository wechatMqConfigRepository;

    @Override
    public WechatMqConfig getCurrentWechatMqConfig(Integer configId) {
        return wechatMqConfigRepository.findOne(configId);
    }
}
