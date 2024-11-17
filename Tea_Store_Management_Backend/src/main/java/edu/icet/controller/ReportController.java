package edu.icet.controller;

import edu.icet.dto.Report;
import edu.icet.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/report")
@CrossOrigin
public class ReportController {
    final ReportService reportService;

    @GetMapping("/get-all")
    public List<Report> getReports() {
        return reportService.getReports();
    }

    @PostMapping("/add-report")
    public void addReport(
            @RequestParam("report") String reportJson,
            @RequestParam("file") MultipartFile file) throws Exception {
        reportService.addReportWithFile(reportJson, file);
    }

    @PutMapping("/update-report/{reportId}")
    public void updateReport(
            @PathVariable Integer reportId,
            @RequestParam("report") String reportJson,
            @RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        reportService.updateReportWithFile(reportId, reportJson, file);
    }

    @DeleteMapping("/delete-by-id/{reportId}")
    public void deleteById(@PathVariable Integer reportId) {
        reportService.deleteById(reportId);
    }

    @GetMapping("/get-file/{reportId}")
    public ResponseEntity<byte[]> getFile(@PathVariable Integer reportId) {
        return reportService.getFileByReportId(reportId);
    }
}