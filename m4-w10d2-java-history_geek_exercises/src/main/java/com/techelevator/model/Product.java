package com.techelevator.model;

public class Product {

	private Long id;
	private String sku;
	private String name;
	private String description;
	private DollarAmount price;
	private String imageName;
	private double weight;
	private boolean active;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public DollarAmount getPrice() {
		return price;
	}
	public void setPrice(DollarAmount price) {
		this.price = price;
	}
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
    public int getPounds() {
    	return (int)weight / 16;
    }
    
    public int getOunces() {
    	return (int)weight % 16;
    }

}
