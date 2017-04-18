package com.wechat.mp.service.impl;

import com.wechat.common.annotation.ServiceLog;
import com.wechat.mp.entity.WechatMqConfig;
import com.wechat.mp.repository.WechatMqConfigRepository;
import com.wechat.mp.service.WechatMqConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by akinoneko on 2017/4/14.
 */
@Service
public class WechatMqConfigServiceImpl implements WechatMqConfigService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatMqConfigServiceImpl.class);

    @Autowired
    private WechatMqConfigRepository wechatMqConfigRepository;

    @Override
    @ServiceLog
    public WechatMqConfig getCurrentWechatMqConfig(Integer configId) {
        return wechatMqConfigRepository.findOne(configId);
    }
}
