package edu.icet.service;

import edu.icet.dto.Admin;

import java.util.List;
import java.util.Optional;


public interface AdminService {
    List<Admin> getAdmin();

    void addAdmin(Admin admin);


    void deleteById(Integer adminId);


    Optional<Admin> searchByEmail(String email);

    List<Admin> searchByAdminId(Integer adminId);



}
