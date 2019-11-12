package com.ajax.test.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// urlPatterns : 여러 개! ("," 사용해서 추가)
@WebServlet(name = "/ViewsServlet", urlPatterns = {"/views/*"}, loadOnStartup = 2)
public class ViewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PREFIX = "/WEB-INF";
	private static final String SUFFIX = ".jsp";
    
//	 public ViewsServlet() {
//	    System.out.println("아마도 2번째!");
//	 }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = PREFIX + request.getRequestURI() + SUFFIX;
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
