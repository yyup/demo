package com.test.base;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.test.base.utils.SSOUtils;

public class MongoDbControllerTest {

	//mongodb存数据
		@Test
		public void testAddUser() {
			String url = "http://localhost:8082/base/addUser.do";
			Map<String, String> map = new HashMap<String, String>();
//			map.put("memberName", "zhangsan");
			map.put("memberName", "lisi");
			map.put("sex", "2");
			String ret = SSOUtils.remoteStringService(map, url);
			System.out.println(ret);
		}
		//获取数据
		@Test
		public void testGetUser() {
			String url = "http://localhost:8082/base/getUser.do";
			Map<String, String> map = new HashMap<String, String>();
			String ret = SSOUtils.remoteStringService(map, url);
			System.out.println(ret);
		}
}
