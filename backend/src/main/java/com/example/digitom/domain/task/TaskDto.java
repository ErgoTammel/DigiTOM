package com.example.digitom.domain.task;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class TaskDto implements Serializable {
    private final Integer id;
    private final Integer reportId;
    private final Integer reportConstructionSiteId;
    private final String reportConstructionSiteName;
    private final String reportConstructionSiteAddress;
    private final Integer reportConstructionSiteLatitude;
    private final Integer reportConstructionSiteLongitude;
    private final LocalDate reportDate;
    private final Integer incidentId;
    private final Boolean incidentSafe;
    private final Integer incidentSafetyFieldId;
    private final Integer incidentSafetyFieldFieldNumber;
    private final String incidentSafetyFieldFieldDescription;
    private final Integer incidentReportId;
    private final Integer incidentReportConstructionSiteId;
    private final String incidentReportConstructionSiteName;
    private final String incidentReportConstructionSiteAddress;
    private final Integer incidentReportConstructionSiteLatitude;
    private final Integer incidentReportConstructionSiteLongitude;
    private final LocalDate incidentReportDate;
    private final Integer companyId;
    private final String companyName;
    private final Integer companyRegNumber;
    private final String description;
    private final LocalDate deadline;
    private final Boolean isDone;
}
