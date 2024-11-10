package edu.icet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private AdminEntity.Gender gender;

    private LocalDate dateOfBirth;
    private LocalDate dateOfJoin;
    private Integer adminId;

}
