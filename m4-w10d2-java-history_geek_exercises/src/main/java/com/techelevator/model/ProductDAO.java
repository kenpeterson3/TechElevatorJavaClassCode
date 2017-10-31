package com.techelevator.model;

import java.util.List;

public interface ProductDAO {

    /**
     * Returns back a list of all active products.
     * @return
     */
    List<Product> getProducts();

    /**
     * Returns a single product given a sku.
     * @param sku
     * @return
     */
    Product getProduct(String sku);
    
    Product getProductByID(long id);

}
