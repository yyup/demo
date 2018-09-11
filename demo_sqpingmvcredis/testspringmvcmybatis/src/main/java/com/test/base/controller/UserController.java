package com.test.base.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.base.model.UserDTO;
import com.test.base.service.UserService;

import redis.clients.jedis.Jedis;

@Controller
public class UserController{
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/dologon.do", method=RequestMethod.GET)
	@ResponseBody
	public String dologon(HttpSession session, String usrNo, String usrPwd) {
		UserDTO userDTO = userService.getUserByMobileOrAdmin("dc853ca7-7b4c-11e8-b543-000ec6a85e96");
		System.out.println(userDTO.getMemberMobile());
		return "list";
	}
	
	@RequestMapping(value="/test.do", method=RequestMethod.GET)
	@ResponseBody
	public String test(HttpSession session) {
		String name = userService.getUserNmByMobileOrAdmin("dc853ca7-7b4c-11e8-b543-000ec6a85e96");
		System.out.println(name);
		return "list";
	}
	
	
	public static void main(String[] args) {
		//redis缓存测试
		Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        jedis.set("城市", "南京");
        // 查看服务是否运行
        //System.out.println("服务正在运行: " + jedis.ping());
	}
}
