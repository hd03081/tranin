package com.toy.runeah.simpleWebServlet.dao;

import java.sql.SQLException;
import com.toy.runeah.simpleWebServlet.dto.LoginDto;
import com.toy.runeah.simpleWebServlet.dto.SignDto;

public class LoginDao {
	public SignDto login(LoginDto login) { //박스추가
		SignDto loginedMember = null;
		DBProperty dbProperty = new DBProperty();
		try {
			String sql = "SELECT * FROM tranin_member WHERE memberID="+'"'+login.getMemberID()+'"'+"AND password="+'"'+login.getPassword()+'"';		
			dbProperty.pstmt = dbProperty.conn.prepareStatement(sql);
			dbProperty.rs = dbProperty.pstmt.executeQuery();
			System.out.println(dbProperty.rs.first());
			if(dbProperty.rs.first()==false) {
				return null;
			}
			int memberNo = dbProperty.rs.getInt(1);
			String memberId = dbProperty.rs.getString(2);
			String password = dbProperty.rs.getString(3);
			String name = dbProperty.rs.getString(4);
			String nickName = dbProperty.rs.getString(5);
			String sex = dbProperty.rs.getString(6);
			String birthYear= dbProperty.rs.getString(7);
			String birthMonth= dbProperty.rs.getString(8);
			String birthDay= dbProperty.rs.getString(9);
			String phone1= dbProperty.rs.getString(10);
			String phone2= dbProperty.rs.getString(11);
			String phone3= dbProperty.rs.getString(12);
			String phone4= dbProperty.rs.getString(13);
			String phone5= dbProperty.rs.getString(14);
			String phone6= dbProperty.rs.getString(15);
			String zipCode= dbProperty.rs.getString(16);
			String address1= dbProperty.rs.getString(17);
			String address2= dbProperty.rs.getString(18);
			String imageURL= dbProperty.rs.getString(19);
			String statusMessage= dbProperty.rs.getString(20);
			
			loginedMember = new SignDto(memberNo,memberId,password,name,nickName,sex,birthYear,birthMonth,birthDay,phone1,phone2,phone3,phone4,phone5,phone6,zipCode,address1,address2, imageURL, statusMessage);
			return loginedMember;
			
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
		return loginedMember;
	}

}
