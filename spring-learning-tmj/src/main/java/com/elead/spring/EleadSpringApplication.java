package com.elead.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.elead.spring.controller.UserInfoController;
import com.elead.spring.core.UdaSpringContext;

@SpringBootApplication
public class EleadSpringApplication {
	public static void main(String[] args) {
		// Spring容器例子
		ConfigurableApplicationContext springContext = SpringApplication.run(EleadSpringApplication.class, args);
		/*SpringBeanExample bean = springContext.getBean(SpringBeanExample.class);
		System.out.println(Arrays.toString(springContext.getBeanDefinitionNames()));
		System.out.println(bean.getHello());*/
		// 自定义容器例子
		UdaSpringContext context = new UdaSpringContext();
		try {
			System.out.println("开始初始化容器");
			long t = System.currentTimeMillis();
			context.initContext("com.elead.spring");
			System.out.println("初始化容器成功，cost time:" + (System.currentTimeMillis() - t));
			UserInfoController controller = context.getBean(UserInfoController.class);
			controller.addUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
