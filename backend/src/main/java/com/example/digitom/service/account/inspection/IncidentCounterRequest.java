package com.example.digitom.service.account.inspection;


import lombok.Data;

@Data
public class IncidentCounterRequest {
    private Integer reportId;
    private Integer safetyFieldId;
    private Boolean safe;

}
