package com.example.digitom.service.reportmanagement;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FindReportRequest {
    private Integer id;
    private String constructionSiteName;
    private LocalDate date;
}
