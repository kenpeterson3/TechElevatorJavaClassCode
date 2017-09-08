package com.techelevator.shoppingcart;

public class ShoppingCart {
	//data members below
	private int totalNumberOfItems = 0;
	private double totalAmountOwed = 0.0;
	
	// methods below
	public double getAveragePricePerItem(){
		// also could use if statement instead of ternary below
		return (totalNumberOfItems == 0) ? 0.0 : (totalAmountOwed / totalNumberOfItems);
	}
	
	public void addItems(int numberOfItems, double pricePerItem) {
		totalNumberOfItems += numberOfItems;
		totalAmountOwed += (pricePerItem * numberOfItems);
	}
	
	public void empty() {
		totalNumberOfItems = 0 ;
		totalAmountOwed = 0.0;
		
		
	}
	
	//getters and setters below
	public int getTotalNumberOfItems() {
		return totalNumberOfItems;
	}
	public void setTotalNumberOfItems(int totalNumberOfItems) {
		this.totalNumberOfItems = totalNumberOfItems;
	}
	public double getTotalAmountOwed() {
		return totalAmountOwed;
	}
	public void setTotalAmountOwed(double totalAmountOwed) {
		this.totalAmountOwed = totalAmountOwed;
	}
	
	
	
}
