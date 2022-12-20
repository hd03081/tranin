package com.toy.runeah.simpleWebServlet.dao;

import com.toy.runeah.simpleWebServlet.dto.SignDto;

public class SignDao {
	public int addMember(SignDto sign) { //박스추가
		DBProperty dbProperty = new DBProperty();
		int insertCount=0;
		try {
			String sql = "insert into tranin_member(memberId,password,name,nickName,sex,birthYear,birthMonth,birthDay,phone1,phone2,phone3,phone4,phone5,phone6,zipCode,address1,address2) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";		
			dbProperty.pstmt = dbProperty.conn.prepareStatement(sql);
			dbProperty.pstmt.setString(1, sign.getMemberId());
			dbProperty.pstmt.setString(2, sign.getPassword());
			dbProperty.pstmt.setString(3, sign.getName());
			dbProperty.pstmt.setString(4, sign.getNickName());
			dbProperty.pstmt.setString(5, sign.getSex());
			dbProperty.pstmt.setString(6, sign.getBirthYear());
			dbProperty.pstmt.setString(7, sign.getBirthMonth());
			dbProperty.pstmt.setString(8, sign.getBirthDay());
			dbProperty.pstmt.setString(9, sign.getPhone1());
			dbProperty.pstmt.setString(10, sign.getPhone2());
			dbProperty.pstmt.setString(11, sign.getPhone3());
			dbProperty.pstmt.setString(12, sign.getPhone4());
			dbProperty.pstmt.setString(13, sign.getPhone5());
			dbProperty.pstmt.setString(14, sign.getPhone6());
			dbProperty.pstmt.setString(15, sign.getZipCode());
			dbProperty.pstmt.setString(16, sign.getAddress1());
			dbProperty.pstmt.setString(17, sign.getAddress2());
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
}
