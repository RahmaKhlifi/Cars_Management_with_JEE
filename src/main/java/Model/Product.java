package Model;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String image;
    private double cost;
    private User seller;
    
    public Product() {
    	this.name = "";
        this.image = "";
        this.cost = 0;
        this.seller = null;  
 	   
    }

    public Product(String name, String image, double cost, User seller) {
        this.name = name;
        this.image = image;
        this.cost = cost;
        this.seller = seller;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", image=" + image + ", cost=" + cost + ", seller=" + seller + "]";
	}
    
    

  
}
