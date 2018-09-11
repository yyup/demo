package com.test.base.controller;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.test.base.model.UserDTO;

@Controller
public class MongoDbController {
	@Autowired
	private MongoTemplate mongoTemplate;
	
//	@Before
//    public void testBefore() {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc-servlet.xml");
//        mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
//    }

	/**
	 * mongoDb中插入数据
	 * @return
	 */
	@RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
	public String testAddUser(String memberName, String sex) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		UserDTO	user = new UserDTO();
		user.setMemberName(memberName);
		user.setMemberSex(sex);
		user.setDateCreated(format.format(new Date()));
        // 插入数据
        mongoTemplate.insert(user);
        
        return "home";
	}
	
	/**
	 * 查询数据
	 * @return
	 */
	@RequestMapping(value = "/getUser.do", method = RequestMethod.POST)
	public String testGetUser() {
		Query query = new Query();
		
        Criteria criatira= new Criteria();
        criatira.andOperator(Criteria.where("memberSex").is("1"));
        query.addCriteria(criatira);
        List<UserDTO> userList1 = mongoTemplate.find(query, UserDTO.class);
        System.out.println(userList1);
        return "home";
	}

}
