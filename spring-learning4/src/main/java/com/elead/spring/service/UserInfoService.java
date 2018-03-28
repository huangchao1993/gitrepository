package com.elead.spring.service;

import com.elead.spring.annotation.UdaAutowired;
import com.elead.spring.annotation.UdaComponent;
import com.elead.spring.dao.UserInfoDao;

@UdaComponent
public class UserInfoService {
	@UdaAutowired
	private UserInfoDao userInfoDao;

	public void addUser() {
		userInfoDao.addUser();
	}

	public String getUser() {
		return userInfoDao.getUser();
	}

	public String getShowInfo(String name, Integer age) {
		return String.format("我叫%s, 今年%s岁。", name, age);
	}
}
