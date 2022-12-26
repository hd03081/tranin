package com.toy.runeah.simpleWebServlet.dao;

import java.sql.SQLException;

import com.toy.runeah.simpleWebServlet.dto.MemberDto;

public class SignDao {
	
	DBProperty dbProperty = null;
	
	public SignDao() {
		dbProperty = new DBProperty();
	}
	
	public int addMember(MemberDto sign) { //박스추가
		int insertCount=0;
		try {
			String sql = "insert into tranin_member(id,pw,nickname,address,zipcode) values(?, ?, ?, ?, ?)";		
			dbProperty.pstmt = dbProperty.conn.prepareStatement(sql);
			dbProperty.pstmt.setString(1, sign.getId());
			dbProperty.pstmt.setString(2, sign.getPw());
			dbProperty.pstmt.setString(3, sign.getNickName());
			dbProperty.pstmt.setString(4, sign.getAddress());
			dbProperty.pstmt.setString(5, sign.getZipCode());
			insertCount = dbProperty.pstmt.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(dbProperty.pstmt != null) {
				try {
					dbProperty.pstmt.close();
				}catch(Exception ex) {}
			}
			if(dbProperty.conn != null) {
				try {
					dbProperty.conn.close();
				}catch(Exception ex) {}
		}
	}
		return insertCount;
	}
	
	public String dupeCheck(String id) {
		try {
			String sql = "SELECT id FROM tranin_member WHERE id='"+id+"'";
			dbProperty.pstmt = dbProperty.conn.prepareStatement(sql);
			dbProperty.rs = dbProperty.pstmt.executeQuery();
			System.out.println(dbProperty.rs.first());
			if(dbProperty.rs.first()==false) {
				return "1";
			}
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (dbProperty.rs != null) {
					dbProperty.rs.close();
				}
				if (dbProperty.pstmt != null) {
					dbProperty.pstmt.close();
				}

				if (dbProperty.conn != null && !dbProperty.conn.isClosed()) {
					dbProperty.conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "-1";
	}
}
