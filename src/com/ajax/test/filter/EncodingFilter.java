package com.ajax.test.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

// Servlet과 다르게 filter는 메모리를 먼저 생성함
@WebFilter(filterName = "EncodingFilter", urlPatterns= {"*"})
public class EncodingFilter implements Filter {

	// 화면 뜨기도 전에 이미 실행됨
    public EncodingFilter() {
//        System.out.println("I gets called automatically!");
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest req = (HttpServletRequest)request;
//		System.out.println(req.getRequestURI());
		
		// 다른 file에서 일일히 안 해줘도 됨!
		request.setCharacterEncoding("utf-8"); // 수정할 때는 web.xml에서
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
