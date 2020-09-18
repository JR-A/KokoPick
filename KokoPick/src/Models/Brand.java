package Models;

public class Brand {
	private int brandId;
	private String name;
	private String telephone = null;
	private String location = null;
	private String ceoName = null;
	
	public Brand(){}
	public Brand(int brandId, String name, String telephone, String location, String ceoName) {
		this.brandId = brandId;
		this.name = name;
		this.telephone = telephone;
		this.location = location;
		this.ceoName = ceoName;
	}
	
	public int getBrandId() { return this.brandId; }
	public String getName() { return this.name; }
	public String getTelephone() { return this.telephone; }
	public String getLocation() { return this.location; }
	public String getCeoName() { return this.ceoName; }
	
	public void setBrandId(int brandId) { this.brandId = brandId; }
	public void setName(String name) { this.name = name; }
	public void setTelephone(String telephone) { this.telephone = telephone; }
	public void setLocation(String location) { this.location = location; }
	public void setCeoName(String ceoName) { this.ceoName = ceoName; }
}
