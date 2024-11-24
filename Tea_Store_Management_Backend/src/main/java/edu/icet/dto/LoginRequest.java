package edu.icet.dto;

import edu.icet.entity.LoginEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    private LoginEntity.Role role;

    private Integer adminId;
    private Integer managerId;
}
