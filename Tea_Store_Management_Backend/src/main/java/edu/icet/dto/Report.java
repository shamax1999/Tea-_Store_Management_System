package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Report {
    private Integer reportId;

    private String reportType;
    private String pdfSrc;
    private LocalDate date;
    private String reportName;
    private Integer adminId;
    private Integer managerId;

}
