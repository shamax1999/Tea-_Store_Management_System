package edu.icet.controller;

import edu.icet.dto.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import edu.icet.service.AdminService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    final AdminService service;

    @GetMapping("/get-all")
    public List<Admin> getAdmin() {
        return service.getAdmin();
    }

    @PostMapping("/add-admin")
    public void addAdmin(@RequestBody Admin admin) {
        service.addAdmin(admin);
    }

    @DeleteMapping("/delete-by-id/{adminId}")
    public void deleteById(@PathVariable Integer adminId) {
        service.deleteById(adminId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateAdmin(@RequestBody Admin admin) {
        service.addAdmin(admin);
    }

    @GetMapping("/search-by-email/{email}")
    public Optional<Admin> searchByEmail(@PathVariable String email) {
        return service.searchByEmail(email);
    }

    @GetMapping("/get-admin-by-Id/{adminId}")
    public List<Admin> getByAdminId(@PathVariable Integer adminId){
        return service.searchByAdminId(adminId);
    }

}