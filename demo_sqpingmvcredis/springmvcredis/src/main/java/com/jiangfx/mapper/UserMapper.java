package com.jiangfx.mapper;

import com.jiangfx.entity.User;

import java.util.List;

/**
 * Created by jiangfeixiang on 2018/4/27
 */
public interface UserMapper {
    /**
     * 查询
     * @return
     */
    List<User> getAll();

    /**
     * 插入
     * @param user
     */
    void insertUser(User user);
}
