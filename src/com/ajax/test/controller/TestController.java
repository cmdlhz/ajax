package com.ajax.test.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.test.service.AddressService;
import com.ajax.test.service.impl.AddressServiceImpl;
import com.google.gson.Gson;

@WebServlet(name="/TestController", urlPatterns= {"/test/*"})
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddressService as = new AddressServiceImpl();
	private Gson g = new Gson();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
//		pw.print(as.selectSidoList(null));
		pw.print(g.toJson(as.selectSidoList(null)));

		//		pw.print("[\"서울\", \"광주\", \"부산\"]");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
