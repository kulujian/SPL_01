package com.kulu.domain;

import java.util.Arrays;

public class User {

	private Integer id;
	private String name;
	private Integer age;
	private String[] likes;
	
	public User() {
//		super();
	}

	public User(Integer id, String name, Integer age, String[] likes) {
//		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.likes = likes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String[] getLikes() {
		return likes;
	}

	public void setLikes(String[] likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", likes=" + Arrays.toString(likes) + "]";
	}

	
}
