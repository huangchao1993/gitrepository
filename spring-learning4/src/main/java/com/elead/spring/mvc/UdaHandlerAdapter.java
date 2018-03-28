package com.elead.spring.mvc;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

public class UdaHandlerAdapter {

	private UdaHandlerExecutionChain chain;

	public UdaHandlerAdapter(UdaHandlerExecutionChain chain) {
		this.chain = chain;
	}

	/**
	 * 执行业务方法
	 * 
	 * @param request
	 * @return
	 */
	public ModelView postHandle(HttpServletRequest request) {
		try {
			Object handler = chain.getHandler();
			Method method = chain.getMethod();
			Parameter[] parameters = method.getParameters();
			int length = parameters.length;
			Object args[] = new Object[length];
			for (int i = 0; i < length; i++) {
				parameters[i].isNamePresent();
				String name = parameters[i].getName();
				Class<?> type = parameters[i].getType();
				String value = request.getParameter(name);
				if (value == null) {
					continue;
				}
				if (type == Integer.class) {
					args[i] = Integer.parseInt(value);
				} else if (type == Double.class) {
					args[i] = Double.valueOf(value);
				} else {
					args[i] = value;
				}
			}
			Object result = method.invoke(handler, args);
			ModelView mv = new ModelView("404");
			if (result instanceof ModelView) {
				mv = (ModelView) result;
			} else if (result instanceof String) {
				mv = new ModelView(result.toString());
			}
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
