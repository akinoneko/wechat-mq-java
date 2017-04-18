package com.wechat.mp.repository;

import com.wechat.mp.entity.UserToken;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by akinoneko on 2017/4/18.
 */
public interface UserTokenRepository extends CrudRepository<UserToken,Integer> {

    @Query("select u from UserToken u where u.token=:token")
    UserToken findbyToken(@Param("token") String token);

}
