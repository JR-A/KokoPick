package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import Models.Member;
import Models.Order;

public class CancelDAO {
	//singleton pattern
	private static CancelDAO instance = new CancelDAO();

	public String orderc;

	public CancelDAO() {
	}

	public static CancelDAO getInstance() {
		return instance;
	}

	private static Connection conn;
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	
	//logic
	//주문 내역 가져오기
	public Vector<Order> getAllOrders(int userId) {
		Vector<Order> orderlist = new Vector<>();
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
	
	//주문 취소하기
	public int cancel(int orderId) {
		  String sql = "DELETE FROM Orders WHERE orderId = ?";
	      conn = DBConnection.getConnection();
	      int affectedRowCount = 0;
	      
	      try {
	    	  
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, orderId);
	         affectedRowCount = pstmt.executeUpdate();
	      
	         conn.close();
	         return affectedRowCount;
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      return 0;
	}
	
	//주문번호로 Order객체 가져오기
	public Order getOrder(int orderId) {
		String sql = "SELECT * FROM Orders WHERE orderId = ?";
		conn = DBConnection.getConnection();
		Order order = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
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

   