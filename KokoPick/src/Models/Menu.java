package Models;

public class Menu {
	private int brandId;
	private String name;
	private int category;
	private int price;
	
	public Menu() {}
	public Menu(int brandId, String name, int category, int price) {
		this.brandId = brandId;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	public int getBrandId() { return this.brandId; }
	public String getName() { return this.name; }
	public int getCategory() { return this.category; }
	public int getPrice() { return this.price; }
	
	public void setBrandId(int brandId) { this.brandId = brandId; }
	public void setName(String name){ this.name = name; }
	public void setCategory(int category) { this.category = category; }
	public void setPrice(int price) { this.price = price; }
	
}
