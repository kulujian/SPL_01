package com.kulu.SpringBootTest;

import java.util.List;

//import org.junit.Test; // 2.2.0 after, 對應的是JUnit4版本。(升級後如果有依賴Vintage就可以兼容)
//import org.junit.runner.RunWith; // 2.2.0 after, 需搭配@RunWith使用(升級後如果有依賴Vintae就可以兼容)
import org.junit.jupiter.api.Test; // 2.2.0 before
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kulu.SpringBootTest.controller.HelloController;
import com.kulu.SpringBootTest.domain.User;
import com.kulu.SpringBootTest.mapper.UserMapper;

/*
 * SpringBoot舊版本升級後，會出現之前單元的測試代碼出現問題。
 * 情境：spring-boot-starter-parent 2.1.5.RELEASE版本，升級2.6.4版本
 * 1. 2.2.0版本之前使用JUnit4
 * 2. 2.4.0版本之後對應的Spring-boot-starter-test移除了默認對JUnit Vintage的依賴(JUnit Vintage用來兼容JUnit3和JUnit4)
 * 3. 我們可以單獨再依賴JUnit Vintage來進行兼容
 * 
 * 	<dependency>
 * 		<groupId>org.junit.vintage</gropuId>
 * 		<artifactId>junit-vintage-engine</artifactId>
 * 		<scope>test</scope>
 *  </dependency>
 */

/* 預設指定啟動類路徑為【測試類】於test所在的路徑位置，相對於main路徑位置
 * 指定啟動類：添加 classes = 啟動類檔名.class
 */
@SpringBootTest//(classes = SpringBootTestProjectApplication.class)
//@RunWith(SpringRunner.class) // JUnit4 after 需要加上這個註解，才能到SpringBoot容器中，獲取對應的Bean進行注入
public class ApplicationTest {

	@Autowired
	private HelloController helloController;
	
	@Autowired
	private UserMapper userMapper;
	
//	@Test
	@Test
	public void testJunit() {
		System.out.println(1);
		System.out.println(helloController);
	}
	
	@Test
	public void testMapper() {
		List<User> users = userMapper.findAll();
		System.out.println(users);
	}
}
