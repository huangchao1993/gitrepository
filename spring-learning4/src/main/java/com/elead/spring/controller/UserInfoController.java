package com.elead.spring.controller;

import com.elead.spring.annotation.UdaAutowired;
import com.elead.spring.annotation.UdaComponent;
import com.elead.spring.service.UserInfoService;

@UdaComponent
public class UserInfoController {

	@UdaAutowired
	private UserInfoService userInfoService;

	public void addUser() {
		userInfoService.addUser();
	}
}
