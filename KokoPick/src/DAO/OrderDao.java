package DAO;

import Models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class OrderDAO {
	//singleton pattern
	private static OrderDAO instance = new OrderDAO();
	
	private OrderDAO() {}
	
	public static OrderDAO getInstance() {
		return instance;
	}
	
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	//Logic
	//brandId순서대로 브랜드 이름 모두 가져오기
	public Vector<String> getAllBrands(){
		Vector<String> brandNames = new Vector<>();
		String sql = "SELECT name FROM Brand ORDER BY brandId";
		conn = DBConnection.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				brandNames.add(rs.getString("name"));
			}
			
			conn.close();
			return brandNames;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//brandName을 입력으로 메뉴 반환하기
	public Vector<Menu> getAllMenus(String brandName){
		Vector<Menu> menus = new Vector<>();
		String sql = "SELECT m.brandId, m.name, category, price FROM Brand b, Menu m WHERE b.brandId=m.brandId AND b.name LIKE ? ORDER BY category";
		conn = DBConnection.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brandName);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Menu menu = new Menu();
				menu.setBrandId(rs.getInt("brandId"));
				menu.setName(rs.getString("name"));
				menu.setCategory(rs.getInt("category"));
				menu.setPrice(rs.getInt("price"));
				
				menus.add(menu);
			}
			conn.close();
			return menus;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//주문하기
	public boolean order(String menu, int price, int deliveryFlag, int deliveryFee, int brandId, int userId) {
		//Order(orderId,menu,price,deliveryFlag,deliveryFee,brandId,userId);
		//orderId값은 sequence 이용하여 추가
		String sql = "INSERT INTO Orders VALUES (ORDERID_SEQUENCE.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		conn = DBConnection.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, menu);
			pstmt.setInt(2, price);
			pstmt.setInt(3, deliveryFlag);
			pstmt.setInt(4, deliveryFee);
			pstmt.setInt(5, brandId);
			pstmt.setInt(6, userId);
			
			rs = pstmt.executeQuery();
			
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//brandName을 입력으로 브랜드 id가져오기
	public int getBrandId(String brandName) {
		int brandId = 0;
		String sql = "SELECT brandId FROM Brand WHERE name LIKE ?";
		conn = DBConnection.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brandName);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				brandId = rs.getInt("brandId");
			}
			
			conn.close();
			return brandId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
}
