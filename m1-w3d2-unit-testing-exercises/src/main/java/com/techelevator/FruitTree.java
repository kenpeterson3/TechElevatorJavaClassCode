package com.techelevator;

public class FruitTree {

	private String typeOfFruit;
    private int piecesOfFruitLeft;

    /**
     * Creates a new fruit tree. 
     * @param typeOfFruit type of fruit the tree holds
     * @param startingPiecesOfFruit number of fruit pieces to start on the tree
     */
    public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
        this.piecesOfFruitLeft = startingPiecesOfFruit;
        this.typeOfFruit = typeOfFruit;
    }

    /**
     * Type of fruit on the tree 
     * @return typeOfFruit
     */
    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    /**
     * Number of fruit pieces remaining 
     * @return piecesOfFruitLeft
     */
    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    /**
     * Picks fruit off of the tree and reduces the number of remaining pieces. 
     * @param numberOfPieces number of fruit pieces to remove
     * @return True if there is enough fruit to pick, false if not.
     */
    public boolean PickFruit(int numberOfPieces)
    {
        piecesOfFruitLeft -= numberOfPieces;
        return true;
    }

}
