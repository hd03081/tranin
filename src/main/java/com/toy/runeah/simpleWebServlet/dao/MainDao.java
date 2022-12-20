package com.toy.runeah.simpleWebServlet.dao;

import java.sql.SQLException;

public class MainDao {
	
	public String getSomething(){
		DBProperty dbProperty = new DBProperty();
		try {
			String sql = "select * from tranin_member";
			
			dbProperty.pstmt = dbProperty.conn.prepareStatement(sql);

			dbProperty.rs = dbProperty.pstmt.executeQuery();
			String data1 = null;
			String data2 = null;
			String data3 = null;
			while (dbProperty.rs.next()) {
				data1 = dbProperty.rs.getString(1);
				data2 = dbProperty.rs.getString(2);
				data3 = dbProperty.rs.getString(3);
			}

			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
			return data1+data2+data3;
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
		return dbProperty.DB_URL;
		
	  }	
}
