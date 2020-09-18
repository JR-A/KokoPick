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
   
    private final String[] columnNames = { "�ֹ���ȣ", "�޴��̸�", "����" };
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
      
      //����ϱ� ��ư Ŭ����
		btn_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CancelDAO cancelDao = CancelDAO.getInstance();
				// ���̺��� ���õ� ���� ��ȣ ��������
				int[] selectedRows = ordersTable.getSelectedRows();
				
				//���õ� ���� ������ 0�� �ƴѰ��
				if (selectedRows.length != 0) {
					int orderId = (int) ordersTable.getValueAt(selectedRows[0], 0);

					// ������� �ֹ� ��� �ǻ� Ȯ��
					int result = JOptionPane.showConfirmDialog(null, "��� �Ͻðڽ��ϱ�?", "Confirm", JOptionPane.YES_NO_OPTION);
					
					// ����ڰ� "��"��ư�� ������ ���
					if (result == JOptionPane.YES_OPTION) {
						// �ֹ� ����ϱ�
						int affectedRowCount = cancelDao.cancel(orderId);
						if (affectedRowCount >= 1) {
							JOptionPane.showMessageDialog(null, "�ֹ���ȣ " + orderId + " ��� �Ϸ�Ǿ����ϴ�.", "Confirm",
									JOptionPane.INFORMATION_MESSAGE);
							
							//���̺� ���ΰ�ħ
							showOrderList();
						}	
					} 
				} 
				else {
					JOptionPane.showMessageDialog(null, "����� �ֹ��� ���� ������ �ּ���.", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}

		});
   }
   
   //�ֹ����� �����ֱ�
   public void showOrderList() {
	   CancelDAO cancelDao = CancelDAO.getInstance();
	   Vector<Order> orderList = cancelDao.getAllOrders(userId);
	   Iterator<Order> iterator = orderList.iterator();
	   
	   DefaultTableModel model = (DefaultTableModel)ordersTable.getModel();
	   model.setNumRows(0); // ���̺� �ʱ�ȭ
	   
	   while(iterator.hasNext()) {
		   Order order = iterator.next();
		   model.addRow(new Object[] {order.getOrderId(), order.getMenu(), order.getPrice()+order.getDeliveryFee()});   
	   }
	   ordersTable.updateUI(); //���̺� ����
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
		btn_cancel.setFont(new Font("���� ���", Font.PLAIN, 12));
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