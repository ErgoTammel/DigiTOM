package com.example.digitom.domain.incident;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class IncidentDto implements Serializable {
    private final Integer id;
    private final Boolean safe;
    private final Integer safetyFieldId;
    private final Integer safetyFieldFieldNumber;
    private final String safetyFieldFieldDescription;
    private final Integer reportId;
    private final LocalDate reportDate;
}
