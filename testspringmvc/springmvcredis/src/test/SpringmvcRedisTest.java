import com.jiangfx.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangfeixiang on 2018/4/26
 */
public class SpringmvcRedisTest {
    private static ApplicationContext applicationContext;

    static{
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);
    @Test
    public void testApplicationContext(){
        System.out.println("11111111111111111"+applicationContext);
    }
    @Test
    public void testRedisConnection(){
       /* RedisTemplate redisTemplate = (RedisTemplate)applicationContext.getBean("redisTemplate");*/
       // redisTemplate.renameIfAbsent("k1", "k2");//如果key=abc存在，则将key修改为bbb
        Jedis jedis = new Jedis("192.168.0.20", 6379);
        int i = 0;
        long start = System.currentTimeMillis();
        while (true){
            long end = System.currentTimeMillis();
            if (end-start>=1000){
                break;
            }
            i++;
            jedis.set("test"+i,i+"");
        }
        jedis.close();
        System.out.println("redis每秒操作："+i+"次");
    }

    /**
     * 测试
     */
    @Test
    public void testRole(){
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        redisTemplate.opsForValue().set("user",user);
        User user1 = (User) redisTemplate.opsForValue().get("user");
        System.out.println(user1);
    }

    /**
     * SessionCallback
     */
    @Test
    public void testUser(){
        final User user = new User();
        user.setId(1);
        user.setUsername("张三");
        SessionCallback callback = new SessionCallback<User>() {
            @Override
            public User execute(RedisOperations redisOperations) throws DataAccessException {
               redisOperations.boundValueOps("user").set(user);
                return (User) redisOperations.boundValueOps("user").get();
            }
        };
        User user1 = (User) redisTemplate.execute(callback);
        System.out.println(user1);
    }

    @Test
    public void testString(){
        //设置值
        redisTemplate.opsForValue().set("key3","c");
        redisTemplate.opsForValue().set("key4",4);
        //取值
        Object key3 = redisTemplate.opsForValue().get("key3");
        System.out.println(key3);
        Object key4 = redisTemplate.opsForValue().get("key4");
        System.out.println(key4);
        //求长度
        Long key31 = redisTemplate.opsForValue().size("key3");
        System.out.println(key31);

        //设置新值，返回旧值
        Object andSet = redisTemplate.opsForValue().getAndSet("key3", "key5");
        System.out.println(andSet);

        //求子串
        String key32 = redisTemplate.opsForValue().get("key3", 0, 3);
        System.out.println(key32);
    }

    @Test
    public void testHash(){
        String key = "hash";
        Map<String,String> map = new HashMap<>();
        map.put("f1","a");
        map.put("f2","b");
        //相当于hmset
        redisTemplate.opsForHash().putAll(key,map);
        //相当于hset
        redisTemplate.opsForHash().put(key,"f3","c");
        //相当于hexists key filed
        Boolean f3 = redisTemplate.opsForHash().hasKey(key, "f3");
        System.out.println(f3);
    }
}
