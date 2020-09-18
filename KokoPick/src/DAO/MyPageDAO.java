package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.Member;

public class MyPageDAO {
	//singleton pattern
	private static MyPageDAO instance = new MyPageDAO();
		
	private MyPageDAO() {}
		
	public static MyPageDAO getInstance() {
		return instance;
	}
		
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	
	//logic
	public Member getMember(int userId) {
		Member member = null;
		String sql = "SELECT * FROM Member WHERE userId = ?";
		conn = DBConnection.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new Member();
				member.setUserId(rs.getInt("userId"));
				member.setSex(rs.getString("sex"));
				member.setEmail(rs.getString("email"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
			}
			
			conn.close();
			return member;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//비밀번호 변경하기
	public int modifyPassword(int userId, String newPw) {
		String sql = "UPDATE Member SET password = ? WHERE userid = ?";
		conn = DBConnection.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setInt(2, userId);
			
			int affectedRowCount = pstmt.executeUpdate();
			
			conn.close();
			return affectedRowCount;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	//회원 탈퇴하기
	public int deleteAccount(int userId) {
		String sql = "DELETE FROM Member WHERE userId = ?";
		conn = DBConnection.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			
			int affectedRowCount = pstmt.executeUpdate();
			
			conn.close();
			return affectedRowCount;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
