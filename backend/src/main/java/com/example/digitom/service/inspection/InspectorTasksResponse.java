package com.example.digitom.service.inspection;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InspectorTasksResponse {
    private Integer taskId;
    private String constructionSiteName;
    private LocalDate deadline;
    private String description;
    private String companyName;
}
