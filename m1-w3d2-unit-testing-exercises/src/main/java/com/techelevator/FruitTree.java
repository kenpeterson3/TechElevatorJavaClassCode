package com.techelevator;

public class FruitTree {
//instance variables
	private String typeOfFruit;
	private int piecesOfFruitLeft;
//constructor	
	public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
		this.typeOfFruit = typeOfFruit;
		this.piecesOfFruitLeft = startingPiecesOfFruit;
			
	}
//methods
	 public boolean pickFruit(int numberOfPiecesToRemove) {
		 if (piecesOfFruitLeft >= numberOfPiecesToRemove) {
			 piecesOfFruitLeft -= numberOfPiecesToRemove;
			 return true;
		 } else {
			 return false;
		 }
	 }
	//public String typeOfFruit {
		
	//}
	 
	 
	public String getTypeOfFruit() {
		return typeOfFruit;
	}
	public int getPiecesOfFruitLeft() {
		return piecesOfFruitLeft;
	}
	
	
}
