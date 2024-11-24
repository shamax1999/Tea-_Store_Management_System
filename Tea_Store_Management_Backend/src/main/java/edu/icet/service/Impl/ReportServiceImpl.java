package edu.icet.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Report;
import edu.icet.entity.ReportEntity;
import edu.icet.repository.reportRepository;
import edu.icet.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    final reportRepository repository;
    final ModelMapper mapper;
    final ObjectMapper objectMapper;

    @Override
    public List<Report> getReports() {
        List<Report> reports = new ArrayList<>();
        repository.findAll().forEach(entity -> reports.add(mapper.map(entity, Report.class)));
        return reports;
    }

    @Override
    public void addReportWithFile(String reportJson, MultipartFile file) throws Exception {
        final long MAX_FILE_SIZE = 3221225472L;

        if (file.getSize() > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("File size exceeds the maximum limit of 3GB");
        }

        Report report = objectMapper.readValue(reportJson, Report.class);
        ReportEntity entity = mapper.map(report, ReportEntity.class);

        if (!file.isEmpty()) {
            System.out.println("File Name: " + file.getOriginalFilename());
            System.out.println("File Size: " + file.getSize());
            entity.setPdfFile(file.getBytes());
            entity.setPdfSrc(file.getOriginalFilename());
        }

        repository.save(entity);
    }



    @Override
    public void updateReportWithFile(Integer reportId, String reportJson, MultipartFile file) throws Exception {
        ReportEntity existingReport = repository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("Report not found"));

        Report updatedReport = objectMapper.readValue(reportJson, Report.class);
        existingReport.setReportName(updatedReport.getReportName());
        existingReport.setDate(updatedReport.getDate());
        existingReport.setAdminId(updatedReport.getAdminId());
        existingReport.setManagerId(updatedReport.getManagerId());
        existingReport.setReportType(ReportEntity.ReportType.valueOf(updatedReport.getReportType()));

        if (file != null && !file.isEmpty()) {
            System.out.println("File Name: " + file.getOriginalFilename());
            System.out.println("File Size: " + file.getSize());
            existingReport.setPdfFile(file.getBytes());
            existingReport.setPdfSrc(file.getOriginalFilename());
        }

        repository.save(existingReport);
    }

    @Override
    public void deleteById(Integer reportId) {
        repository.deleteById(reportId);
    }

    @Override
    public ResponseEntity<byte[]> getFileByReportId(Integer reportId) {
        ReportEntity entity = repository.findById(reportId)
                .orElseThrow(() -> new RuntimeException("Report not found"));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + entity.getPdfSrc())
                .contentType(MediaType.APPLICATION_PDF)
                .body(entity.getPdfFile());

    }
}