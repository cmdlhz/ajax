package com.ajax.test.service;

import java.util.List;
import java.util.Map;

public interface AddressService {
	// Service에서는 보통 "get"을 쓰심 (이름에)
	public List<Map<String, String>> selectSidoList(Map<String, String> sido);
	public Map<String, String> selectSido(Map<String, String> sido);
}
