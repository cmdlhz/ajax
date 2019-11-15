package com.ajax.test.service.impl;

import java.util.List;

import com.ajax.test.dao.SearchDAO;
import com.ajax.test.dao.impl.SearchDAOImpl;
import com.ajax.test.service.SearchService;

public class SearchServiceImpl implements SearchService {
	private SearchDAO sdao = new SearchDAOImpl();
	
	@Override
	public List<String> selectDB(String select) {
		return sdao.selectDB(select);
	}

}
