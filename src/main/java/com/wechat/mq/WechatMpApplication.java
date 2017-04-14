package com.wechat.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author Binary Wang
 */
@SpringBootApplication
@EnableCaching
           public class WechatMpApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatMpApplication.class, args);
    }
}
