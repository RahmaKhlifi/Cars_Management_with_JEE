package Model;

import java.io.Serializable;

public class Offer implements Serializable {
    private User bidder;
    private Product product;
    private double amount;
    
    public Offer() {
    	this.bidder = null;
        this.product = null;
        this.amount = 0;
    }

    public Offer(User bidder, Product product, double amount) {
        this.bidder = bidder;
        this.product = product;
        this.amount = amount;
    }

	public User getBidder() {
		return bidder;
	}

	public void setBidder(User bidder) {
		this.bidder = bidder;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Offer [bidder=" + bidder + ", product=" + product + ", amount=" + amount + "]";
	}

     
}
