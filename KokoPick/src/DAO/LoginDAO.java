package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	//singleton pattern
	private static LoginDAO instance = new LoginDAO();
	
	private LoginDAO() {}
	
	public static LoginDAO getInstance() {
		return instance;
	}
	
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	//logic
	public int login(String email, String password) {
		
		int userId = -1;
		String sql = "SELECT userId FROM Member WHERE email LIKE ? AND password LIKE ?";
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				userId = rs.getInt("userId");
			}
			
			conn.close();
			return userId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
