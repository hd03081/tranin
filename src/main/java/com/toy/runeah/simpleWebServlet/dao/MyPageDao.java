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
	
	public void modifyMyPageInfo(int myPageMyInfoNo,String myPageMyInfoId,String myPageMyInfoPassword,
			String myPageMyInfoName,String myPageMyInfoNickName,String myPageMyInfoSex,
			String myPageMyInfoBirth,String myPageMyInfoPhone,String myPageMyInfoTel,
			String myPageMyAddress,String myPageMyInfoAccountNo) {
		DBProperty dbProperty = new DBProperty();
		//UPDATE `runeah`.`tranin_member` SET `memberId`='ssss', `password`='ssss', `name`='aaaa', `nickname`='gdfd', `sex`='여성', `birthYear`='1212', `phone1`='4124124', `phone4`='412312', `address1`='ㄹㅇㅁㅇㄻㅇㄻㅇㄹ' WHERE  `no`=17;
		String sql = "UPDATE tranin_member SET memberId='"+myPageMyInfoId+"', password='"+myPageMyInfoPassword+"', name='"+myPageMyInfoName+"', nickName='"+myPageMyInfoNickName+"', sex='"+myPageMyInfoSex+"', birthYear='"+myPageMyInfoBirth+"', phone1='"+myPageMyInfoPhone+"', phone4='"+myPageMyInfoTel+"', address1='"+myPageMyAddress+"' WHERE no="+myPageMyInfoNo;
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
