package edu.icet.service;

import edu.icet.dto.Report;

import java.util.List;

public interface ReportService {
    List<Report> getReport();

    void addReport(Report report);

    void deleteById(Integer reportId);

    List<Report> searchByReportId(Integer reportId);

    List<Report> searchByReportType(String reportType);

}
