package edu.icet.dto;

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
public class TeaCollection {
    private Integer collectionId;

    private Integer supplierId;
    private Integer adminId;
    private Integer managerId;
    private LocalDate date;
    private LocalTime time;
    private String teaType;
    private Integer teaQuantity;
}
