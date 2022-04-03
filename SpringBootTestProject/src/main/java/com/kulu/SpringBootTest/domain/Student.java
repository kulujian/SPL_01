package com.kulu.SpringBootTest.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


//@Data
//@AllArgsConstructor // lombok 全替參建構子
//@NoArgsConstructor  // lombok 代替空參建構子
@Component  // 宣告接受Spring管制
@ConfigurationProperties(prefix = "student") // 將yml映射至實體類 (prefix = "配置前綴")
public class Student {
	// 注意，成員變數一定提供set/get方法(此類使用lombok建構)
	private String listName;
	private Integer age;
	private Boolean boss;
	
	private Date birthday;
	private Map<String, String> maps;
	private Map<String, String> maps2;
	private List<Dog> lists;
	
	private Dog dog;
	private String[] arr;
	private String[] arr2;
	
	private Map<String, Dog> dogMap;

	
	
	public Student() {
//		super();
	}

	public Student(String listName, Integer age, Boolean boss, Date birthday, Map<String, String> maps,
			Map<String, String> maps2, List<Dog> lists, Dog dog, String[] arr, String[] arr2, Map<String, Dog> dogMap) {
//		super();
		this.listName = listName;
		this.age = age;
		this.boss = boss;
		this.birthday = birthday;
		this.maps = maps;
		this.maps2 = maps2;
		this.lists = lists;
		this.dog = dog;
		this.arr = arr;
		this.arr2 = arr2;
		this.dogMap = dogMap;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getBoss() {
		return boss;
	}

	public void setBoss(Boolean boss) {
		this.boss = boss;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Map<String, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}

	public Map<String, String> getMaps2() {
		return maps2;
	}

	public void setMaps2(Map<String, String> maps2) {
		this.maps2 = maps2;
	}

	public List<Dog> getLists() {
		return lists;
	}

	public void setLists(List<Dog> lists) {
		this.lists = lists;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public String[] getArr() {
		return arr;
	}

	public void setArr(String[] arr) {
		this.arr = arr;
	}

	public String[] getArr2() {
		return arr2;
	}

	public void setArr2(String[] arr2) {
		this.arr2 = arr2;
	}

	public Map<String, Dog> getDogMap() {
		return dogMap;
	}

	public void setDogMap(Map<String, Dog> dogMap) {
		this.dogMap = dogMap;
	}

	@Override
	public String toString() {
		return "Student [listName=" + listName + ", age=" + age + ", boss=" + boss + ", birthday=" + birthday
				+ ", maps=" + maps + ", maps2=" + maps2 + ", lists=" + lists + ", dog=" + dog + ", arr="
				+ Arrays.toString(arr) + ", arr2=" + Arrays.toString(arr2) + ", dogMap=" + dogMap + "]";
	}
	
	
	
	
	

}
