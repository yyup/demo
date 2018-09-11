package com.test.base.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;


public class PropertiesUtils {
	
	private static final Logger LOGGER = Logger.getLogger(PropertiesUtils.class);
	
	/**
	 * 加载资源文件
	 * @param propName
	 * @return
	 * @throws IOException
	 */
	public static Properties loadProperties(String propName) throws IOException {
		if (TextUtils.notEmpty(propName)) {
			InputStream inStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(propName);
			Properties prop = new Properties();
			prop.load(inStream);
			inStream.close();
			return prop;
		}
		return null;
	}
	/**
	 * 加载值
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public static String getPropertyByFileName(String key, String fileName) throws IOException {
		 Properties prop = loadProperties(fileName);
		 String value = prop.getProperty(key.trim());
	        if(StringUtils.isEmpty(value)){
	        	 return null;
	        }
	        return value.trim();
   }
	/**
	 * 加载值(默认值)
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getProperty(String key,String defaultValue) throws IOException {
		 Properties prop = loadProperties("config.properties");
		 String value = prop.getProperty(key.trim());
	        if(StringUtils.isEmpty(value)){
	        	 value = defaultValue;
	        }
	        return value.trim();
    }
	
	/**
	 * Config配置
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, String> mapConfigAll(String proper) {
		try {
			Properties prop = loadProperties(proper);
			if (prop != null) {
				Map<String, String> map = new HashMap<String, String>();
				Enumeration e = prop.keys() ;
			    while(e.hasMoreElements()) {
			    	String name = (String)(e.nextElement()) ;
			    	map.put(name, prop.getProperty(name)) ;
			    }
			    return map;
			}
		} catch (IOException e) {
			LOGGER.error("PropertiesUtil mapConfigAll IOException " + e);
		}
		return null;
	}

}
