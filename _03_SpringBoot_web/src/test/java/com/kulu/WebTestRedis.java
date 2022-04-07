package com.kulu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/*
 * 	整合 Redis
 */


@SpringBootTest		// 宣告為測試類並納入SpringBoot管理
public class WebTestRedis {

	@Autowired // 注入SpringBoot容器
	private StringRedisTemplate redisTemplate;
	
	@Test
	public void testRedis() {
		// 存入值
		System.out.println(1);
		redisTemplate.opsForValue().set("name", "佑佑");
		System.out.println(2);
	}
	
	@Test
	public void testRedisGetValue() {
		System.out.println(3);
		String name = redisTemplate.opsForValue().get("name");
		System.out.println("【 "+name+" 】");
		System.out.println(4);
	}
}
