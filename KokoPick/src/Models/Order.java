package Models;

public class Order {
      private int orderId;
      private String menu;
      private int price;
      private int deliveryFlag;
      private int deliveryFee;
      private int brandId;
      private int userId;
      
      public Order() {}
      public Order(int orderId, String menu, int price, int deliveryFlag, int deliveryFee, int brandId, int userId) {
         this.orderId = orderId;
         this.menu = menu;
         this.price = price;
         this.deliveryFlag = deliveryFlag;
         this.deliveryFee = deliveryFee;
         this.brandId = brandId;
         this.userId = userId;
      }
      
      public Order(Order source) {
    	  this.orderId = source.getOrderId();
    	  this.menu = new String(source.getMenu());
    	  this.price = source.getPrice();
    	  this.deliveryFlag = source.getDeliveryFlag();
    	  this.deliveryFee = source.getDeliveryFee();
    	  this.brandId = source.getBrandId();
    	  this.userId = source.getUserId();
      }
      
      public int getOrderId() { return this.orderId; }
      public String getMenu() { return this.menu; }
      public int getPrice() { return this.price; }
      public int getDeliveryFlag() { return this.deliveryFlag; }
      public int getDeliveryFee() { return this.deliveryFee; }
      public int getBrandId() { return this.brandId; }
      public int getUserId() { return this.userId; }
      
      public void setOrderId(int orderId) { this.orderId = orderId; }
      public void setmenu(String menu) { this.menu = menu; }
      public void setPrice(int price) { this.price = price; }
      public void setDeliveryFlag(int deliveryFlag) { this.deliveryFlag = deliveryFlag; }
      public void setDeliveryFee(int deliveryFee) { this.deliveryFee = deliveryFee; }
      public void setBrandId(int brandId) { this.brandId = brandId; }
      public void setUserId(int userId) { this.userId = userId; }
      
}