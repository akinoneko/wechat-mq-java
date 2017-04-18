package com.wechat.mp.service.impl;

import com.wechat.common.annotation.ServiceLog;
import com.wechat.common.utils.MD5Utils;
import com.wechat.mp.entity.User;
import com.wechat.mp.exception.RestException;
import com.wechat.mp.repository.UserRepository;
import com.wechat.mp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by akinoneko on 2017/4/15.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @ServiceLog
    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUser(username);
        if (null == user) {
            throw new RestException(RestException.SC_NOT_FOUND, "用户不存在");
        }
        if (Objects.equals(MD5Utils.encode(user.getSalt() + password.toUpperCase()),
                user.getPassword())) {
            return user;
        } else {
            throw new RestException(RestException.SC_UNAUTHORIZED, "用户名/密码错误");
        }
    }
}
