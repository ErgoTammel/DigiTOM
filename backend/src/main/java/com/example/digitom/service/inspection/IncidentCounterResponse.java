package com.example.digitom.service.inspection;


import lombok.Data;

@Data
public class IncidentCounterResponse {
    private Integer reportId;
    private Integer safetyFieldId;
    private Boolean safe;

}
