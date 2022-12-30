package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBProperty {
	//jdbc:mariadb://localhost:3306/runeah?autoReconnect=true
	final String driver = "org.mariadb.jdbc.Driver";
	final String DB_IP = "localhost";
	final String DB_PORT = "3306";//로컬로 할시엔 3308
	final String DB_NAME = "runeah";
	final String DB_URL = 
			"jdbc:mariadb://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME;
	final String DB_URL_TEST = "jdbc:mariadb://runeah.cafe24.com:3306/runeah?autoReconnect=true";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	{
		try {
			Class.forName(driver);
			//conn = DriverManager.getConnection(DB_URL_TEST, "runeah", "Qjatn_15151");
			conn = DriverManager.getConnection(DB_URL_TEST, "runeah", "tranin1!");
			System.out.println(conn);
			if (conn != null) {
				System.out.println("DB 접속 성공");
			}
	
		} catch (ClassNotFoundException e1) {
			System.out.println("드라이버 로드 실패");
			e1.printStackTrace();
		} catch (SQLException e2) {
			System.out.println("DB 접속 실패");
			e2.printStackTrace();
		}
	}
}
