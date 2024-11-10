package edu.icet.controller;


import edu.icet.dto.Manager;
import edu.icet.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/manager")
@CrossOrigin
public class ManagerController {
    final ManagerService managerService;

    @GetMapping("/get-all")
    public List<Manager> getManager() {
        return managerService.getManager();
    }

    @PostMapping("/add-manager")
    public void addManager(@RequestBody Manager manager) {
        managerService.addManager(manager);
    }

    @DeleteMapping("/delete-by-id/{managerId}")
    public void deleteById(@PathVariable Integer managerId) {
        managerService.deleteById(managerId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateManager(@RequestBody Manager manager) {
        managerService.addManager(manager);
    }


    @GetMapping("/get-manager-by-Id/{managerId}")
    public List<Manager> getByManagerId(@PathVariable Integer managerId){
        return managerService.searchByManagerId(managerId);
    }

    @GetMapping("/get-manager-by-name/{name}")
    public List<Manager> getByName(@PathVariable String name){
        return managerService.searchByManagerName(name);
    }

    @GetMapping("/search-by-email/{email}")
    public Optional<Manager> searchByEmail(@PathVariable String email) {
        return managerService.searchByEmail(email);
    }

}
