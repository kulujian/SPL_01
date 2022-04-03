package com.kulu.SpringBootTest.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kulu.SpringBootTest.domain.Student;
/*
 *  測試讀取 application.yml 配置值
 *  注意：加了@Value的類，必須是交由Spring容器管理的
 */
@RestController
public class TestController {

	@Value("${name}")
	private String name;
	@Value("${date}")
	private Date date;
	@Value("${student.age}")
	private Integer age;
	
	@Autowired
	private Student student;
	
	@RequestMapping("/test01")
	public String test01() {
		System.out.println(name);
		System.out.println(date);
		System.out.println(age);
		return name;
	}
	
	@RequestMapping(path = "/test02")
	public Student test02() {
		System.out.println(student.getMaps().size());
		System.out.println(student.getMaps2().size());
		System.out.println(student.getLists().size());
		return student;
	}
}
