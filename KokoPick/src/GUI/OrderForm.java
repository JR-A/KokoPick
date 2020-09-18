package GUI;

import DAO.*;
import Models.Menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class OrderForm extends JFrame{
	private OrderDAO orderDao = OrderDAO.getInstance();
	private int userId;
	
	private Common common = Common.getInstance();
	
	private JPanel contentPane;
	private final ButtonGroup brandButtonGroup = new ButtonGroup();
	private JRadioButton brandName1,brandName2,brandName3,brandName4,brandName5,brandName6;
	private JButton btn_select;
	private JPanel brandSelectPanel;
	
	private final String[] columnNames = {"�޴�","ī�װ�","����"};
	private Object[][] data = {};
	private static JTable menuTable;
	private JScrollPane tableScrollPane;
	
	private JPanel deliveryPanel;
	private final ButtonGroup deliveryButtonGroup = new ButtonGroup();
	private JRadioButton deleveryYesRadioButton, deleveryNoRadioButton;
	
	private JButton btn_order;
	private JLabel lblNewLabel;
	private JLabel imgLabel2;
	private JLabel imgLabel1;
	
	/**
	 * Create the frame.
	 */
	//������
	public OrderForm() {
		init();
	}
	
	public OrderForm(int userId) {
		this.userId = userId;
		//�⺻ ȭ�� ����
		init();
		//������ư�� �귣���̸� ����
		setBrandNames();
		
		//�����ϱ� ��ư Ŭ����
		btn_select.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedBrandText=common.getSelectedButtonText(brandButtonGroup);
				
				if(selectedBrandText != null) {
					Vector<Menu> menus = orderDao.getAllMenus(selectedBrandText);
					Iterator<Menu> iterator = menus.iterator();
					//���̺��� model ��������
					DefaultTableModel model = (DefaultTableModel)menuTable.getModel();
					//���̺� �ʱ�ȭ
					model.setNumRows(0);
					
					while(iterator.hasNext()) {
						Menu menu = iterator.next();
						String category = categoryNumToString(menu.getCategory());
						//�𵨿� ������ �߰�
						model.addRow(new Object[] {menu.getName(),category,menu.getPrice()});
						menuTable.updateUI();
					}
				}
				
			}
		});
		
		
		//�ֹ��ϱ� ��ư Ŭ����
		btn_order.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedBrandText = common.getSelectedButtonText(brandButtonGroup);
				String selectedDeliveryText = common.getSelectedButtonText(deliveryButtonGroup);
				StringBuilder menu = new StringBuilder(); // ���õ� menu���� �� ���� �ؽ�Ʈ�� ������
				int price = 0; // ���õ� ���� �����÷� �� ��� ���� ��
				int deliveryFlag = 1;
				int brandId = 0;
				int deliveryFee = 3000;

				// ���̺��� ���õ� ���� ����, ���õ� ���� ��ȣ �迭 ��������
				int selectedRowCnt = menuTable.getSelectedRowCount();
				int[] selectedRows = menuTable.getSelectedRows();

				if (selectedRowCnt != 0) {
					// ���õ� �޴����� �� ��¥�� ���ڿ��� ������
					for (int i = 0; i < selectedRowCnt; i++) {
						menu.append(menuTable.getValueAt(selectedRows[i], 0));
						menu.append("1"); // �޴����ڿ� ���̿� '����'�� ',' �߰�
						if (i != selectedRowCnt - 1) { // �� �������� ',' �߰� ���� �ʵ���
							menu.append(",");
						}

						//���� ���ϱ�
						price = price + (int) (menuTable.getValueAt(selectedRows[i], 2));
					}

					//delivery ���� ��ư�� �ؽ�Ʈ�� Ȯ���Ͽ� deliveryFlag�� ����
					if (selectedDeliveryText != null) {
						if (selectedDeliveryText != "��޽�Ű��") {
							deliveryFlag = 0;
						}
					}

					//deliveryFlag���� ���� ��޺� ����
					if (deliveryFlag == 0) {
						deliveryFee = 0;
					}

					//brandName ���� ��ư�� �ؽ�Ʈ�� brandId ��������
					if (selectedBrandText != null) {
						brandId = orderDao.getBrandId(selectedBrandText);
					}

					//�ֹ��ϱ�
					if (selectedBrandText != null && selectedDeliveryText != null) {
						//�ֹ� �����ϸ�
						if (orderDao.order(menu.toString(), price, deliveryFlag, deliveryFee, brandId, userId)) {
							//�˸�â����
							JOptionPane.showMessageDialog(null, "�ֹ��� �Ϸ� �Ǿ����ϴ�.", "�ֹ� Ȯ��", JOptionPane.PLAIN_MESSAGE);
							dispose();
						}
					}
				}
				//���̺��� ���� �ϳ��� �������� �ʾ��� ���
				else {
					JOptionPane.showMessageDialog(null, "�귣�带 ������ �� �޴��� �������ּ���.", "����", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
	}
	
	//ī�װ� ��ȣ�� ���ڿ��� �ٲٱ�
	public String categoryNumToString(int categoryNumber) {
		String category = null;
		if(categoryNumber == 0) {
			category = "�ָ޴�";
		}
		else if(categoryNumber == 1) {
			category = "���̵�޴�";
		}
		else if(categoryNumber == 2) {
			category = "����";
		}
		return category;
	}
	
	
	//���� ��ư�� �귣�� �̸� ����
	public void setBrandNames() {
		OrderDAO orderDao = OrderDAO.getInstance();
		Vector<String> brandNames = orderDao.getAllBrands();
		
		//brand�̸� ��������
		brandName1.setText(brandNames.firstElement());
		brandName2.setText(brandNames.get(1));
		brandName3.setText(brandNames.get(2));
		brandName4.setText(brandNames.get(3));
		brandName5.setText(brandNames.get(4));
		brandName6.setText(brandNames.get(5));
	}
	
	public void init() {
		setTitle("\uC8FC\uBB38\uD558\uAE30");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 482, 547);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		brandSelectPanel = new JPanel();
		brandSelectPanel.setBackground(Color.WHITE);
		brandSelectPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uBE0C\uB79C\uB4DC \uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		brandSelectPanel.setBounds(12, 24, 442, 141);
		brandSelectPanel.setOpaque(false);
		contentPane.add(brandSelectPanel);
		brandSelectPanel.setLayout(null);
		
		brandName1 = new JRadioButton("New label");
		brandName1.setBackground(Color.WHITE);
		brandName1.setSelected(true);
		brandName1.setFont(new Font("���� ���", Font.PLAIN, 13));
		brandName1.setBounds(8, 27, 90, 15);
		brandSelectPanel.add(brandName1);
		brandButtonGroup.add(brandName1);
		
		brandName2 = new JRadioButton("New label");
		brandName2.setBackground(Color.WHITE);
		brandName2.setFont(new Font("���� ���", Font.PLAIN, 13));
		brandName2.setBounds(163, 27, 97, 15);
		brandSelectPanel.add(brandName2);
		brandButtonGroup.add(brandName2);
		
		brandName3 = new JRadioButton("New label");
		brandName3.setBackground(Color.WHITE);
		brandName3.setFont(new Font("���� ���", Font.PLAIN, 13));
		brandName3.setBounds(331, 27, 103, 15);
		brandSelectPanel.add(brandName3);
		brandButtonGroup.add(brandName3);
		
		brandName4 = new JRadioButton("New label");
		brandName4.setBackground(Color.WHITE);
		brandName4.setFont(new Font("���� ���", Font.PLAIN, 13));
		brandName4.setBounds(8, 55, 90, 15);
		brandSelectPanel.add(brandName4);
		brandButtonGroup.add(brandName4);
		
		brandName5 = new JRadioButton("New label");
		brandName5.setBackground(Color.WHITE);
		brandName5.setFont(new Font("���� ���", Font.PLAIN, 13));
		brandName5.setBounds(163, 55, 97, 15);
		brandSelectPanel.add(brandName5);
		brandButtonGroup.add(brandName5);
		
		//btn_select = new JButton("\uC120\uD0DD\uD558\uAE30");
		btn_select = new JButton(new ImageIcon("./img/selectButtonIcon.png"));
		btn_select.setBackground(Color.WHITE);
		btn_select.setFont(new Font("���� ���", Font.PLAIN, 13));
		btn_select.setBounds(157, 95, 103, 36);
		btn_select.setBorderPainted(false);	//��ư �ٿ���� ���ֱ�
		brandSelectPanel.add(btn_select);
		
		brandName6 = new JRadioButton("\uAD7D\uB124\uCE58\uD0A8");
		brandName6.setBackground(Color.WHITE);
		brandName6.setFont(new Font("���� ���", Font.PLAIN, 13));
		brandButtonGroup.add(brandName6);
		brandName6.setBounds(331, 55, 97, 15);
		brandSelectPanel.add(brandName6);
		
		tableScrollPane = new JScrollPane();
		tableScrollPane.setBounds(12, 175, 442, 169);
		contentPane.add(tableScrollPane);
		
		
		//�𵨰� ������ ����
		DefaultTableModel model = new DefaultTableModel(data, columnNames){
			Class[] columnTypes = new Class[] {
					String.class, String.class, Integer.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		
		//model�� �Ű������� ���̺� ����
		menuTable = new JTable(model);
		menuTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		menuTable.setSurrendersFocusOnKeystroke(true);
		menuTable.setFont(new Font("�������", Font.PLAIN, 12));
		tableScrollPane.setViewportView(menuTable);
		
		deliveryPanel = new JPanel();
		deliveryPanel.setBackground(Color.WHITE);
		deliveryPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uBC30\uB2EC\uC5EC\uBD80", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		deliveryPanel.setBounds(12, 364, 442, 65);
		deliveryPanel.setOpaque(false);
		contentPane.add(deliveryPanel);
		deliveryPanel.setLayout(null);
		
		deleveryYesRadioButton = new JRadioButton("\uBC30\uB2EC\uC2DC\uD0A4\uAE30");
		deleveryYesRadioButton.setBackground(Color.WHITE);
		deleveryYesRadioButton.setSelected(true);
		deleveryYesRadioButton.setBounds(100, 28, 103, 23);
		deliveryPanel.add(deleveryYesRadioButton);
		deliveryButtonGroup.add(deleveryYesRadioButton);
		deleveryYesRadioButton.setFont(new Font("���� ���", Font.PLAIN, 12));
		
		deleveryNoRadioButton = new JRadioButton("\uB9E4\uC7A5\uC2DD\uC0AC/\uD14C\uC774\uD06C\uC544\uC6C3");
		deleveryNoRadioButton.setBackground(Color.WHITE);
		deleveryNoRadioButton.setBounds(228, 28, 150, 23);
		deliveryPanel.add(deleveryNoRadioButton);
		deliveryButtonGroup.add(deleveryNoRadioButton);
		deleveryNoRadioButton.setFont(new Font("���� ���", Font.PLAIN, 12));
		
		//btn_order = new JButton("\uC8FC\uBB38\uD558\uAE30");
		btn_order = new JButton(new ImageIcon("./img/orderButtonIcon2.png"));
		btn_order.setBackground(Color.WHITE);
		btn_order.setFont(new Font("���� ���", Font.PLAIN, 14));
		btn_order.setBounds(161, 462, 140, 36);
		btn_order.setBorderPainted(false);	//��ư �ٿ���� ���ֱ�
		contentPane.add(btn_order);
		
	
		//���̺� ���� �÷�ũ��,�÷� resizable���� ����
		menuTable.getColumnModel().getColumn(0).setResizable(false);
		menuTable.getColumnModel().getColumn(0).setPreferredWidth(328);
		menuTable.getColumnModel().getColumn(1).setResizable(false);
		menuTable.getColumnModel().getColumn(1).setPreferredWidth(110);
		menuTable.getColumnModel().getColumn(2).setResizable(false);
		menuTable.getColumnModel().getColumn(2).setPreferredWidth(129);
		
	}
}

