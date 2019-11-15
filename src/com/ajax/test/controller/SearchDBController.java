package com.ajax.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.test.service.SearchService;
import com.ajax.test.service.impl.SearchServiceImpl;
import com.google.gson.Gson;

@WebServlet(name="/SearchDBController", urlPatterns= {"/searchDB/*"})
public class SearchDBController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SearchService ss = new SearchServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		Gson g = new Gson();
		
		Map<String, String> idList = new HashMap<>();
		idList.put("biNum", request.getParameter("biTitle"));
		
		List<String> sBoard = ss.selectSearch(idList);
		
		String id = request.getParameter("id");
		
		if(id == null){
			out.print(g.toJson(idList));
		} else {
		 	List<String> tmpList = new ArrayList<>();
		 	for(String str :idList){
		 		if(str.indexOf(id) != -1){
		 			tmpList.add(str);
		 		}
		 	}
		 	out.print(g.toJson(tmpList));
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
