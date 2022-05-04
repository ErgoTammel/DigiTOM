package com.example.digitom.domain.task;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class TaskDto implements Serializable {
    private final Integer id;
    private final Integer safetyFieldId;
    private final Integer safetyFieldFieldNumber;
    private final String safetyFieldFieldDescription;
    private final Integer reportId;
    private final Integer reportConstructionSiteId;
    private final String reportConstructionSiteName;
    private final String reportConstructionSiteAddress;
    private final Integer reportConstructionSiteLatitude;
    private final Integer reportConstructionSiteLongitude;
    private final LocalDate reportDate;
    private final String description;
    private final Date deadline;
    private final Boolean isDone;
}
