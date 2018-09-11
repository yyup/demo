package com.test.base.util.redis;

import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.test.base.util.PropertiesUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
	private static final Logger LOGGER = Logger.getLogger(PropertiesUtils.class);
	
	private static JedisPool pool;//jedis连接池

	protected static final Map<String, String> configMap = PropertiesUtils.mapConfigAll("config.properties");
	private static Integer maxTotal = Integer.parseInt(configMap.get("redis.max.total")); //最大连接数
    private static Integer maxIdle = Integer.parseInt(configMap.get("redis.max.idle"));//在jedispool中最大的idle状态(空闲的)的jedis实例的个数
    private static Integer minIdle = Integer.parseInt(configMap.get("redis.min.idle"));//在jedispool中最小的idle状态(空闲的)的jedis实例的个数

    private static Boolean testOnBorrow = Boolean.parseBoolean(configMap.get("redis.test.borrow"));//在borrow一个jedis实例的时候，是否要进行验证操作，如果赋值true。则得到的jedis实例肯定是可以用的。
    private static Boolean testOnReturn = Boolean.parseBoolean(configMap.get("redis.test.return"));//在return一个jedis实例的时候，是否要进行验证操作，如果赋值true。则放回jedispool的jedis实例肯定是可以用的。

    private static String redisIp = configMap.get("redis.ip");
    private static Integer redisPort = Integer.parseInt(configMap.get("redis.port"));
    private static String redisAuth = configMap.get("redis.AUTH");


    private static void initPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);

        config.setTestOnBorrow(testOnBorrow);
        config.setTestOnReturn(testOnReturn);

        config.setBlockWhenExhausted(true);//连接耗尽的时候，是否阻塞，false会抛出异常，true阻塞直到超时。默认为true。

        pool = new JedisPool(config,redisIp,redisPort,1000*2,redisAuth);
    }

    static{
        initPool();
    }

    public static Jedis getJedis(){
        return pool.getResource();
    }


    public static void close(Jedis jedis){
        try {
            if (jedis != null) {
                jedis.close();
            }
        } catch (Exception e) {
        	LOGGER.error("return redis resource exception", e);
        }
    }


    public static void main(String[] args) {
        Jedis jedis = pool.getResource();
        String a = jedis.get("lzh");
        close(jedis);

        pool.destroy();//临时调用，销毁连接池中的所有连接
        System.out.println("program is end");
        System.out.println("a="+a);


    }

}
