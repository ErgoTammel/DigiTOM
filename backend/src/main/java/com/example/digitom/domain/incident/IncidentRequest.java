package com.example.digitom.domain.incident;

import lombok.Data;

@Data
public class IncidentRequest {
    private Boolean safe;
    private Integer safetyFieldId;
    private Integer reportId;

}
