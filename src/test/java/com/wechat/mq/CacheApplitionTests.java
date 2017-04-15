package com.wechat.mq;

import com.wechat.common.service.CacheService;
import com.wechat.mq.repository.UserRepository;
import com.wechat.mq.repository.WechatMqConfigRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Test
    public void test() {
//        cacheService.setKeyValue("123","12321321",120);
//        System.err.println(cacheService.getString("123"));
//        User user = new User();
//        user.setUser("zyy");
//        user.setUpdateTime(new Date());
//        user.setPassword(MD5Utils.encode("123"));
//        user.setSalt("123");
//        user.setMobile("123123");
//        user.setLastLoginTime(new Date());
//        user.setLastLoginIp("123123");
//        user.setCreateTime(new Date());
//        user.setEmail("qwe@sad.com");
//        user.setName("123123123");
//        WechatMqConfig wechatMqConfig = new WechatMqConfig();
//        wechatMqConfig.setCreateTime(new Date());
//        wechatMqConfig.setUpdateTime(new Date());
//        wechatMqConfig.setUser(user);
//        wechatMqConfigRepository.save(wechatMqConfig);
    }
}
