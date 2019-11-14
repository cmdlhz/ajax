package com.ajax.test.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.test.service.BoardService;
import com.ajax.test.service.impl.BoardServiceImpl;
import com.google.gson.Gson;

// preloading
@WebServlet(name = "/BoardController", urlPatterns = {"/ajax/board/*", "/jsp/board/*"}, loadOnStartup = 1)
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService bs = new BoardServiceImpl();
    private Gson g = new Gson();
	
    public BoardController() {
    	// Tomcat 킬 때는 new BoardController() 실행안 됨
    	// 요청이 들어왔을 때 생성됨
//    	System.out.println("1. BoardController has been created!");
    }
    // init() => 초기화
    public void init() {
//    	System.out.println("2. I should be called after the contsturctor(생성자) has been called.");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("3. I would be called whenever 'get'method is used.");
//		String kind = request.getRequestURI().substring(1,4);
		
		// "application/json"에서 "/" : 폴더 아님!
		response.setContentType("application/json;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
//		cmd로 구분
		String cmd = request.getParameter("cmd");
		
		// ==은 메모리 주소 비교니까 쓰지마세요 (자바스크립트에서는 ==는 값만 비교)
		if("list".contentEquals(cmd)) {
			List<Map<String, String>> boardList = bs.selectBoardList(null);
			pw.print(g.toJson(boardList));
		} else if("view".contentEquals(cmd)) {
			Map<String, String> param = new HashMap<>();
			param.put("biNum", request.getParameter("biNum"));
			// int로 받아도 됨
			Map<String, String> board = bs.selectBoard(param);
//			System.out.println(board);
			
			// JSON 형태의 string으로
			pw.print(g.toJson(board));
		}
		return;
		
//		if("aja".contentEquals(kind)) {
//			String cmd = request.getParameter("cmd");
//			if("list".equals(cmd)) {
//				List<Map<String, String>> boardList = bs.selectBoardList(null);
//				pw.print(g.toJson(boardList));
//			} else if("view".equals(cmd)) {
//				Map<String, String> param = new HashMap<>();
//				param.put("biNum", request.getParameter("biNum"));
//				Map<String, String> board = bs.selectBoard(param);
//				pw.print(g.toJson(board));
//			}
//			return;
//		} else if("jsp".equals(kind)) {
//			request.setAttribute("list", boardList);
//			String path = "/views/jsp/list";
//			RequestDispatcher rd = request.getRequestDispatcher(path);
//			rd.forward(request, response);
//			return;
//		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getParameter("name"));
//		System.out.println(request.getParameter("age"));
		
		BufferedReader br = request.getReader();
		String str = null;
		String json = "";
		while((str = br.readLine()) != null) {
			json += str;
		}
		Map<String, String> board = g.fromJson(json, Map.class);
//		System.out.println(board);
		// 아까는 읽는것만 한국어로 해놓은 것/ 지금은 입력하는 것 그래서 한국어가 안 깨지게 표시해 주는 것
		response.setContentType("application/json;charset=utf-8");
		json = g.toJson(bs.insertBoard(board));
		response.getWriter().print(json);
	}
}

// 자바 map 형태 : {a=b, c=d}
// 자바스크립트 map 형태 : {a:b, c:d}