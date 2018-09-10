package com.test.base.service;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.test.base.dao.UserDTOMapper;
import com.test.base.model.UserDTO;

@Service
public class UserService {
	@Resource
	private UserDTOMapper userDao;

	@Cacheable(value = "redisCacheManager", key="'hxuuid'")
	public UserDTO getUserByMobileOrAdmin(String hxuuid) {
		UserDTO user = userDao.selectByPrimaryKey(hxuuid);;
		return user;
	}

}
