package edu.icet.controller;

import edu.icet.dto.Order;
import edu.icet.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
@CrossOrigin
public class TeaOrderController {
    final OrderService orderService;

    @GetMapping("/get-all")
    public List<Order> getOrder() {
        return orderService.getOrder();
    }

    @PostMapping("/add-order")
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

    @DeleteMapping("/delete-by-id/{orderId}")
    public void deleteById(@PathVariable Integer orderId) {
        orderService.deleteById(orderId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }


    @GetMapping("/get-order-by-id/{orderId}")
    public List<Order> getByOrderId(@PathVariable Integer orderId){
        return orderService.searchByOrderId(orderId);
    }

    @GetMapping("/get-order-by-name/{itemName}")
    public List<Order> getByName(@PathVariable String itemName){
        return orderService.searchByItemName(itemName);
    }

    @GetMapping("/get-order-by-customerId/{customerId}")
    public List<Order> getByCustomerId(@PathVariable Integer customerId){
        return orderService.searchByCustomerId(customerId);
    }
    @GetMapping("/get-total-price")
    public double getTotalPrice() {
        return orderService.getTotalPrice();
    }

}
