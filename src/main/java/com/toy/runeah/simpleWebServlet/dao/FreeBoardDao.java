package com.toy.runeah.simpleWebServlet.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.toy.runeah.simpleWebServlet.dto.BoardDto;

public class FreeBoardDao {

	public List<BoardDto> getBoards(){
		
		List<BoardDto> freeBoardList = new ArrayList<>();
		DBProperty dbProperty = new DBProperty();

		try {
			String sql = "SELECT board_no,nickname,title,regdate,view_count,thumbup_count FROM runeah.new_board;";
			
			dbProperty.pstmt = dbProperty.conn.prepareStatement(sql);
			//boardlist 맵핑하기!
			dbProperty.rs = dbProperty.pstmt.executeQuery();
			
			Integer boardNo = null;
			String nickName = null;
			String title = null;
			Date regDate = null;
			Integer viewCount = null;
			Integer thumbUpCount = null;
			while (dbProperty.rs.next()) {
				boardNo = dbProperty.rs.getInt(1);
				nickName = dbProperty.rs.getString(2);
				title = dbProperty.rs.getString(3);
				regDate = dbProperty.rs.getDate(4);
				viewCount = dbProperty.rs.getInt(5);
				thumbUpCount = dbProperty.rs.getInt(6);
				BoardDto dto = new BoardDto(boardNo,nickName,title,regDate,viewCount,thumbUpCount);
				freeBoardList.add(dto);
			}
			return freeBoardList;
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
		return freeBoardList;
		
	  }	
}
