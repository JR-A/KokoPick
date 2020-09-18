package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//localhost:1522 ¡÷¿«
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "c##ezen", "1234");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.50:1521:xe", "ezen", "1234");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//DB Connection Test
	/*
	public static void main(String[] args) {
		try {
			Connection con = getConnection();
			String sql = "select * from Member";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}