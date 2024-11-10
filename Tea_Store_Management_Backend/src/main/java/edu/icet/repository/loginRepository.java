package edu.icet.repository;

import edu.icet.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface loginRepository extends JpaRepository<LoginEntity, Integer> {
    Optional<LoginEntity> findByEmailAndPasswordAndRole(String email, String password, LoginEntity.Role role);
}
