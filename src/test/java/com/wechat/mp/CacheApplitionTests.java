package com.wechat.mp;

import com.wechat.common.service.CacheService;
import com.wechat.mp.entity.User;
import com.wechat.mp.repository.UserRepository;
import com.wechat.mp.repository.UserTokenRepository;
import com.wechat.mp.repository.WechatMqConfigRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by akinoneko on 2017/3/20.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@EnableCaching
public class CacheApplitionTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WechatMqConfigRepository wechatMqConfigRepository;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private UserTokenRepository userTokenRepository;

    @Test
    @Transactional
    public void test() {
        User user = userRepository.findByUser("akinoneko");
        for (Object o : user.getWechatMqConfigs()) {
            System.out.println(o.toString());
        }
//        UserToken userToken = new UserToken();
//        userToken.setCreateTime(new Date());
//        userToken.setExpire(new Date());
//        userToken.setIp("127.0.0.1");
//        userToken.setToken(MD5Utils.encode(user.getUser()));
//        userToken.setUserName(user.getUser());
//        userToken.setUpdateTime(new Date());
//        userToken.setUser(user);
//        userTokenRepository.save(userToken);
    }
}
