package com.elead.spring.mvc;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.elead.spring.annotation.UdaComponent;
import com.elead.spring.core.UdaSpringContext;

@UdaComponent
public class UdaHandlerMapping {

	public UdaHandlerExecutionChain getHandler(HttpServletRequest request) {
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		String actualUrl = url.replace(contextPath, "").replace(".do", "");
		ServletContext context = request.getServletContext();
		UdaSpringContext udaContext = (UdaSpringContext) context.getAttribute(UdaSpringContext.class.getName());
		UdaHandlerExecutionChain handlerChain = udaContext.getHandlerChain(actualUrl);
		return handlerChain;
	}
}
