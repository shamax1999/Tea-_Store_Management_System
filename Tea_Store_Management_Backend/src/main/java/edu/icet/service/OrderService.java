package edu.icet.service;

import edu.icet.dto.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrder();

    void addOrder(Order order);

    void deleteById(Integer orderId);

    List<Order> searchByOrderId(Integer orderId);

    List<Order> searchByItemName(String itemName);

    List<Order> searchByCustomerId(Integer customerId);

    double getTotalPrice();

}
