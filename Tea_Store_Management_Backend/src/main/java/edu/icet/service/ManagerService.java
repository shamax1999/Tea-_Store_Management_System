package edu.icet.service;

import edu.icet.dto.Admin;
import edu.icet.dto.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerService {
    List<Manager> getManager();

    void addManager(Manager manager);

    void deleteById(Integer managerId);

    List<Manager> searchByManagerId(Integer managerId);

    List<Manager> searchByManagerName(String name);

    Optional<Manager> searchByEmail(String email);

}
