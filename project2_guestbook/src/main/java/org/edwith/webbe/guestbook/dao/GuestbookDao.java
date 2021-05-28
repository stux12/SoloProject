package org.edwith.webbe.guestbook.dao;

import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuestbookDao {
	
	Connection conn = null;
	Statement stmt = null;
	
    public List<Guestbook> getGuestbooks() throws Exception{
        List<Guestbook> list = new ArrayList<>();

        DBUtil util = new DBUtil();
        
        conn = util.getConnection();
        
        stmt = conn.createStatement();
        
        String sql;
        
        sql = "SELECT * FROM USER";
        
        ResultSet rs = stmt.executeQuery(sql);
        
        while (rs.next()) {
        	
        	Guestbook guestbook = new Guestbook();
        	
        	guestbook.setId(rs.getLong("id"));
        	guestbook.setName(rs.getString("name"));
        	guestbook.setContent(rs.getString("content"));
        	guestbook.setRegdate(rs.getDate("regdate"));
        	
        	list.add(guestbook);
        	
        }
        rs.close();
        stmt.close();
        conn.close();
        return list;
    }

    public void addGuestbook(Guestbook guestbook) throws Exception{
    	
    	DBUtil util = new DBUtil();
    	
    	conn = util.getConnection();
    	
    	stmt = conn.createStatement();
    	
    	String sql;
    	
    	sql = "INSERT INTO USER(name, content) VALUES("+guestbook.getName()+","+guestbook.getContent()+")";
    
    	stmt.executeUpdate(sql);
    	
        stmt.close();
        conn.close();
    }
}
