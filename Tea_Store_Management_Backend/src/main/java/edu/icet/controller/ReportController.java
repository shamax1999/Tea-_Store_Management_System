package edu.icet.controller;

import edu.icet.dto.Report;
import edu.icet.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/report")
@CrossOrigin
public class ReportController {
    final ReportService reportService;

    @GetMapping("/get-all")
    public List<Report> getItem() {
        return reportService.getReport();
    }

    @PostMapping("/add-report")
    public void addReport(@RequestBody Report report) {
        reportService.addReport(report);
    }

    @DeleteMapping("/delete-by-id/{reportId}")
    public void deleteById(@PathVariable Integer reportId) {
        reportService.deleteById(reportId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateReport(@RequestBody Report report) {
        reportService.addReport(report);
    }


    @GetMapping("/get-report-by-Id/{reportId}")
    public List<Report> getByReportId(@PathVariable Integer reportId){
        return reportService.searchByReportId(reportId);
    }


    @GetMapping("/get-report-by-reportType/{reportType}")
    public List<Report> getByReportType(@PathVariable String reportType){
        return reportService.searchByReportType(reportType);
    }

}
