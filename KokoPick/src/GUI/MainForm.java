package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class MainForm extends JFrame {
	private int userId;
	private JPanel contentPane;
	private JLabel title, imageLabel;
	private JPanel mainPanel;
	private JButton btn_Order, btn_Cancel, btn_Search, btn_logOut;
	private JButton btn_myPage;
	

	/*
	 * Create the frame.
	 */
	public MainForm() {
		setBackground(Color.ORANGE);
		setForeground(Color.ORANGE);
		init();
	}
	
	public MainForm(int userId) {
		this.userId = userId;
		
		init();
		
		//주문하기 버튼 클릭시
		btn_Order.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				OrderForm orderForm = new OrderForm(userId);
				orderForm.setVisible(true);
			}
		});
		
		//주문취소 버튼 클릭시
		btn_Cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CancelForm orderCancelForm = new CancelForm(userId);
				orderCancelForm.setVisible(true);
			}
		});
		
		//주문조회 버튼 클릭시
		btn_Search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchForm searchForm = new SearchForm(userId);
				searchForm.setVisible(true);
			}
		});
		
		//마이페이지 버튼 클릭시
		btn_myPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MyPageForm myPageForm = new MyPageForm(userId, MainForm.this);
				myPageForm.setVisible(true);
			}
		});
		
		//로그아웃 버튼 클릭시
		btn_logOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginForm loginForm = new LoginForm();
				loginForm.setVisible(true);
				
				setVisible(false);
			}
		});
	}
	
	private void init() {
		setTitle("\uAF2C\uAF2C\uD53D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 544);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//title = new JLabel("KOKOPICK");
		title = new JLabel(new ImageIcon("./img/logo.png"));
		//title.setOpaque(false);    //배경투명하게하기
		//title.setForeground(Color.WHITE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		//title.setFont(new Font("Arial Black", Font.PLAIN, 46));
		title.setBounds(89, 80, 442, 99);
		contentPane.add(title);
		
		mainPanel = new JPanel();
		mainPanel.setOpaque(false);		//배경투명하게하기
		mainPanel.setBounds(-11, 0, 625, 505);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		//btn_Order = new JButton("\uC8FC\uBB38\uD558\uAE30");
		btn_Order = new JButton(new ImageIcon("./img/orderButtonIcon.png"));
		btn_Order.setOpaque(false);
		btn_Order.setText("\uC8FC\uBB38\uD558\uAE30");
		btn_Order.setForeground(Color.BLACK);
		btn_Order.setBackground(Color.ORANGE);
		//btn_Order.setBackground(Color.WHITE);
		//btn_Order.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_Order.setBounds(167, 220, 286, 74);
		btn_Order.setBorderPainted(false);
		mainPanel.add(btn_Order);
		
		//btn_Cancel = new JButton("\uC8FC\uBB38\uCDE8\uC18C");
		btn_Cancel = new JButton(new ImageIcon("./img/cancelButtonIcon.png"));
		btn_Cancel.setOpaque(false); // 배경투명하게하기
		btn_Cancel.setText("\uC8FC\uBB38\uCDE8\uC18C");
		btn_Cancel.setForeground(Color.BLACK);
		btn_Cancel.setBackground(Color.ORANGE);
		btn_Cancel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_Cancel.setBounds(167, 304, 286, 74);
		btn_Cancel.setBorderPainted(false);
		mainPanel.add(btn_Cancel);
		
		//btn_Search = new JButton("\uC8FC\uBB38\uC870\uD68C");
		btn_Search = new JButton(new ImageIcon("./img/searchButtonIcon.png"));
		btn_Search.setOpaque(false); // 배경투명하게하기
		btn_Search.setText("\uC8FC\uBB38\uC870\uD68C");
		btn_Search.setBackground(Color.ORANGE);
		btn_Search.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_Search.setBounds(167, 388, 286, 74);
		btn_Search.setBorderPainted(false);	//버튼 바운더리 없애기
		mainPanel.add(btn_Search);
		
		imageLabel = new JLabel("");
		imageLabel.setBounds(-100, 106, 758, 399);
		mainPanel.add(imageLabel);
		imageLabel.setIcon(new ImageIcon("./img/chickenImogiIcon2.png"));
		
		//btn_logOut = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btn_logOut = new JButton(new ImageIcon("./img/logOutButtonIcon.png"));
		btn_logOut.setBackground(Color.ORANGE);
		btn_logOut.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_logOut.setBounds(489, 10, 113, 36);
		btn_logOut.setBorderPainted(false);
		contentPane.add(btn_logOut);
		
		//btn_myPage = new JButton("\uB9C8\uC774\uD398\uC774\uC9C0");
		btn_myPage = new JButton(new ImageIcon("./img/myPageButtonIcon.png"));
		btn_myPage.setForeground(Color.BLACK);
		btn_myPage.setBackground(Color.ORANGE);
		btn_myPage.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_myPage.setBounds(374, 10, 113, 36);
		btn_myPage.setBorderPainted(false);
		contentPane.add(btn_myPage);
	}
}
