package com.techelevator.model;

import java.util.List;

public interface OrderDAO {

    Order getOrder(long orderId);
    List<Order> getOrders(long userID);
    void saveOrder(Order newOrder);

}
