package com.toy.runeah.simpleWebServlet.dao;

import java.sql.SQLException;

public class MyPageDao {
	public void modifyProfileNickName(String nickName,String id) {
		DBProperty dbProperty = new DBProperty();
		String sql = "UPDATE tranin_member SET nickName='"+nickName+"' WHERE memberId='"+id+"'";
		try {
			dbProperty.pstmt = dbProperty.conn.prepareStatement(sql);
			dbProperty.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifyProfileStatusMessage(String newStatusMessage, String id) {
		DBProperty dbProperty = new DBProperty();
		String sql = "UPDATE tranin_member SET statusMessage='"+newStatusMessage+"' WHERE memberId='"+id+"'";
		try {
			dbProperty.pstmt = dbProperty.conn.prepareStatement(sql);
			dbProperty.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifyImageURL(String filePath, String memberId) {
		DBProperty dbProperty = new DBProperty();
		String sql = "UPDATE tranin_member SET imageUrl='"+filePath+"' WHERE memberId='"+memberId+"'";
		try {
			dbProperty.pstmt = dbProperty.conn.prepareStatement(sql);
			dbProperty.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMember(int no) {
		DBProperty dbProperty = new DBProperty();
		String sql = "DELETE FROM tranin_member WHERE no="+no;
		try {
			dbProperty.pstmt = dbProperty.conn.prepareStatement(sql);
			dbProperty.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
