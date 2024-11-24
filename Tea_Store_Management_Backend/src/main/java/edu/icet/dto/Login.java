package edu.icet.dto;

import edu.icet.entity.LoginEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    private Integer id;
    private String username;
    private String password;
    private LoginEntity.Role role;
    private Integer adminId;
    private Integer managerId;
}
