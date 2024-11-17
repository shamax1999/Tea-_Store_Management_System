package edu.icet.repository;

import edu.icet.dto.Order;
import edu.icet.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface orderRepository extends JpaRepository<OrderEntity, Integer> {


    List<OrderEntity> findByOrderId(Integer orderId);

    List<OrderEntity> findByItemName(String itemName);

    List<OrderEntity> findByCustomerId(Integer customerId);

    List<OrderEntity> findAllByStatus(OrderEntity.Status status);

}
