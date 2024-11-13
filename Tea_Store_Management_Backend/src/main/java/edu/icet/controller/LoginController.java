package edu.icet.controller;

import edu.icet.dto.Admin;
import edu.icet.dto.Manager;
import edu.icet.service.AdminService;
import edu.icet.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    private final AdminService adminService;
    private final ManagerService managerService;

    @PostMapping
    public ResponseEntity<Map<String, String>> login(@RequestParam String email, @RequestParam String password, @RequestParam String role) {
        Map<String, String> response = new HashMap<>();
        if (role.equalsIgnoreCase("ADMIN")) {
            return adminService.searchByEmail(email)
                    .filter(admin -> admin.getPassword().equals(password))
                    .map(admin -> {
                        response.put("role", "ADMIN");
                        response.put("userId", admin.getAdminId().toString());  // Assuming adminId is of type Long or Integer
                        return ResponseEntity.ok(response);
                    })
                    .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null));
        } else if (role.equalsIgnoreCase("MANAGER")) {
            return managerService.searchByEmail(email)
                    .filter(manager -> manager.getPassword().equals(password))
                    .map(manager -> {
                        response.put("role", "MANAGER");
                        response.put("userId", manager.getManagerId().toString());  // Assuming managerId is of type Long or Integer
                        return ResponseEntity.ok(response);
                    })
                    .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
}
