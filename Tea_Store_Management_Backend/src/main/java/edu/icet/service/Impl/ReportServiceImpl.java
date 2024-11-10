package edu.icet.service.Impl;

import edu.icet.dto.Order;
import edu.icet.dto.Report;
import edu.icet.entity.OrderEntity;
import edu.icet.entity.ReportEntity;
import edu.icet.repository.orderRepository;
import edu.icet.repository.reportRepository;
import edu.icet.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    final reportRepository repository;
    final ModelMapper mapper;

    @Override
    public List<Report> getReport() {
        List<Report> reports = new ArrayList<>();
        repository.findAll().forEach(report->{
            reports.add(mapper.map(report,Report.class));
        });
        return  reports;
    }

    @Override
    public void addReport(Report report) {
        repository.save(mapper.map(report, ReportEntity.class));

    }

    @Override
    public void deleteById(Integer reportId) {
        repository.deleteById(reportId);

    }

    @Override
    public List<Report> searchByReportId(Integer reportId) {
        List<Report> reportList =new ArrayList<>();
        repository.findByReportId(reportId).forEach(entity->{
            reportList.add(mapper.map(entity, Report.class));
        });
        return reportList;
    }

    @Override
    public List<Report> searchByReportType(String reportType) {
        List<Report> reportList =new ArrayList<>();
        repository.findByReportType(reportType).forEach(entity->{
            reportList.add(mapper.map(entity, Report.class));
        });
        return reportList;
    }
}
