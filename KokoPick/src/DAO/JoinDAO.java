package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinDAO {
	//singleton pattern
	private static JoinDAO instance = new JoinDAO();
	
	private JoinDAO() {}
	
	public static JoinDAO getInstance() {
		return instance;
	}
	
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	//logic
	//���̵� �ߺ�Ȯ��
	public boolean checkDuplicate(String email) {
		boolean check = false;
		String sql = "SELECT COUNT(*) as cnt FROM Member WHERE email LIKE ?";
		conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 if(rs.getInt("cnt")==0) {
					 check = true;
				 }
			}
			
			conn.close();
			return check;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//ȸ������(Member ���̺� ȸ�� �߰�)
	//https://stackoverrun.com/ko/q/2314251
	public int join(String sex, String email, String password, String name, String phone) {
		//  '': sql�� 'ǥ��, || concat���:���ڿ���ġ��
		String sql = "INSERT INTO Member VALUES(USERID_SEQUENCE.NEXTVAL, ?, ?, ?, ?, ?)";
		conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sex);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setString(4, name);
			pstmt.setString(5, phone);
			
			//executeUpdate(sql) �Լ� ��� executeUpdate()���
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
