package com.test.base.controller;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.base.model.UserDTO;

@Controller
public class MongoDbTest {
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
	@RequestMapping(value = "/addUser.do", method = RequestMethod.GET)
	public String testAddUser() {
		UserDTO	user = new UserDTO();
		user.setMemberName("zhangsan");
		user.setMemberSex("1");

        // 插入数据
        mongoTemplate.insert(user);
        
        return "home";
	}
	
	@RequestMapping(value = "/getUser.do", method = RequestMethod.GET)
	public String testGetUser() {
		Query query = new Query();
		
        Criteria criteria = where("sex").gt(0);    // 大于

        query.addCriteria(criteria);
        List<UserDTO> userList1 = mongoTemplate.find(query, UserDTO.class);
        System.out.println(userList1);

        
        return "home";
	}

}
