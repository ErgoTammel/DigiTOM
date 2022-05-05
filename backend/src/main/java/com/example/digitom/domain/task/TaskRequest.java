package com.example.digitom.domain.task;

import lombok.Data;

@Data
public class TaskRequest {
    private Integer reportId;
    private Integer incidentId;
    private Integer companyId;
    private String  description;
    private Integer deadline;
}
