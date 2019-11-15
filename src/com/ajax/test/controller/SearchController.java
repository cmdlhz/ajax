package com.ajax.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(name="/SearchController", urlPatterns= {"/search/*"})
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		Gson g = new Gson();
		List<String> idList = new ArrayList<>();
		idList.add("jessica");
		idList.add("ashley");
		idList.add("jacky");
		idList.add("jennifer");
		idList.add("jenny");
		
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
//		 	for(int i=0; i<idList.size(); i++) {
//		 		if(idList.get(i).indexOf(id) != -1) {
//		 			tmpList.add(idList.get(i));
//		 		}
//		 	}
		 	out.print(g.toJson(tmpList));
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
