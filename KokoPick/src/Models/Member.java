package Models;

public class Member {
	private int userId;
	private String sex;
	private String email;
	private String password;
	private String name;
	private String phone;
	
	public Member() {}
	public Member(int userId, String sex, String email, String password, String name, String phone) {
		this.userId = userId;
		this.sex = sex;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	public int getUserId() { return this.userId; }
	public String getSex() { return this.sex; }
	public String getEmail() { return this.email; }
	public String getPassword() { return this.password; }
	public String getName() { return this.name; }
	public String getPhone() { return this.phone; }
	public void setUserId(int userId) { this.userId = userId; }
	public void setSex(String sex) { this.sex = sex; }
	public void setEmail(String email) { this.email = email; }
	public void setPassword(String password) { this.password = password; }
	public void setName(String name) { this.name = name; }
	public void setPhone(String phone) { this.phone = phone; }
}
