package com.example.digitom.domain.reportpicture;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ReportPictureDto implements Serializable {
    private final Integer id;
    private final Integer reportId;
    private final Integer reportConstructionSiteId;
    private final String reportConstructionSiteName;
    private final String reportConstructionSiteAddress;
    private final Integer reportConstructionSiteLatitude;
    private final Integer reportConstructionSiteLongitude;
    private final LocalDate reportDate;
    private final Integer taskId;
    private final Integer taskReportId;
    private final Integer taskReportConstructionSiteId;
    private final String taskReportConstructionSiteName;
    private final String taskReportConstructionSiteAddress;
    private final Integer taskReportConstructionSiteLatitude;
    private final Integer taskReportConstructionSiteLongitude;
    private final LocalDate taskReportDate;
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
    private final Integer taskCompanyId;
    private final String taskCompanyName;
    private final Integer taskCompanyRegNumber;
    private final String taskDescription;
    private final LocalDate taskDeadline;
    private final Boolean taskIsDone;
    private final String description;
    private final byte[] base64;
}
