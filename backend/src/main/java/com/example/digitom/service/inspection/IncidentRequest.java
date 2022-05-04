package com.example.digitom.service.inspection;

import lombok.Data;

@Data
public class IncidentRequest {
    private Boolean safe;
    private Integer safetyFieldId;
    private Integer reportId;

}
