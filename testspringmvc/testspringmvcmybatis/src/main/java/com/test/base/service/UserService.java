package com.test.base.service;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.base.dao.UserDTOMapper;
import com.test.base.model.UserDTO;

@Service
public class UserService {
	@Resource
	private UserDTOMapper userDao;

	@Cacheable(value = "redisCacheManager", key="'hxuuid'")
	public UserDTO getUserByMobileOrAdmin(String hxuuid) {
		UserDTO user = userDao.selectByPrimaryKey(hxuuid);
		System.out.println("没有走缓存");
		return user;
	}
	
	@Cacheable(value = "redisCacheManager", key="'getName'")
	public String getUserNmByMobileOrAdmin(String hxuuid) {
		String name = userDao.selectNameByPrimaryKey(hxuuid);
		System.out.println("查数据库");
		return name;
	}

}
