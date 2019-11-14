package com.ajax.test.service.impl;

import java.util.List;
import java.util.Map;

import com.ajax.test.dao.AddressDAO;
import com.ajax.test.dao.impl.AddressDAOImpl;
import com.ajax.test.service.AddressService;

public class AddressServiceImpl implements AddressService {
	private AddressDAO adao = new AddressDAOImpl();
	
	@Override
	public List<Map<String, String>> selectSidoList(Map<String, String> sido) {
		return adao.selectSidoList(sido);
	}

	@Override
	public Map<String, String> selectSido(Map<String, String> sido) {
		return null;
	}
	public static void main(String[] args) {
		AddressService as = new AddressServiceImpl();
		System.out.println(as.selectSidoList(null));
	}
}
