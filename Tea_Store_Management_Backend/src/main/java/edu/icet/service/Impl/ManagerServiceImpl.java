package edu.icet.service.Impl;

import edu.icet.dto.Admin;
import edu.icet.dto.Manager;
import edu.icet.entity.ManagerEntity;
import edu.icet.repository.managerRepository;
import edu.icet.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    final managerRepository repository;
    final ModelMapper mapper;

    @Override
    public List<Manager> getManager() {
        List<Manager> managers = new ArrayList<>();
        repository.findAll().forEach(manager->{
            managers.add(mapper.map(manager,Manager.class));
        });
        return  managers;
    }

    @Override
    public void addManager(Manager manager) {
        repository.save(mapper.map(manager, ManagerEntity.class));
    }

    @Override
    public void deleteById(Integer managerId) {
        repository.deleteById(managerId);
    }

    @Override
    public List<Manager> searchByManagerId(Integer managerId) {
        List<Manager> managerList =new ArrayList<>();
        repository.findByManagerId(managerId).forEach(entity->{
            managerList.add(mapper.map(entity, Manager.class));
        });
        return managerList;
    }

    @Override
    public List<Manager> searchByManagerName(String name) {
        List<Manager> managerList =new ArrayList<>();
        repository.findByName(name).forEach(entity->{
            managerList.add(mapper.map(entity, Manager.class));
        });
        return managerList;
    }

    @Override
    public Optional<Manager> searchByEmail(String email) {
        return repository.findByEmail(email)
                .stream()
                .findFirst()
                .map(entity -> mapper.map(entity, Manager.class));
    }
}

