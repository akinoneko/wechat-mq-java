package com.wechat.mq.repository;

import com.wechat.mq.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by akinoneko on 2017/4/14.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select u from User u where u.user=:user")
    User getByUser(@Param("user") String user);
}
