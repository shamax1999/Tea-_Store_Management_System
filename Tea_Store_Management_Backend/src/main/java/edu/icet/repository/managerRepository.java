package edu.icet.repository;

import edu.icet.entity.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface managerRepository extends JpaRepository<ManagerEntity, Integer> {

    List<ManagerEntity> findByManagerId(Integer managerId);

    List<ManagerEntity> findByName(String name);

    Optional<ManagerEntity> findByEmailAndPassword(String email, String password);

    List<ManagerEntity> findByEmail(String email);

}
