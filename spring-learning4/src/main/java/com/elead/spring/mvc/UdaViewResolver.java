package com.elead.spring.mvc;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elead.spring.annotation.UdaComponent;

@UdaComponent
public class UdaViewResolver {

	private static String prefix = "/WEB-INF/template/";

	private static String suffix = ".jsp";

	public void forward(ModelView mv, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = mv.getUrl();
		String actualUrl = prefix + url + suffix;
		//将视图中的返回值，设置到request中，用于前台jsp获取。
		Map<String, Object> dataMap = mv.getDataMap();
		if (dataMap != null) {
			Set<String> keySet = dataMap.keySet();
			for (String key : keySet) {
				request.setAttribute(key, dataMap.get(key));
			}
		}
		request.getRequestDispatcher(actualUrl).forward(request, response);
	}
}
