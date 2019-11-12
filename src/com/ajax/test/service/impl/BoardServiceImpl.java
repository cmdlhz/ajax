package com.ajax.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ajax.test.dao.BoardDAO;
import com.ajax.test.dao.impl.BoardDAOImpl;
import com.ajax.test.service.BoardService;

public class BoardServiceImpl implements BoardService {
	private BoardDAO bdao = new BoardDAOImpl();
	
	@Override
	public Map<String, String> selectBoard(Map<String, String> board) {
		return bdao.selectBoard(board);
		// 조회하는 데이터가 없으면 exception 일으켜! 라는 조건을 넣고 싶으면 여기에서 정하면 됨
	}

	@Override
	public List<Map<String, String>> selectBoardList(Map<String, String> board) {
		return bdao.selectBoardList(board);
	}

	@Override
	public Map<String, String> insertBoard(Map<String, String> board) {
		Map<String, String> rMap = new HashMap<>();
		int result = bdao.insertBoard(board);
		if(result == 1){
			rMap.put("msg", "등록 SUCCESSSSSSSSS");
			rMap.put("url", "/views/ajax/insert");
		} else {
			rMap.put("msg", "등록 FAILURE!!!!!");
			rMap.put("url", "/views/ajax/list");
		}
		return rMap;
	}

	@Override
	public Map<String, String> updateBoard(Map<String, String> board) {
		Map<String, String> rMap = new HashMap<>();
		int result = bdao.updateBoard(board);
		if(result == 1){
			rMap.put("msg", "업데이트 SUCCESSSSSSSSS");
			rMap.put("url", "/views/ajax/insert?bi_num=" + board.get("biNum"));
		} else {
			rMap.put("msg", "업데이트 FAILURE!!!!!");
			rMap.put("url", "/views/ajax/insert?bi_num=" + board.get("biNum"));
		}
		return rMap;
	}

	@Override
	public Map<String, String> deleteBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return null;
	}

}
