package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import DAO.MyPageDAO;
import Models.Member;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MyPageForm extends JFrame {
	private int userId;
	private MyPageDAO myPageDao = MyPageDAO.getInstance();
	
	private JPanel contentPane, infoPanel;
	private JLabel idInfo, pwInfo, nameInfo, phoneInfo, sexInfo;
	private JLabel idLabel, pwLabel, nameLabel, phoneLabel, sexLabel;
	private JButton  btn_modifyPw, btn_deleteAccount;
	private JLabel imgLabel;

	/**
	 * Create the frame.
	 */
	public MyPageForm() {
		setForeground(Color.BLACK);
		
		init();
	}
	
	public MyPageForm(int userId, MainForm mainForm) {
		this.userId = userId;
		init();
		
		Member member = myPageDao.getMember(this.userId);
		idInfo.setText(member.getEmail());
		pwInfo.setText(member.getPassword());
		nameInfo.setText(member.getName());
		phoneInfo.setText(member.getPhone());
		sexInfo.setText(member.getSex());
		
		//ºñ¹Ð¹øÈ£ º¯°æ ¹öÆ° Å¬¸¯½Ã
		btn_modifyPw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String newPw = JOptionPane.showInputDialog("»õ ºñ¹Ð¹øÈ£¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
		
				if ( newPw != null && !newPw.equals("")) {
					if (newPw.length() <= 30) {
						int affectedRowCount = myPageDao.modifyPassword(userId, newPw);
						if (affectedRowCount != 0) {
							JOptionPane.showMessageDialog(null, "ºñ¹Ð¹øÈ£°¡ º¯°æµÇ¾ú½À´Ï´Ù.", "Confirm",
									JOptionPane.INFORMATION_MESSAGE);
							pwInfo.setText(newPw);
						}
					} 
					else {
						JOptionPane.showMessageDialog(null, "ºñ¹Ð¹øÈ£´Â 30ÀÚ ÀÌ³»·Î ÀÔ·ÂÇØ ÁÖ¼¼¿ä.", "Confirm",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		
		
		//È¸¿øÅ»Åð ¹öÆ° Å¬¸¯½Ã
		btn_deleteAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Å»Åð ÇÏ½Ã°Ú½À´Ï±î?", "Confirm", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) {
					int affectedRowCount = myPageDao.deleteAccount(userId);
					if(affectedRowCount != 0) {
						JOptionPane.showMessageDialog(null, "È¸¿ø Å»Åð°¡ ¿Ï·áµÇ¾ú½À´Ï´Ù.", "Confirm", JOptionPane.INFORMATION_MESSAGE);
						dispose(); //ÇöÀçÃ¢ ´Ý±â
						mainForm.dispose(); //MainForm´Ý±â
						
						LoginForm loginForm = new LoginForm();
						loginForm.setVisible(true);
					}
				}
			}
		});
	}


	public void init() {
		
		setTitle("\uB9C8\uC774 \uD398\uC774\uC9C0");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 479, 362);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		infoPanel = new JPanel();
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setLayout(null);
		infoPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uD68C\uC6D0 \uC815\uBCF4", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		infoPanel.setBounds(12, 22, 439, 240);
		infoPanel.setOpaque(false);
		contentPane.add(infoPanel);
		
		idLabel = new JLabel("id    :");
		idLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		idLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		idLabel.setBounds(55, 46, 34, 15);
		infoPanel.add(idLabel);
		
		idInfo = new JLabel();
		idInfo.setBackground(Color.LIGHT_GRAY);
		idInfo.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		idInfo.setBounds(101, 46, 208, 15);
		infoPanel.add(idInfo);
		
		pwLabel = new JLabel("pw  :");
		pwLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pwLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		pwLabel.setBounds(55, 77, 34, 15);
		infoPanel.add(pwLabel);
		
		pwInfo = new JLabel();
		pwInfo.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		pwInfo.setBounds(101, 77, 208, 15);
		infoPanel.add(pwInfo);
		
		nameLabel = new JLabel("\uC774\uB984 :");
		nameLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		nameLabel.setBounds(32, 114, 57, 15);
		infoPanel.add(nameLabel);
		
		nameInfo = new JLabel();
		nameInfo.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		nameInfo.setBounds(101, 114, 208, 15);
		infoPanel.add(nameInfo);
		
		phoneLabel = new JLabel("\uD734\uB300\uD3F0\uBC88\uD638 :");
		phoneLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		phoneLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		phoneLabel.setBounds(12, 149, 77, 15);
		infoPanel.add(phoneLabel);
		
		phoneInfo = new JLabel();
		phoneInfo.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		phoneInfo.setForeground(Color.BLACK);
		phoneInfo.setBounds(101, 149, 208, 15);
		infoPanel.add(phoneInfo);
		
		sexLabel = new JLabel("\uC131\uBCC4  :");
		sexLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		sexLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		sexLabel.setBounds(32, 187, 57, 15);
		infoPanel.add(sexLabel);
		
		sexInfo = new JLabel("");
		sexInfo.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		sexInfo.setBounds(101, 187, 208, 15);
		infoPanel.add(sexInfo);
		
		//btn_modifyPw = new JButton("\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD");
		btn_modifyPw = new JButton(new ImageIcon("./img/modifyPasswordButtonIcon.png"));
		btn_modifyPw.setBackground(Color.WHITE);
		btn_modifyPw.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		btn_modifyPw.setBounds(305, 73, 104, 36);
		btn_modifyPw.setBorderPainted(false);
		infoPanel.add(btn_modifyPw);
		
		imgLabel = new JLabel(new ImageIcon("./img/smallChickenIcon.png"));
		imgLabel.setBounds(55, -14, 57, 49);
		infoPanel.add(imgLabel);
		
		//btn_deleteAccount = new JButton("\uD68C\uC6D0 \uD0C8\uD1F4");
		btn_deleteAccount = new JButton(new ImageIcon("./img/deleteAccountButtonIcon.png"));
		btn_deleteAccount.setBackground(Color.WHITE);
		btn_deleteAccount.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		btn_deleteAccount.setBounds(181, 277, 104, 36);
		btn_deleteAccount.setBorderPainted(false);	//¹öÆ° ¹Ù¿î´õ¸® ¾ø¾Ö±â
		contentPane.add(btn_deleteAccount);
	}
}
