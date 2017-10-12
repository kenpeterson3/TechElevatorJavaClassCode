package com.techelevator;

public class Product {
	private String productId;
	private String name;
	private String manufacturer;
	private String imageName;
	private double weightInLbs;
	private double price;
	private double averageRating;
	private int remainingStock;
	private boolean topSeller;
	private String description;
	
	public String getProductId() {
		return productId;
	}
	public Product setProductId(String productId) {
		this.productId = productId;
		return this;
	}
	public String getName() {
		return name;
	}
	public Product setName(String name) {
		this.name = name;
		return this;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public Product setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
		return this;
	}
	public String getImageName() {
		return imageName;
	}
	public Product setImageName(String imageName) {
		this.imageName = imageName;
		return this;
	}
	public double getWeightInLbs() {
		return weightInLbs;
	}
	public Product setWeightInLbs(double weightInLbs) {
		this.weightInLbs = weightInLbs;
		return this;
	}
	public double getPrice() {
		return price;
	}
	public Product setPrice(double price) {
		this.price = price;
		return this;
	}
	public double getAverageRating() {
		return averageRating;
	}
	public Product setAverageRating(double averageRating) {
		this.averageRating = averageRating;
		return this;
	}
	public int getRemainingStock() {
		return remainingStock;
	}
	public Product setRemainingStock(int remainingStock) {
		this.remainingStock = remainingStock;
		return this;
	}
	public boolean isTopSeller() {
		return topSeller;
	}
	public Product setTopSeller(boolean topSeller) {
		this.topSeller = topSeller;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public Product setDescription(String description) {
		this.description = description;
		return this;
	}
}
