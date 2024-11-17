package edu.icet.service;

import edu.icet.dto.Report;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ReportService {
    List<Report> getReports();

    void addReportWithFile(String reportJson, MultipartFile file) throws Exception;

    void updateReportWithFile(Integer reportId, String reportJson, MultipartFile file) throws Exception;

    void deleteById(Integer reportId);

    ResponseEntity<byte[]> getFileByReportId(Integer reportId);
}