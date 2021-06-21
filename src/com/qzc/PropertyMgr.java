package com.qzc;

import java.io.IOException;
import java.util.Properties;

/**
 * @author qzc
 * @create 2021-06-01 22:23
 */
public class PropertyMgr {
	static Properties props=new Properties();
	private PropertyMgr(){

	}
	static {
		try {
			props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object get(String key){
		if (props == null) return null;
		return props.get(key);
	}

	public static void main(String[] args) {
		System.out.println(PropertyMgr.get("initTankCount"));
	}
}
