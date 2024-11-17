package edu.icet.repository;

import edu.icet.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface reportRepository extends JpaRepository<ReportEntity, Integer> {


}