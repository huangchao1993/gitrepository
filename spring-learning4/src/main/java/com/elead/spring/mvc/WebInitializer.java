package com.elead.spring.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

import com.elead.spring.core.UdaSpringContext;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		UdaSpringContext context = new UdaSpringContext();
		try {
			context.initContext("com.elead.spring");
			context.setServletContext(servletContext);
			System.out.println("自定义spring容器初始化成功。");
		} catch (Exception e) {
			System.out.println("自定义spring容器初始化失败。");
			e.printStackTrace();
		}
	}

}
