package GUI;
import DAO.CancelDAO;
import Models.Order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;


public class CancelForm extends JFrame {
	private int userId;

	private JPanel mainPanel;
    private JTable ordersTable;
    private JScrollPane scrollPane;
    private JButton btn_cancel;
   
    private final String[] columnNames = { "주문번호", "메뉴이름", "가격" };
    private Object[][] data = {};
   
   /**
    * Create the frame.
    */
   public CancelForm() {
	   init();
   }
   public CancelForm(int userId) {
	  this.userId = userId;
	   
      init();
      showOrderList();
      
      //취소하기 버튼 클릭시
		btn_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CancelDAO cancelDao = CancelDAO.getInstance();
				// 테이블의 선택된 행의 번호 가져오기
				int[] selectedRows = ordersTable.getSelectedRows();
				
				//선택된 행의 개수가 0이 아닌경우
				if (selectedRows.length != 0) {
					int orderId = (int) ordersTable.getValueAt(selectedRows[0], 0);

					// 사용자의 주문 취소 의사 확인
					int result = JOptionPane.showConfirmDialog(null, "취소 하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
					
					// 사용자가 "예"버튼을 선택한 경우
					if (result == JOptionPane.YES_OPTION) {
						// 주문 취소하기
						int affectedRowCount = cancelDao.cancel(orderId);
						if (affectedRowCount >= 1) {
							JOptionPane.showMessageDialog(null, "주문번호 " + orderId + " 취소 완료되었습니다.", "Confirm",
									JOptionPane.INFORMATION_MESSAGE);
							
							//테이블 새로고침
							showOrderList();
						}	
					} 
				} 
				else {
					JOptionPane.showMessageDialog(null, "취소할 주문을 먼저 선택해 주세요.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}

		});
   }
   
   //주문내역 보여주기
   public void showOrderList() {
	   CancelDAO cancelDao = CancelDAO.getInstance();
	   Vector<Order> orderList = cancelDao.getAllOrders(userId);
	   Iterator<Order> iterator = orderList.iterator();
	   
	   DefaultTableModel model = (DefaultTableModel)ordersTable.getModel();
	   model.setNumRows(0); // 테이블 초기화
	   
	   while(iterator.hasNext()) {
		   Order order = iterator.next();
		   model.addRow(new Object[] {order.getOrderId(), order.getMenu(), order.getPrice()+order.getDeliveryFee()});   
	   }
	   ordersTable.updateUI(); //테이블 갱신
   }
   
	public void init() {
		setTitle("\uC8FC\uBB38\uCDE8\uC18C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 484);
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);

		//btn_cancel = new JButton("\uCDE8\uC18C\uD558\uAE30");
		btn_cancel = new JButton(new ImageIcon("./img/cancelButtonIcon2.png"));
		btn_cancel.setBackground(Color.WHITE);
		btn_cancel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_cancel.setBounds(163, 380, 150, 36);
		btn_cancel.setBorderPainted(false);	

		mainPanel.setLayout(null);
		mainPanel.add(btn_cancel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 35, 414, 306);
		mainPanel.add(scrollPane);

		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, Integer.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		ordersTable = new JTable(model);
		ordersTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(ordersTable);
		
		ordersTable.getColumnModel().getColumn(0).setPreferredWidth(80);
		ordersTable.getColumnModel().getColumn(0).setResizable(false);
		ordersTable.getColumnModel().getColumn(1).setPreferredWidth(430);
		ordersTable.getColumnModel().getColumn(1).setResizable(false);
		ordersTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		ordersTable.getColumnModel().getColumn(2).setResizable(false);
	}
}