package GUI;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class Common {
	//singleton pattern
	private static Common instance = new Common();
	private Common() {}
	public static Common getInstance() {
		return instance;
	}
	
	//���õ� ������ư�� �ؽ�Ʈ ��������
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			
			if(button.isSelected()){
				return button.getText();
			}
		}
		return null;
	}
	
	//�̸��� ������ �ϳ��� String���� ��ġ��
	public String getEmailString(String id, String emailAddress) {
		StringBuilder email = new StringBuilder();
		email.append(id); 
		email.append('@');
		email.append(emailAddress);
		return email.toString();
	}
	
	public String getEmailStringWithQuotationMark(String id, String emailAddress) {
		StringBuilder email = new StringBuilder();
		email.append("'");
		email.append(id); 
		email.append('@');
		email.append(emailAddress);
		email.append("'");
		return email.toString();
	}
	
}
