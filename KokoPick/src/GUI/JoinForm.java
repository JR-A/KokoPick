package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import DAO.JoinDAO;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class JoinForm extends JFrame {
	private Common common = Common.getInstance();
	
	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField passwordField;
	private JPanel infoPanel;
	private JLabel atLabel, dashLabel, dashLabel2, lbNumber, nameLabel;
	private JComboBox emailCombo;
	private JLabel idLabel;
	private JLabel pwLabel;
	private String emailComboData[]={"gmail.com","naver.com","yahoo.com", "hanmail.net"};
	private final ButtonGroup sexButtonGroup = new ButtonGroup();
	private JPanel sexPanel;
	private JRadioButton maleRadioButton, femaleRadioButton;
	private JButton btn_join, btn_checkDuplicate;
	private JLabel idMessage, passwordMessage;
	private JTextField nameField, phoneField1, phoneField2, phoneField3;
	private JLabel phoneMessage;
	private JLabel nameMessage;
	
	private boolean checkDuplicateFlag = false;

	
	/**
	 * Create the frame.
	 */
	public JoinForm() {
		init();
		
		//�ߺ�Ȯ�� ��ư Ŭ����
		btn_checkDuplicate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JoinDAO joinDao = JoinDAO.getInstance();
				String email;
				
				//���̵� ������ �ƴѰ�쿡�� �ߺ�Ȯ�� ����
				if(!idField.getText().isEmpty()) {
					// �̸��� ������ �ϳ��� String������ġ��
					email = common.getEmailString(idField.getText(), emailCombo.getSelectedItem().toString());
					
					checkDuplicateFlag = joinDao.checkDuplicate(email);
					
					//�ߺ�Ȯ�� ������
					if(checkDuplicateFlag) {
						idMessage.setForeground(Color.GREEN);
						idMessage.setText("��� ������ ���̵� �Դϴ�.");
						
						int result = JOptionPane.showConfirmDialog(null, "�� ���̵� ����Ͻðڽ��ϱ�?", "Confirm", JOptionPane.YES_NO_OPTION);
						if(result == JOptionPane.YES_OPTION) {
							idField.setEditable(false);
							btn_checkDuplicate.setEnabled(false);
						}
						else {
							checkDuplicateFlag = false;
						}
					}
					//�ߺ�Ȯ�� ���н�
					else{	
						idMessage.setForeground(Color.RED);
						idMessage.setText("*�̹� �����ϴ� ���̵� �Դϴ�.");
					}
				}
				//���̵� ������ ���
				else {
					idMessage.setForeground(Color.RED);
					idMessage.setText("*���̵� �Է��ϼ���.");
				}
			}
		});
		
		//phoneField Ŭ���� �ʱ�ȭ
		phoneField1.addMouseListener(new MouseAdapter() {
			 @Override
             public void mouseClicked(MouseEvent e){
				 phoneField1.setForeground(Color.BLACK);
				 phoneField1.setText("");
             }
		});
		phoneField2.addMouseListener(new MouseAdapter() {
			 @Override
            public void mouseClicked(MouseEvent e){
				 phoneField2.setForeground(Color.BLACK);
				 phoneField2.setText("");
            }
		});
		phoneField3.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e){
				 phoneField3.setForeground(Color.BLACK);
				 phoneField3.setText("");
            }
		});
		
		//�����ϱ� ��ư Ŭ����
		btn_join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				JoinDAO joinDao = JoinDAO.getInstance();
				String sex, email, password, name = null, phone = null;
				int rowCount;
				int length1 = phoneField1.getText().length();
				int length2 = phoneField2.getText().length();
				int length3 = phoneField3.getText().length();
				idMessage.setText("");
				passwordMessage.setText("");
				nameMessage.setText("");
				phoneMessage.setText("");

				// ��� ���� ������ ���
				if (checkDuplicateFlag == true && passwordField.getPassword().length != 0
						&& nameField.getText().length() != 0 && (length1 == 3 && length2 == 4 && length3 == 4)) {
					// �̸��� ������ �ϳ��� String������ġ��
					email = common.getEmailString(idField.getText(), emailCombo.getSelectedItem().toString());
					password = new String(passwordField.getPassword());

					// ���õ� ���� ��ư�� �ؽ�Ʈ ��������
					sex = common.getSelectedButtonText(sexButtonGroup);
					if (sex == "����") sex = "Male";
					else sex = "Female";

					// �̸���������
					name = nameField.getText();

					// �޴�����ȣ ��������
					phone = putTogetherPhone(phoneField1.getText(), phoneField2.getText(), phoneField3.getText());
					// ȸ�������ϱ�
					rowCount = joinDao.join(sex, email, password, name, phone);
					if (rowCount == 1) {
						JOptionPane.showMessageDialog(null, "ȸ�� ������ �Ϸ�Ǿ����ϴ�", "Confirm", JOptionPane.PLAIN_MESSAGE);
						dispose();
					}
				}
				// �ߺ���ȸ �Ϸ���� �������
				else if (checkDuplicateFlag == false) {
					idMessage.setForeground(Color.RED);
					idMessage.setText("*���̵� �ߺ���ȸ�� ���ּ���.");
				}
				// �ߺ���ȸ ������ ���������� �������� ���� ��� 
				else {
					if (passwordField.getPassword().length == 0) {
						passwordMessage.setForeground(Color.RED);
						passwordMessage.setText("*��й�ȣ�� �Էµ��� �ʾҽ��ϴ�.");
					}
					if (nameField.getText().length() == 0) {
						nameMessage.setForeground(Color.RED);
						nameMessage.setText("*�̸��� �Է��ϼ���.");
					}
					if (length1 != 3 || length2 != 4 || length3 != 4) {
						phoneMessage.setForeground(Color.RED);
						phoneMessage.setText("*�޴��� ��ȣ�� ���ڼ��� Ȯ���ϼ���.");
					}
				}
			}
		});
	}
	
	//�޴�����ȣ -������ ���ڿ��� ��ġ��
	public String putTogetherPhone(String num1, String num2, String num3) {
		StringBuilder builder = new StringBuilder();
		builder.append(num1);
		builder.append('-');
		builder.append(num2);
		builder.append('-');
		builder.append(num3);
		
		return builder.toString();
	}
	
	public void init() {
		setTitle("\uD68C\uC6D0 \uAC00\uC785");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 489, 473);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		infoPanel = new JPanel();
		infoPanel.setBackground(Color.WHITE);
		infoPanel.setBounds(16, 17, 439, 362);
		infoPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uD68C\uC6D0 \uC815\uBCF4 \uC785\uB825", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(infoPanel);
		infoPanel.setLayout(null);
		
		idField = new JTextField();
		idField.setFont(new Font("���� ���", Font.PLAIN, 12));
		idField.setBounds(58, 35, 101, 21);
		idField.setColumns(10);
		infoPanel.add(idField);
		
		atLabel = new JLabel("@");
		atLabel.setBounds(165, 35, 18, 21);
		infoPanel.add(atLabel);
		
		emailCombo = new JComboBox(emailComboData);
		emailCombo.setBackground(Color.LIGHT_GRAY);
		emailCombo.setFont(new Font("���� ���", Font.PLAIN, 12));
		emailCombo.setBounds(184, 35, 123, 21);
		infoPanel.add(emailCombo);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("���� ���", Font.PLAIN, 12));
		passwordField.setBounds(58, 95, 249, 21);
		passwordField.setColumns(10);
		infoPanel.add(passwordField);
		
		idLabel = new JLabel("id   :");
		idLabel.setFont(new Font("���� ���", Font.PLAIN, 12));
		idLabel.setBounds(12, 35, 34, 15);
		infoPanel.add(idLabel);
		
		pwLabel = new JLabel("pw  :");
		pwLabel.setFont(new Font("���� ���", Font.PLAIN, 12));
		pwLabel.setBounds(12, 95, 34, 15);
		infoPanel.add(pwLabel);
		
		sexPanel = new JPanel();
		sexPanel.setBackground(Color.WHITE);
		sexPanel.setForeground(new Color(0, 0, 0));
		sexPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uC131\uBCC4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sexPanel.setBounds(12, 287, 412, 65);
		infoPanel.add(sexPanel);
		sexPanel.setLayout(null);
		
		maleRadioButton = new JRadioButton("\uB0A8\uC131");
		maleRadioButton.setBackground(Color.WHITE);
		maleRadioButton.setFont(new Font("���� ���", Font.PLAIN, 12));
		maleRadioButton.setSelected(true);
		sexButtonGroup.add(maleRadioButton);
		maleRadioButton.setBounds(131, 22, 60, 23);
		sexPanel.add(maleRadioButton);
		
		femaleRadioButton = new JRadioButton("\uC5EC\uC131");
		femaleRadioButton.setBackground(Color.WHITE);
		femaleRadioButton.setFont(new Font("���� ���", Font.PLAIN, 12));
		sexButtonGroup.add(femaleRadioButton);
		femaleRadioButton.setBounds(225, 22, 60, 23);
		sexPanel.add(femaleRadioButton);
		
		//btn_checkDuplicate = new JButton("\uC911\uBCF5\uC870\uD68C");
		btn_checkDuplicate = new JButton(new ImageIcon("./img/checkDuplicateButtonIcon.png"));
		btn_checkDuplicate.setBackground(Color.WHITE);
		btn_checkDuplicate.setFont(new Font("���� ���", Font.PLAIN, 12));
		btn_checkDuplicate.setBounds(320, 27, 104, 36);
		btn_checkDuplicate.setBorderPainted(false);
		infoPanel.add(btn_checkDuplicate);
		
		idMessage = new JLabel("");
		idMessage.setForeground(Color.RED);
		idMessage.setBounds(12, 66, 295, 15);
		infoPanel.add(idMessage);
		
		passwordMessage = new JLabel("");
		passwordMessage.setForeground(Color.RED);
		passwordMessage.setBounds(12, 128, 295, 15);
		infoPanel.add(passwordMessage);
		
		nameLabel = new JLabel("\uC774\uB984 :");
		nameLabel.setFont(new Font("���� ���", Font.PLAIN, 12));
		nameLabel.setBounds(12, 163, 57, 15);
		infoPanel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("���� ���", Font.PLAIN, 12));
		nameField.setBounds(58, 160, 116, 21);
		infoPanel.add(nameField);
		nameField.setColumns(10);
		
		lbNumber = new JLabel("\uD734\uB300\uD3F0\uBC88\uD638 :");
		lbNumber.setFont(new Font("���� ���", Font.PLAIN, 12));
		lbNumber.setBounds(12, 222, 77, 15);
		infoPanel.add(lbNumber);
		
		phoneField1 = new JTextField();
		phoneField1.setFont(new Font("���� ���", Font.PLAIN, 12));
		phoneField1.setForeground(Color.LIGHT_GRAY);
		phoneField1.setText("000");
		phoneField1.setBounds(90, 219, 39, 21);
		infoPanel.add(phoneField1);
		phoneField1.setColumns(10);
		
		phoneField2 = new JTextField("");
		phoneField2.setFont(new Font("���� ���", Font.PLAIN, 12));
		phoneField2.setForeground(Color.LIGHT_GRAY);
		phoneField2.setText("0000");
		phoneField2.setBounds(151, 219, 62, 21);
		infoPanel.add(phoneField2);
		phoneField2.setColumns(10);
		
		phoneField3 = new JTextField();
		phoneField3.setFont(new Font("���� ���", Font.PLAIN, 12));
		phoneField3.setForeground(Color.LIGHT_GRAY);
		phoneField3.setText("0000");
		phoneField3.setColumns(10);
		phoneField3.setBounds(235, 219, 62, 21);
		infoPanel.add(phoneField3);
		
		dashLabel = new JLabel("-");
		dashLabel.setBounds(138, 222, 12, 15);
		infoPanel.add(dashLabel);
		
		dashLabel2 = new JLabel("-");
		dashLabel2.setBounds(220, 222, 12, 15);
		infoPanel.add(dashLabel2);
		
		phoneMessage = new JLabel("");
		phoneMessage.setBounds(12, 250, 295, 15);
		infoPanel.add(phoneMessage);
		
		nameMessage = new JLabel("");
		nameMessage.setBounds(12, 190, 295, 15);
		infoPanel.add(nameMessage);
		
		//btn_join = new JButton("\uAC00\uC785\uD558\uAE30");
		btn_join = new JButton(new ImageIcon("./img/joinButtonIcon2.png"));
		btn_join.setBackground(Color.WHITE);
		btn_join.setFont(new Font("���� ���", Font.PLAIN, 12));
		btn_join.setBounds(189, 389, 104, 36);
		btn_join.setBorderPainted(false);	//��ư �ٿ���� ���ֱ�
		contentPane.add(btn_join);
	}
}
