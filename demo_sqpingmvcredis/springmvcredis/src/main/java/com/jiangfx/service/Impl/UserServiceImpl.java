package com.jiangfx.service.Impl;

import com.jiangfx.entity.User;
import com.jiangfx.mapper.UserMapper;
import com.jiangfx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jiangfeixiang on 2018/4/27
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    //注入userMapper
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有
     * 使用@Cacheable地很诡异缓存策略，
     * 当缓存中有值，则返回缓存数据，否则则访问数据库
     * value引用缓存管理器，key定义缓存的键
     * @return
     */
    @Override
    @Cacheable(value = "redisCacheManager",key = "'getAll'")
    public List<User> getAll() {
        List<User> userMapperAll = userMapper.getAll();
        System.out.println("没有走缓存就打印我...........");
        return userMapperAll;
    }

    /**
     * 添加用户
     */
    @Override
    @CachePut(value = "redisCacheManager",key = "'insertUser'")
    public void insertUser(User user){
        userMapper.insertUser(user);
    }
}
