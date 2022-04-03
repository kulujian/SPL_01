package com.kulu.service;

import java.util.List;

import com.kulu.domain.User;

public interface UserService {

	List<User> findAll();

	void insertUser();
}
