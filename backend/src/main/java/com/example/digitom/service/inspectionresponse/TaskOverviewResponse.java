package com.example.digitom.service.inspectionresponse;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskOverviewResponse {
    private String constructionSiteName;
    private LocalDate deadline;
    private String description;

}
