package com.wechat.mp.controller;

import com.wechat.common.annotation.ControllerLog;
import com.wechat.common.utils.StringUtils;
import com.wechat.mp.entity.User;
import com.wechat.mp.exception.RestException;
import com.wechat.mp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akinoneko on 2017/4/15.
 */
@RestController
@RequestMapping(value = "/system/api")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ControllerLog
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Object login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new RestException(RestException.SC_BAD_REQUEST, "用户名/密码不能为空");
        }
        User user = userService.login(username, password);
        Map<String, Object> body = new HashMap<>();
        body.put("user", user.getUser());
        body.put("last_login_ip", user.getLastLoginIp());
        body.put("last_login_time", user.getLastLoginTime().getTime() / 1000L);
        body.put("email", user.getEmail());
        body.put("mobile", user.getMobile());
        body.put("create_time", user.getCreateTime().getTime() / 1000L);
        body.put("update_time", user.getUpdateTime().getTime() / 1000L);
        body.put("user_id", user.getId());
        return body;
    }
}
