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
	
	private final String[] columnNames = {"메뉴","카테고리","가격"};
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
	//생성자
	public OrderForm() {
		init();
	}
	
	public OrderForm(int userId) {
		this.userId = userId;
		//기본 화면 세팅
		init();
		//라디오버튼에 브랜드이름 세팅
		setBrandNames();
		
		//선택하기 버튼 클릭시
		btn_select.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedBrandText=common.getSelectedButtonText(brandButtonGroup);
				
				if(selectedBrandText != null) {
					Vector<Menu> menus = orderDao.getAllMenus(selectedBrandText);
					Iterator<Menu> iterator = menus.iterator();
					//테이블의 model 가져오기
					DefaultTableModel model = (DefaultTableModel)menuTable.getModel();
					//테이블 초기화
					model.setNumRows(0);
					
					while(iterator.hasNext()) {
						Menu menu = iterator.next();
						String category = categoryNumToString(menu.getCategory());
						//모델에 데이터 추가
						model.addRow(new Object[] {menu.getName(),category,menu.getPrice()});
						menuTable.updateUI();
					}
				}
				
			}
		});
		
		
		//주문하기 버튼 클릭시
		btn_order.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedBrandText = common.getSelectedButtonText(brandButtonGroup);
				String selectedDeliveryText = common.getSelectedButtonText(deliveryButtonGroup);
				StringBuilder menu = new StringBuilder(); // 선택된 menu들을 한 줄의 텍스트로 포맷팅
				int price = 0; // 선택된 행의 가격컬럼 값 모두 더한 값
				int deliveryFlag = 1;
				int brandId = 0;
				int deliveryFee = 3000;

				// 테이블의 선택된 행의 개수, 선택된 행의 번호 배열 가져오기
				int selectedRowCnt = menuTable.getSelectedRowCount();
				int[] selectedRows = menuTable.getSelectedRows();

				if (selectedRowCnt != 0) {
					// 선택된 메뉴들을 한 줄짜리 문자열로 포맷팅
					for (int i = 0; i < selectedRowCnt; i++) {
						menu.append(menuTable.getValueAt(selectedRows[i], 0));
						menu.append("1"); // 메뉴문자열 사이에 '수량'과 ',' 추가
						if (i != selectedRowCnt - 1) { // 맨 마지막엔 ',' 추가 되지 않도록
							menu.append(",");
						}

						//가격 더하기
						price = price + (int) (menuTable.getValueAt(selectedRows[i], 2));
					}

					//delivery 라디오 버튼의 텍스트를 확인하여 deliveryFlag값 설정
					if (selectedDeliveryText != null) {
						if (selectedDeliveryText != "배달시키기") {
							deliveryFlag = 0;
						}
					}

					//deliveryFlag값에 따라 배달비 설정
					if (deliveryFlag == 0) {
						deliveryFee = 0;
					}

					//brandName 라디오 버튼의 텍스트로 brandId 가져오기
					if (selectedBrandText != null) {
						brandId = orderDao.getBrandId(selectedBrandText);
					}

					//주문하기
					if (selectedBrandText != null && selectedDeliveryText != null) {
						//주문 성공하면
						if (orderDao.order(menu.toString(), price, deliveryFlag, deliveryFee, brandId, userId)) {
							//알림창띄우기
							JOptionPane.showMessageDialog(null, "주문이 완료 되었습니다.", "주문 확인", JOptionPane.PLAIN_MESSAGE);
							dispose();
						}
					}
				}
				//테이블의 행을 하나도 선택하지 않았을 경우
				else {
					JOptionPane.showMessageDialog(null, "브랜드를 선택한 후 메뉴를 선택해주세요.", "오류", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
	}
	
	//카테고리 번호를 문자열로 바꾸기
	public String categoryNumToString(int categoryNumber) {
		String category = null;
		if(categoryNumber == 0) {
			category = "주메뉴";
		}
		else if(categoryNumber == 1) {
			category = "사이드메뉴";
		}
		else if(categoryNumber == 2) {
			category = "음료";
		}
		return category;
	}
	
	
	//라디오 버튼에 브랜드 이름 세팅
	public void setBrandNames() {
		OrderDAO orderDao = OrderDAO.getInstance();
		Vector<String> brandNames = orderDao.getAllBrands();
		
		//brand이름 가져오기
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
		brandName1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		brandName1.setBounds(8, 27, 90, 15);
		brandSelectPanel.add(brandName1);
		brandButtonGroup.add(brandName1);
		
		brandName2 = new JRadioButton("New label");
		brandName2.setBackground(Color.WHITE);
		brandName2.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		brandName2.setBounds(163, 27, 97, 15);
		brandSelectPanel.add(brandName2);
		brandButtonGroup.add(brandName2);
		
		brandName3 = new JRadioButton("New label");
		brandName3.setBackground(Color.WHITE);
		brandName3.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		brandName3.setBounds(331, 27, 103, 15);
		brandSelectPanel.add(brandName3);
		brandButtonGroup.add(brandName3);
		
		brandName4 = new JRadioButton("New label");
		brandName4.setBackground(Color.WHITE);
		brandName4.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		brandName4.setBounds(8, 55, 90, 15);
		brandSelectPanel.add(brandName4);
		brandButtonGroup.add(brandName4);
		
		brandName5 = new JRadioButton("New label");
		brandName5.setBackground(Color.WHITE);
		brandName5.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		brandName5.setBounds(163, 55, 97, 15);
		brandSelectPanel.add(brandName5);
		brandButtonGroup.add(brandName5);
		
		//btn_select = new JButton("\uC120\uD0DD\uD558\uAE30");
		btn_select = new JButton(new ImageIcon("./img/selectButtonIcon.png"));
		btn_select.setBackground(Color.WHITE);
		btn_select.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		btn_select.setBounds(157, 95, 103, 36);
		btn_select.setBorderPainted(false);	//버튼 바운더리 없애기
		brandSelectPanel.add(btn_select);
		
		brandName6 = new JRadioButton("\uAD7D\uB124\uCE58\uD0A8");
		brandName6.setBackground(Color.WHITE);
		brandName6.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		brandButtonGroup.add(brandName6);
		brandName6.setBounds(331, 55, 97, 15);
		brandSelectPanel.add(brandName6);
		
		tableScrollPane = new JScrollPane();
		tableScrollPane.setBounds(12, 175, 442, 169);
		contentPane.add(tableScrollPane);
		
		
		//모델과 데이터 연결
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
		
		//model을 매개변수로 테이블 생성
		menuTable = new JTable(model);
		menuTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		menuTable.setSurrendersFocusOnKeystroke(true);
		menuTable.setFont(new Font("나눔고딕", Font.PLAIN, 12));
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
		deleveryYesRadioButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		deleveryNoRadioButton = new JRadioButton("\uB9E4\uC7A5\uC2DD\uC0AC/\uD14C\uC774\uD06C\uC544\uC6C3");
		deleveryNoRadioButton.setBackground(Color.WHITE);
		deleveryNoRadioButton.setBounds(228, 28, 150, 23);
		deliveryPanel.add(deleveryNoRadioButton);
		deliveryButtonGroup.add(deleveryNoRadioButton);
		deleveryNoRadioButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		//btn_order = new JButton("\uC8FC\uBB38\uD558\uAE30");
		btn_order = new JButton(new ImageIcon("./img/orderButtonIcon2.png"));
		btn_order.setBackground(Color.WHITE);
		btn_order.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btn_order.setBounds(161, 462, 140, 36);
		btn_order.setBorderPainted(false);	//버튼 바운더리 없애기
		contentPane.add(btn_order);
		
	
		//테이블 모델의 컬럼크기,컬럼 resizable여부 설정
		menuTable.getColumnModel().getColumn(0).setResizable(false);
		menuTable.getColumnModel().getColumn(0).setPreferredWidth(328);
		menuTable.getColumnModel().getColumn(1).setResizable(false);
		menuTable.getColumnModel().getColumn(1).setPreferredWidth(110);
		menuTable.getColumnModel().getColumn(2).setResizable(false);
		menuTable.getColumnModel().getColumn(2).setPreferredWidth(129);
		
	}
}

