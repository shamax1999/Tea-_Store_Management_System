package edu.icet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportId;

    @Enumerated(EnumType.STRING)
    private ReportType reportType;


    private String pdfSrc;

    @Lob
    @Column(name = "pdf_file", columnDefinition = "LONGBLOB")
    private byte[] pdfFile;

    private LocalDate date;
    private String reportName;
    private Integer adminId;
    private Integer managerId;



    public enum ReportType {
        Sales,
        Production,
        Inventory
    }

}