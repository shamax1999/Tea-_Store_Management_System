package edu.icet.service.Impl;

import edu.icet.dto.Admin;
import edu.icet.entity.AdminEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import edu.icet.service.AdminService;
import edu.icet.repository.adminRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    final adminRepository repository;
    final ModelMapper mapper;

    @Override
    public List<Admin> getAdmin() {
        List<Admin> admins = new ArrayList<>();
        repository.findAll().forEach(admin -> {
            admins.add(mapper.map(admin, Admin.class));
        });
        return admins;
    }

    @Override
    public void addAdmin(Admin admin) {
        repository.save(mapper.map(admin, AdminEntity.class));

    }

    @Override
    public void deleteById(Integer adminId) {
        repository.deleteById(adminId);

    }


    @Override
    public Optional<Admin> searchByEmail(String email) {
        return repository.findByEmail(email)
                .stream()
                .findFirst()
                .map(entity -> mapper.map(entity, Admin.class));
    }

    @Override
    public List<Admin> searchByAdminId(Integer adminId) {
        List<Admin> adminList =new ArrayList<>();
        repository.findByAdminId(adminId).forEach(entity->{
            adminList.add(mapper.map(entity, Admin.class));
        });
        return adminList;

    }
}
