package edu.icet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;  // Email serves as the username for both admin and manager
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Integer adminId;
    private Integer managerId;

    public enum Role {
        ADMIN,
        MANAGER
    }
}
