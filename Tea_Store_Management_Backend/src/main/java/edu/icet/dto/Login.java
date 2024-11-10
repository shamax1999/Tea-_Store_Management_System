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
    private String password; // Ensure this remains null in the response
    private LoginEntity.Role role;
    private Integer adminId;
    private Integer managerId;
}
