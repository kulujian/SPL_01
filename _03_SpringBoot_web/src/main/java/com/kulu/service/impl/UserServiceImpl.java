package com.kulu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kulu.aop.InvokeLog;
import com.kulu.domain.User;
import com.kulu.mapper.UserMapper;
import com.kulu.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	@InvokeLog	// 需要被切入或增加的方法需要加上對應的注解
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userMapper.findAll();
	}

	/*
	 * 	這邊在測試 事務事件 rollback
	 * 	經過添過加 聲明式事務，會自動將異常數據回滾
	 */
	@Override
	@Transactional  // 在方式上增加了聲明式事務註解，方法內對資料庫的操作只會全部成功，或是全部失敗
	public void insertUser() {
		// TODO Auto-generated method stub
		// 添加兩個用戶到數據庫
		User user = new User(null, "kulu777", 40, "桃園");
		User user1 = new User(null, "kulu666", 30, "新北");
		userMapper.insertUser(user);
		System.out.println(1/0);
		userMapper.insertUser(user1);
		
	}

}
