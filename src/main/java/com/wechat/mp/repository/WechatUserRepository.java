package com.wechat.mp.repository;

import com.wechat.mp.entity.WechatUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by akinoneko on 2017/4/18.
 */
public interface WechatUserRepository extends CrudRepository<WechatUser, Integer> {

    @Query("select w from WechatUser w where w.openId=:openId")
    WechatUser findByOpenId(@Param("openId") String openId);

}
