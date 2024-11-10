package edu.icet.repository;

import edu.icet.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface adminRepository extends JpaRepository<AdminEntity,Integer> {
    List<AdminEntity> findByEmail(String email);


    List<AdminEntity> findByAdminId(Integer adminId);

    Optional<AdminEntity> findByEmailAndPassword(String email, String password);




}
