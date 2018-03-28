package com.elead.spring.dao;

import com.elead.spring.annotation.UdaComponent;

@UdaComponent("userDao")
public class UserInfoDao {
	public void addUser() {
		System.out.println("添加用户成功。");
	}

	public String getUser() {
		System.out.println("获取用户名称成功。");
		return "张三";
	}
}
