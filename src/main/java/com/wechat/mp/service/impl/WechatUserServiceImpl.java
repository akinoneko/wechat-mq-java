package com.wechat.mp.service.impl;

import com.wechat.common.annotation.ServiceLog;
import com.wechat.mp.entity.WechatUser;
import com.wechat.mp.repository.WechatUserRepository;
import com.wechat.mp.service.WechatUserService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by akinoneko on 2017/4/18.
 */
@Service
public class WechatUserServiceImpl implements WechatUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WechatUserServiceImpl.class);

    @Autowired
    private WechatUserRepository wechatUserRepository;

    @ServiceLog
    @Override
    public void uploadLocation(double latitude, double longitude, String label,
                               WxMpUser user, String mpId) {
        WechatUser wechatUser = wechatUserRepository.findByOpenId(user.getOpenId());
        if (null == wechatUser) {
            wechatUser = new WechatUser();
            wechatUser.setCity(user.getCity());
            wechatUser.setProvince(user.getProvince());
            wechatUser.setCountry(user.getCountry());
            wechatUser.setCreateTime(new Date());
            wechatUser.setUpdateTime(new Date());
            wechatUser.setLastActiveTime(new Date());
            wechatUser.setLanguage(user.getLanguage());
            wechatUser.setHeadImageUrl(user.getHeadImgUrl());
            wechatUser.setWechatMpId(mpId);
            wechatUser.setSex(user.getSex());
            wechatUser.setNickname(user.getNickname());
            wechatUser.setOpenId(user.getOpenId());
        }
        wechatUser.setLabel(label == null ? wechatUser.getLabel() : label);
        wechatUser.setLatitude(latitude);
        wechatUser.setLongitude(longitude);
        wechatUserRepository.save(wechatUser);
    }
}
