package edu.icet.service.Impl;


import edu.icet.dto.Order;
import edu.icet.entity.OrderEntity;
import edu.icet.repository.orderRepository;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    final orderRepository repository;
    final ModelMapper mapper;

    @Override
    public List<Order> getOrder() {
        List<Order> orders = new ArrayList<>();
        repository.findAll().forEach(order->{
            orders.add(mapper.map(order,Order.class));
        });
        return  orders;
    }

    @Override
    public void addOrder(Order order) {
        repository.save(mapper.map(order, OrderEntity.class));

    }

    @Override
    public void deleteById(Integer orderId) {
        repository.deleteById(orderId);

    }

    @Override
    public List<Order> searchByOrderId(Integer orderId) {
        List<Order> orderList =new ArrayList<>();
        repository.findByOrderId(orderId).forEach(entity->{
            orderList.add(mapper.map(entity, Order.class));
        });
        return orderList;
    }

    @Override
    public List<Order> searchByItemName(String itemName) {
        List<Order> orderList =new ArrayList<>();
        repository.findByItemName(itemName).forEach(entity->{
            orderList.add(mapper.map(entity, Order.class));
        });
        return orderList;
    }

    @Override
    public List<Order> searchByCustomerId(Integer customerId) {
        List<Order> orderList =new ArrayList<>();
        repository.findByCustomerId(customerId).forEach(entity->{
            orderList.add(mapper.map(entity, Order.class));
        });
        return orderList;
    }
}
