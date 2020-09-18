package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.SearchDAO;
import Models.Order;
import java.awt.Color;
import java.awt.Font;

public class SearchForm extends JFrame {
   public int userId;
	
   private JPanel contentPane;
   public JTable ordersTable;
   private JButton btn_searchDetail;
   private JScrollPane scrollPane;
   private final String[] columnNames = {"주문번호","메뉴이름","가격"};
   private Object[][] data = {};
   
   public SearchForm() {
   	setBackground(Color.WHITE);
	   init();
   }
   
   public SearchForm(int userId) {
      this.userId = userId;
	  
      init();
      showOrderList();
      
      //상세조회하기 버튼 클릭시
		btn_searchDetail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchDAO searchDao = SearchDAO.getInstance();
				// 테이블의 선택된 행의 번호 가져오기
				int[] selectedRows = ordersTable.getSelectedRows();
				
				//선택된 행의 개수가 0이 아닌경우
				if (selectedRows.length != 0) {
					int orderId = (int) ordersTable.getValueAt(selectedRows[0], 0);

					// 테이블에서 선택된 행의 주문번호로 DB조회하여 Order받아오기
					Order order = searchDao.getOrder(orderId);

					// 상세조회 Form띄우기(order객체 넘겨주기)
					SearchDetailForm searchDetailForm = new SearchDetailForm(order);
					searchDetailForm.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "상세 조회할 주문을 먼저 선택해 주세요.", "Warning",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
   }
   
   //주문내역 보여주기
   public void showOrderList() {
      DefaultTableModel model = (DefaultTableModel)ordersTable.getModel();
      model.setNumRows(0); //테이블 초기화
      
      SearchDAO searchDao = SearchDAO.getInstance();
      Vector<Order> orderList = searchDao.getAllOrders(userId);
      Iterator<Order> iterator = orderList.iterator();
      
      while(iterator.hasNext()) {
         Order order = iterator.next();
         model.addRow(new Object[] {order.getOrderId(), order.getMenu(), order.getPrice()+order.getDeliveryFee()});   
      }
      ordersTable.updateUI(); //테이블 갱신
   }

   public void init() {
	    setTitle("\uC8FC\uBB38\uB0B4\uC5ED\uC870\uD68C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 484);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//btn_searchDetail = new JButton("\uC0C1\uC138 \uC870\uD68C\uD558\uAE30");
		btn_searchDetail = new JButton(new ImageIcon("./img/searchDetailButtonIcon.png"));
		btn_searchDetail.setBackground(Color.WHITE);
		btn_searchDetail.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_searchDetail.setBounds(163, 380, 150, 36);
		btn_searchDetail.setBorderPainted(false);	//버튼 바운더리 없애기
		contentPane.add(btn_searchDetail);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 35, 414, 306);
		contentPane.add(scrollPane);

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
           
