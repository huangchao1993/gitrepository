package com.elead.spring.controller;

import com.elead.spring.annotation.UdaAutowired;
import com.elead.spring.annotation.UdaController;
import com.elead.spring.annotation.UdaRequestMapping;
import com.elead.spring.mvc.ModelView;
import com.elead.spring.service.UserInfoService;

@UdaController
@UdaRequestMapping("/mvc")
public class MvcController {

	@UdaAutowired
	private UserInfoService userInfoService;

	@UdaRequestMapping("/index")
	public ModelView index() {
		ModelView mv = new ModelView("index");
		String msg = "自定义mvc成功。";
		mv.addData("msg", msg);
		return mv;
	}

	@UdaRequestMapping("/show")
	public ModelView index(String name, Integer age) {
		ModelView mv = new ModelView("show");
		String showInfo = userInfoService.getShowInfo(name, age);
		mv.addData("showInfo", showInfo);
		return mv;
	}
	
	@UdaRequestMapping("/home")
	public String home() {
		return "home";
	}
}
