package Apparel_Store;

import java.util.Date;

public class Product {
    private int product_id;
    private String name;
    private String gender;
    private int cost;
    private int discount;
    private Date added_on;
    private int qty = 1;
    private String image_url;
    private int deal_id;
    
    public Product(int product_id, String name, String gender, int cost, int discount, Date added_on, String url, int deal_id) {
        this.product_id = product_id;
        this.name = name;
        this.gender = gender;
        this.cost = cost;
        this.discount = discount;
        this.added_on = added_on;
        this.image_url = url;
        this.deal_id = deal_id;
    }

    public Product(int product_id, String name, int discount, int qty, int cost) {
        this.product_id = product_id;
        this.name = name;
        this.cost = cost;
        this.discount = discount;
        this.qty = qty;
    }


    public int getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public int getSellingPrice() {
        return (cost - discount);
    }
    public boolean isDiscounted() {
        return discount>0;
    }    
    public String getCost() {
        return "&#8377; " + Integer.toString(cost);
    }
    public boolean isNew() {
        Date today = new Date();  
        return (today.getTime()-added_on.getTime()<604800001);
    }    
    public Date getAdded_on() {
        return added_on;
    }
    public String getImage_url() {
        return image_url;
    }
    public int getQty() {
        return qty;
    }
    public int getDeal_id() {
        return deal_id;
    }
}
