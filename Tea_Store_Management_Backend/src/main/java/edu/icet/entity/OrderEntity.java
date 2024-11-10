package edu.icet.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private Integer customerId;
    private LocalDate orderDate;
    private Integer itemId;
    private String itemName;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Payment paymentMethod;

    private BigDecimal totalPrice;
    private Integer adminId;
    private Integer managerId;

    public enum Status {
        Pending,
        Completed,
        Cancelled
    }

    public enum Payment {
        Credit_Card,
        Debit_Card,
        Bank_Transfer,
        Cash_on_Delivery,
        Mobile_Payment
    }





}
