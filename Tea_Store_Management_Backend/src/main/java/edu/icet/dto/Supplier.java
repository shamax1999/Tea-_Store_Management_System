package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Supplier {
    private Integer supplierId;

    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String gender;
    private LocalDate dateOfBirth;
    private Integer adminId;
    private Integer managerId;

}

