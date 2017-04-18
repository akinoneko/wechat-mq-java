package com.wechat.mp.service;

import com.wechat.mp.entity.User;

/**
 * Created by akinoneko on 2017/4/15.
 */
public interface UserService {

    User login(String username,String password);

}
