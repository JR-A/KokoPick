package DAO;

import Models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SearchDetailDAO {
	//singleton pattern
	private static SearchDetailDAO instance = new SearchDetailDAO();
	
	private SearchDetailDAO() {}
	
	public static SearchDetailDAO getInstance() {
		return instance;
	}
	
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	//logic
	//brandId로 브랜드명 가져오기
	public String getBrandName(int brandId) {
		String brandName = null;
		String sql = "SELECT name from Brand WHERE brandId = ?";
		conn = DBConnection.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, brandId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				brandName = rs.getString("name");
			}
			
			conn.close();
			return brandName;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//brandId과 메뉴명으로 메뉴 가져오기
	public Menu getMenu(int brandId, String name){
		Menu menu = null;
		String sql = "SELECT * FROM Menu WHERE brandId = ? and name LIKE ?";
		conn = DBConnection.getConnection();
		
		try {
			menu = new Menu();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, brandId);
			pstmt.setString(2, name);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				menu.setBrandId(rs.getInt("brandId"));
				menu.setName(rs.getString("name"));
				menu.setCategory(rs.getInt("category"));
				menu.setPrice(rs.getInt("price"));
			}
			
			conn.close();
			return menu;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
