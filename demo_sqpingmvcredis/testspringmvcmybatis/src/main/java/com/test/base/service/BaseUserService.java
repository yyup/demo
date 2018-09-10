package com.test.base.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.base.dao.BaseUserDao;
import com.test.base.model.BaseUser;

@Service
public class BaseUserService {
	@Resource
	private BaseUserDao baseUserDao;

	public BaseUser selectUserById(Integer id) {
		return baseUserDao.selectUserById(id);   
	}

}
