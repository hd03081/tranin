package com.toy.runeah.simpleWebServlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.toy.runeah.simpleWebServlet.dto.BoardDto;

public class FreeBoardDetailDao {

	public BoardDto getOneBoard(String boardNo) {
		BoardDto freeBoardDetail = null;
		DBProperty dbProperty = new DBProperty();
		try {
			String sql = "SELECT * FROM runeah.new_board WHERE board_no="+boardNo+";";
			dbProperty.pstmt = dbProperty.conn.prepareStatement(sql);
			dbProperty.rs = dbProperty.pstmt.executeQuery();
			System.out.println(dbProperty.rs.first());
			freeBoardDetail = new BoardDto(dbProperty.rs.getInt(1),dbProperty.rs.getInt(2),dbProperty.rs.getString(3),
					dbProperty.rs.getString(4),dbProperty.rs.getDate(5),dbProperty.rs.getDate(6),dbProperty.rs.getString(7),dbProperty.rs.getString(8),
					dbProperty.rs.getInt(9),dbProperty.rs.getInt(10));
			return freeBoardDetail;
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
		return freeBoardDetail;
	}
}
