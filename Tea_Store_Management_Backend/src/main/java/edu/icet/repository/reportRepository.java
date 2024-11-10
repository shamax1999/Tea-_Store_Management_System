package edu.icet.repository;

import edu.icet.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface reportRepository extends JpaRepository<ReportEntity, Integer> {
    List<ReportEntity> findByReportId(Integer reportId);

    List<ReportEntity> findByReportType(String reportType);

}
