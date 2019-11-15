package com.ajax.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// urlPatterns : 여러 개! ("," 사용해서 추가)
// "*.test" 라고 하면 앞에 뭐가 오든 마지막에 붙는 게 ".test"이면 됨
@WebServlet(name = "/ViewsServlet", urlPatterns = {"/views/*"}, loadOnStartup = 2)
public class ViewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PREFIX = "/WEB-INF";
	private static final String SUFFIX = ".jsp";
    
//	 public ViewsServlet() {
//	    System.out.println("아마도 2번째!");
//	 }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// context root가 "/"가 아니라면 제거하는 code가 필요함
		// String rootPath = request.getContextPath();
		// string path = request.getRequestURI();
		// path = path.replace(rootPath, "");
		
		String path = PREFIX + request.getRequestURI() + SUFFIX;
		System.out.println(path);
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		
		// If a letter or message is forwarded to someone, it is sent to the place where they are, 
		// after having been sent to a different place earlier.
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
