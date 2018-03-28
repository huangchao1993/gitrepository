package com.elead.spring.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elead.spring.core.UdaSpringContext;
import com.elead.spring.mvc.ModelView;
import com.elead.spring.mvc.UdaHandlerAdapter;
import com.elead.spring.mvc.UdaHandlerExecutionChain;
import com.elead.spring.mvc.UdaHandlerMapping;
import com.elead.spring.mvc.UdaViewResolver;

@WebServlet(name = "dispatcherServlet", urlPatterns = "*.do")
public class UdaDispatcherServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext = req.getServletContext();
		// 取出spring容器
		UdaSpringContext context = (UdaSpringContext) servletContext.getAttribute(UdaSpringContext.class.getName());
		UdaHandlerMapping mapping = context.getBean(UdaHandlerMapping.class);
		UdaViewResolver resolver = context.getBean(UdaViewResolver.class);
		// 根据路径获取执行链
		UdaHandlerExecutionChain handlerChain = mapping.getHandler(req);
		if (handlerChain == null) {
			ModelView mv = new ModelView("404");
			resolver.forward(mv, req, resp);
			return;
		}
		UdaHandlerAdapter handler = new UdaHandlerAdapter(handlerChain);
		// 执行执行链
		ModelView mv = handler.postHandle(req);
		// 处理视图并跳转到界面
		resolver.forward(mv, req, resp);
	}

}
