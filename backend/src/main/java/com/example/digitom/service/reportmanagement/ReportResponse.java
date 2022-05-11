package com.example.digitom.service.reportmanagement;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ReportResponse {
    private Integer reportId;
    private String mainContractorName;
    private String constructionSiteName;
    private LocalDate date;
    private BigDecimal tom;
}
