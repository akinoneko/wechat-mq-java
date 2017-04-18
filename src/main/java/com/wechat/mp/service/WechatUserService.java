package com.wechat.mp.service;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * Created by akinoneko on 2017/4/18.
 */
public interface WechatUserService {

    void uploadLocation(double latitude, double longitude, String label,
                        WxMpUser user, String mpId);
}
