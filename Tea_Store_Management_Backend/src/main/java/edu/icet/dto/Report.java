package edu.icet.dto;

import jakarta.persistence.Lob;
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

    @Lob
    private byte[] pdfFile;

    private LocalDate date;
    private String reportName;
    private Integer adminId;
    private Integer managerId;


}
