package springmvcredis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class SpringmvcRedisTest {

	private static ApplicationContext applicationContext;

    static{
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testApplicationContext(){
        System.out.println("11111111111111111"+applicationContext);
    }
    @Test
    public void testRedisConnection(){
        RedisTemplate redisTemplate = (RedisTemplate)applicationContext.getBean("redisTemplate");
        redisTemplate.renameIfAbsent("k2", "k1");//如果key=k2存在，则将key修改为k1。前提是你的redis中得有k2。不然报错。这不你也可以不写。
        System.out.println(redisTemplate); //这里有输出也可以。
    }
}
