package com.ajax.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ajax.test.common.DBCon;
import com.ajax.test.dao.SearchDAO;

public class SearchDAOImpl implements SearchDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<String> selectDB(String select) {
		con = DBCon.getCon();
		String sql = "select * from board_info";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		List<String> sList = new ArrayList<>();
		while(rs.next()) {
			List<String> s = new ArrayList<>();
			s.add(rs.getString("bi_title"));
		}
		return sList;
	}

}
