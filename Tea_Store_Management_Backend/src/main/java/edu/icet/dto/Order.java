package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private Integer orderId;

    private Integer customerId;
    private LocalDate orderDate;
    private Integer itemId;
    private String itemName;
    private String status;
    private String paymentMethod;
    private BigDecimal totalPrice;
    private Integer quantity;
    private Integer adminId;
    private Integer managerId;

}
