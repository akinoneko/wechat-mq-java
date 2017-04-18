package com.wechat.mp.context;

import com.wechat.mp.entity.User;

/**
 * Created by akinoneko on 2017/4/15.
 * 用户上下文
 */
public class UserContext implements AutoCloseable {

    static final ThreadLocal<User> current = new ThreadLocal<>();

    public UserContext(User user) {
        current.set(user);
    }

    public static User getCurrentUser() {
        return current.get();
    }

    public void close() {
        current.remove();
    }
}
