package com.example.digitom.domain.taskresponse;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Data
public class TaskResponseDto implements Serializable {
    private final Integer id;
    private final Integer taskId;
    private final Integer taskReportId;
    private final Integer taskReportConstructionSiteId;
    private final String taskReportConstructionSiteName;
    private final String taskReportConstructionSiteAddress;
    private final Integer taskReportConstructionSiteLatitude;
    private final Integer taskReportConstructionSiteLongitude;
    private final LocalDate taskReportDate;
    private final BigDecimal taskReportTom;
    private final Integer taskIncidentId;
    private final Boolean taskIncidentSafe;
    private final Integer taskIncidentSafetyFieldId;
    private final Integer taskIncidentSafetyFieldFieldNumber;
    private final String taskIncidentSafetyFieldFieldDescription;
    private final Integer taskIncidentReportId;
    private final Integer taskIncidentReportConstructionSiteId;
    private final String taskIncidentReportConstructionSiteName;
    private final String taskIncidentReportConstructionSiteAddress;
    private final Integer taskIncidentReportConstructionSiteLatitude;
    private final Integer taskIncidentReportConstructionSiteLongitude;
    private final LocalDate taskIncidentReportDate;
    private final BigDecimal taskIncidentReportTom;
    private final Integer taskCompanyId;
    private final String taskCompanyName;
    private final Integer taskCompanyRegNumber;
    private final String taskDescription;
    private final LocalDate taskDeadline;
    private final Boolean taskIsDone;
    private final String description;
    private final Instant time;
}
