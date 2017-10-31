package com.techelevator.model;

import java.util.List;

public interface OrderItemDAO {

    List<OrderItem> getOrderItems(long orderId);
    void saveOrderItems(List<OrderItem> newItems);

}
