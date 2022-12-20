package com.toy.runeah.simpleWebServlet.dao;

import com.toy.runeah.simpleWebServlet.dto.BoardDto;

public class FreeBoardRegistDao {
public int addBoard(BoardDto board) { //박스추가
		DBProperty dbProperty = new DBProperty();
		int insertCount=0;
		try {
			String sql = "insert into new_board(member_no,nickname,title,attached_image_url,content) values(?, ?, ?, ?, ?)";
			dbProperty.pstmt = dbProperty.conn.prepareStatement(sql);
			dbProperty.pstmt.setInt(1, board.getMemberNo());
			dbProperty.pstmt.setString(2, board.getNickName());
			dbProperty.pstmt.setString(3, board.getTitle());
			dbProperty.pstmt.setString(4, board.getAttachedImageURL());
			dbProperty.pstmt.setString(5, board.getContent());
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
