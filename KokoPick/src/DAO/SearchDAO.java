package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Models.Order;

public class SearchDAO {
	// singleton pattern
	private static SearchDAO instance = new SearchDAO();

	private SearchDAO() {}

	public static SearchDAO getInstance() {
		return instance;
	}

	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	// logic
	// 주문 내역 가져오기
	public Vector<Order> getAllOrders(int userId) {
		Vector<Order> orderlist = new Vector<Order>();
		String sql = "SELECT * FROM Orders WHERE userId = ? ORDER BY orderId";
		conn = DBConnection.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt(1));
				order.setmenu(rs.getString(2));
				order.setPrice(rs.getInt(3));
				order.setDeliveryFlag(rs.getInt(4));
				order.setDeliveryFee(rs.getInt(5));
				order.setBrandId(rs.getInt(6));
				order.setUserId(rs.getInt(7));
				orderlist.add(order);
			}
			conn.close();
			return orderlist;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//주문번호로 주문 가져오기
	public Order getOrder(int orderId) {
		Order order = null;
		String sql = "SELECT * FROM Orders WHERE orderId = ?";
		conn = DBConnection.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				order = new Order();
				order.setOrderId(rs.getInt(1));
				order.setmenu(rs.getString(2));
				order.setPrice(rs.getInt(3));
				order.setDeliveryFlag(rs.getInt(4));
				order.setDeliveryFee(rs.getInt(5));
				order.setBrandId(rs.getInt(6));
				order.setUserId(rs.getInt(7));
			}
			conn.close();
			return order;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
      
 