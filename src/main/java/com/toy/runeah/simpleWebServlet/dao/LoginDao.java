package com.toy.runeah.simpleWebServlet.dao;

import java.sql.SQLException;
import com.toy.runeah.simpleWebServlet.dto.LoginDto;
import com.toy.runeah.simpleWebServlet.dto.MemberDto;

public class LoginDao {
	
	DBProperty dbProperty = null;
	
	public LoginDao() {
		dbProperty = new DBProperty();
	}
	
	public MemberDto login(LoginDto login) { //박스추가
		MemberDto loginedMember = null;
		try {
			String sql = "SELECT * FROM tranin_member WHERE id="+'"'+login.getMemberID()+'"'+"AND pw="+'"'+login.getPassword()+'"';		
			dbProperty.pstmt = dbProperty.conn.prepareStatement(sql);
			dbProperty.rs = dbProperty.pstmt.executeQuery();
			System.out.println(dbProperty.rs.first());
			if(dbProperty.rs.first()==false) {
				return null;
			}
			int memberNo = dbProperty.rs.getInt(1);
			String memberId = dbProperty.rs.getString(2);
			String password = dbProperty.rs.getString(3);
			String nickName = dbProperty.rs.getString(4);
			String address= dbProperty.rs.getString(5);
			String zipCode= dbProperty.rs.getString(6);
			String phone= dbProperty.rs.getString(7);
			String accountNo= dbProperty.rs.getString(8);
			String accountName= dbProperty.rs.getString(9);
			String imageURL= dbProperty.rs.getString(10);
			String statusMessage= dbProperty.rs.getString(11);
			
			loginedMember = new MemberDto(memberNo,memberId,password,nickName,address,zipCode,phone,accountNo,accountName, imageURL, statusMessage);
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
