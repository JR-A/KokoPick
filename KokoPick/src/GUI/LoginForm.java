package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

import DAO.LoginDAO;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class LoginForm extends JFrame {
	private Common common = Common.getInstance();
	
	private JPanel contentPane;
	private JTextField idField;
	private JLabel atLabel;
	@SuppressWarnings("rawtypes")
	private JComboBox emailCombo;
	private String emailComboData[]={"gmail.com","naver.com","yahoo.com", "hanmail.net"};
	private JPasswordField passwordField;
	private JButton btn_login, btn_join;
	private JLabel idLabel;
	private JLabel pwLabel;
	private JPanel infoPanel;
	private JLabel loginMessage;
	private JLabel imgLabel;

	/*
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 */
	public LoginForm() {
		 
		
		init();
		
		//�α��� ��ư Ŭ����
		btn_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginDAO loginDao = LoginDAO.getInstance();
				
				// id�� password �ԷµǾ����� Ȯ��
				if (!idField.getText().isEmpty() && passwordField.getPassword().length != 0) {
					//�̸��� ������ �ϳ��� String������ġ��
					String email = common.getEmailString(idField.getText(), emailCombo.getSelectedItem().toString());
					String password = new String(passwordField.getPassword());
					int userId;

					// �α��� ������ userId ��������
					userId = loginDao.login(email, password);
					
					//�α��� ������
					if(userId!=-1) {
						// mainForm�� �Ű������� userId �ѱ��
						MainForm mainForm = new MainForm(userId);
						mainForm.setVisible(true);
						
						// ����â(�α���â) �ݱ�
						dispose();
					}
					//�α��� ���н�
					else{
						// �˸�â ����
						loginMessage.setForeground(Color.RED);
						loginMessage.setText("*���̵� Ȥ�� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
					}
					
				} else {
					// ������ �����Ǿ����� �˸�â����
					loginMessage.setForeground(Color.RED);
					loginMessage.setText("*���̵� Ȥ�� ��й�ȣ�� �Էµ��� �ʾҽ��ϴ�.");
				}

			}
		});
		
		//ȸ������ ��ư Ŭ����
		btn_join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JoinForm joinForm = new JoinForm();
				joinForm.setVisible(true);
			}
		});
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void init() {
		setTitle("\uB85C\uADF8\uC778");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 264);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		infoPanel = new JPanel();
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uD68C\uC6D0 \uC815\uBCF4 \uC785\uB825", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		infoPanel.setBounds(16, 17, 327, 139);
		infoPanel.setOpaque(false);
		contentPane.add(infoPanel);
		infoPanel.setLayout(null);
		
		idField = new JTextField();
		idField.setFont(new Font("���� ���", Font.PLAIN, 12));
		idField.setBounds(58, 36, 101, 21);
		infoPanel.add(idField);
		idField.setColumns(10);
		
		atLabel = new JLabel("@");
		atLabel.setFont(new Font("���� ���", Font.PLAIN, 12));
		atLabel.setBounds(165, 36, 18, 21);
		infoPanel.add(atLabel);
		
		emailCombo = new JComboBox(emailComboData);
		emailCombo.setBackground(Color.LIGHT_GRAY);
		emailCombo.setFont(new Font("���� ���", Font.PLAIN, 12));
		emailCombo.setBounds(184, 36, 123, 21);
		infoPanel.add(emailCombo);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("���� ���", Font.PLAIN, 12));
		passwordField.setBounds(58, 67, 249, 21);
		infoPanel.add(passwordField);
		passwordField.setColumns(10);
		
		idLabel = new JLabel("id :");
		idLabel.setFont(new Font("���� ���", Font.PLAIN, 12));
		idLabel.setBounds(12, 36, 34, 15);
		infoPanel.add(idLabel);
		
		pwLabel = new JLabel("pw :");
		pwLabel.setFont(new Font("���� ���", Font.PLAIN, 12));
		pwLabel.setBounds(12, 67, 34, 15);
		infoPanel.add(pwLabel);
		
		loginMessage = new JLabel("");
		loginMessage.setForeground(Color.RED);
		loginMessage.setBounds(12, 105, 295, 15);
		infoPanel.add(loginMessage);
		
		imgLabel = new JLabel(new ImageIcon("./img/smallChickenIcon.png"));
		imgLabel.setBounds(77, -16, 57, 52);
		infoPanel.add(imgLabel);
		
		//btn_login = new JButton("\uB85C\uADF8\uC778");
		btn_login = new JButton(new ImageIcon("./img/loginButtonIcon.png"));
		btn_login.setBackground(Color.WHITE);
		btn_login.setFont(new Font("���� ���", Font.PLAIN, 12));
		btn_login.setBounds(239, 179, 104, 36);
		btn_login.setBorderPainted(false);
		contentPane.add(btn_login);
		
		//btn_signin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btn_join = new JButton(new ImageIcon("./img/joinButtonIcon.png"));
		btn_join.setBackground(Color.WHITE);
		btn_join.setFont(new Font("���� ���", Font.PLAIN, 12));
		btn_join.setBounds(130, 179, 104, 36);
		btn_join.setBorderPainted(false);	//��ư �ٿ���� ���ֱ�
		contentPane.add(btn_join);
	}
}
