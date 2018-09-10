package com.jiangfx.service;

import com.jiangfx.entity.User;

import java.util.List;

/**
 * Created by jiangfeixiang on 2018/4/27
 */
public interface UserService {
    /**
     * 查询
     * @return
     */
    List<User> getAll();

    /**
     * 插入
     */
    void insertUser(User user);
}
