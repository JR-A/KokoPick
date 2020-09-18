package GUI;
import DAO.SearchDetailDAO;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Models.*;
import javax.swing.SwingConstants;
import java.awt.Color;

public class SearchDetailForm extends JFrame {
   private Order order = null;
   private JPanel contentPane;
   private JScrollPane scrollPane;
   private JLabel orderIdLabel, brandNameLabel, sumLabel, orderIdText, brandNameText, sumText, deliveryFeeLabel, wonLabel_1, deliveryFeeText;
   private JTable menuTable;
   
   private final String[] columnNames = {"메뉴이름", "수량", "가격"};
   private Object[][] data = {};
   private JLabel wonLabel;
   
   private SearchDetailDAO searchDetailDao = SearchDetailDAO.getInstance();
   
   /**
    * Create the frame.
    */
   public SearchDetailForm() {
	   init();
   }
   
   public SearchDetailForm(Order order) {	  
      this.order = new Order(order);
      
      init();
      
      orderIdText.setText(Integer.toString(order.getOrderId()));
      brandNameText.setText(searchDetailDao.getBrandName(order.getBrandId()));
      showOrderedMenuList();
      
      deliveryFeeText.setText(Integer.toString(order.getDeliveryFee()));
      sumText.setText(Integer.toString(order.getPrice() + order.getDeliveryFee()));
   }
   
   //주문한 메뉴 테이블 보여주기
   public void showOrderedMenuList() {
	   Menu menu;
	   DefaultTableModel model = (DefaultTableModel)menuTable.getModel();
	   model.setNumRows(0); //테이블 초기화
	   
	   //주문의 menu 문자열 조작(메뉴명만 뽑아내기)
	   String[] menuNameArray = order.getMenu().split(","); //,기준 split
	   for(int i=0; i<menuNameArray.length; i++) {
		   menuNameArray[i] = menuNameArray[i].substring(0, menuNameArray[i].length()-1); 	//수량 자르기
	   }
	   
	   //테이블에 메뉴 정보 추가
	   for(int i=0; i<menuNameArray.length; i++) {
		  menu = searchDetailDao.getMenu(order.getBrandId(), menuNameArray[i]);
		  model.addRow(new Object[] {menu.getName(), 1, menu.getPrice()});
	   }
	   
	   menuTable.updateUI(); //테이블 갱신
   }

   public void init() {
	   setTitle("\uC8FC\uBB38 \uB0B4\uC5ED \uC0C1\uC138 \uC870\uD68C");
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   setBounds(100, 100, 462, 437);
	   contentPane = new JPanel();
	   contentPane.setBackground(Color.WHITE);
	   contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	   setContentPane(contentPane);
	   contentPane.setLayout(null);

	   orderIdLabel = new JLabel("주문번호  :");
	   orderIdLabel.setBounds(71, 35, 72, 25);
	   contentPane.add(orderIdLabel);
	   orderIdLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

	   brandNameLabel = new JLabel("브 랜 드   : ");
	   brandNameLabel.setBounds(71, 75, 72, 25);
	   contentPane.add(brandNameLabel);
	   brandNameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

	   sumLabel = new JLabel("\uCD1D \uAC00\uACA9  :");
	   sumLabel.setHorizontalAlignment(SwingConstants.TRAILING);
	   sumLabel.setBounds(138, 341, 97, 25);
	   contentPane.add(sumLabel);
	   sumLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));

	   orderIdText = new JLabel();
	   orderIdText.setBounds(143, 37, 36, 21);
	   contentPane.add(orderIdText);
	   orderIdText.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

	   brandNameText = new JLabel("");
	   brandNameText.setBounds(143, 75, 82, 25);
	   contentPane.add(brandNameText);
	   brandNameText.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

	   sumText = new JLabel("");
	   sumText.setHorizontalAlignment(SwingConstants.TRAILING);
	   sumText.setBounds(238, 341, 120, 25);
	   contentPane.add(sumText);
	   sumText.setFont(new Font("맑은 고딕", Font.BOLD, 13));

	   scrollPane = new JScrollPane();
	   scrollPane.setBounds(71, 124, 316, 146);
	   contentPane.add(scrollPane);

	   DefaultTableModel model = new DefaultTableModel(data, columnNames) {
		   Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class };

		   public Class getColumnClass(int columnIndex) {
			   return columnTypes[columnIndex];
		   }

		   boolean[] columnEditables = new boolean[] { false, false, false };

		   public boolean isCellEditable(int row, int column) {
			   return columnEditables[column];
		   }
		};

		menuTable = new JTable(model);
		menuTable.setEnabled(false);
		menuTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(menuTable);

		wonLabel = new JLabel("원");
		wonLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		wonLabel.setBounds(364, 340, 23, 25);
		contentPane.add(wonLabel);

		deliveryFeeLabel = new JLabel("\uBC30\uB2EC\uB8CC   :");
		deliveryFeeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		deliveryFeeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		deliveryFeeLabel.setBounds(178, 311, 57, 25);
		contentPane.add(deliveryFeeLabel);

		wonLabel_1 = new JLabel("원");
		wonLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		wonLabel_1.setBounds(364, 311, 23, 25);
		contentPane.add(wonLabel_1);

		deliveryFeeText = new JLabel("");
		deliveryFeeText.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		deliveryFeeText.setHorizontalAlignment(SwingConstants.TRAILING);
		deliveryFeeText.setBounds(238, 311, 120, 25);
		contentPane.add(deliveryFeeText);

		menuTable.getColumnModel().getColumn(0).setPreferredWidth(400);
		menuTable.getColumnModel().getColumn(0).setResizable(false);
		menuTable.getColumnModel().getColumn(1).setPreferredWidth(80);
		menuTable.getColumnModel().getColumn(1).setResizable(false);
		menuTable.getColumnModel().getColumn(2).setPreferredWidth(80);
		menuTable.getColumnModel().getColumn(2).setResizable(false);
	}
}