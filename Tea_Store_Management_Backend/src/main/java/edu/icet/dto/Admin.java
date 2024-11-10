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
public class Admin {

    private Integer adminId;

    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String gender; // Should match enum(Male, Female, Other) in your database
    private LocalDate dateOfBirth;
    private String password;


}

