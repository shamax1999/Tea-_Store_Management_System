package edu.icet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class TeaCollectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer collectionId;

    private Integer supplierId;
    private Integer adminId;
    private Integer managerId;
    private LocalDate date;
    private LocalTime time;
    private String teaType;
    private Integer teaQuantity;
}
