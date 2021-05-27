package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.BusinessCard;

public class BusinessCardManagerDao {

	Connection con = null;
	Statement stmt = null;

	public Connection getConnection() throws Exception {

		// 1. 드라이버 로딩
		String url = "jdbc:mysql://localhost:3306/cardmanager?useUnicode=true&characterEncoding=utf8";
		String user = "test";
		String password = "test";
		String driver = "com.mysql.cj.jdbc.Driver";

		// 2. 드라이버 연결
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);

		return con;

	}

	public List<BusinessCard> searchBusinessCard(String keyword) throws Exception {

		List<BusinessCard> list = new ArrayList<BusinessCard>();

		con = getConnection();
		
		stmt = con.createStatement();

		String sql;

		sql = "SELECT * FROM USER WHERE name like '%" + keyword + "%'";

		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			BusinessCard businessCard = new BusinessCard();

			businessCard.setName(rs.getString("name"));
			businessCard.setPhone(rs.getString("phone"));
			businessCard.setCompanyName(rs.getString("companyName"));
			businessCard.setCreateDate(rs.getDate("createDate"));

			list.add(businessCard);

		}

		rs.close();
		stmt.close();
		con.close();

		return list;

	}

	public void addBusinessCard(BusinessCard businessCard) throws Exception {
		
		con = getConnection();
		
		stmt = con.createStatement();
		
		String sql;
		
		sql = "INSERT INTO USER(name, phone, companyName) VALUES("+businessCard.getName()+","+businessCard.getPhone()+","+businessCard.getCompanyName()+")";
		
		stmt.executeUpdate(sql);
		
	}

}
