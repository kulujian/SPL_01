package com.kulu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kulu.domain.SystemUser;
import com.kulu.mapper.SystemUserMapper;
import com.kulu.service.SystemUserService;

@Service
public class SystemUserServiceImpl implements SystemUserService{

	@Autowired
	private SystemUserMapper systemUserMapper;

	@Override
	public SystemUser login(SystemUser user) {
		SystemUser loginUser = systemUserMapper.login(user);
		return loginUser;
	}
}
