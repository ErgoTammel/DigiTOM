package com.example.digitom.domain.taskresponsepicture;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Data
public class TaskResponsePictureDto implements Serializable {
    private final Integer id;
    private final Integer taskResponseId;
    private final Integer taskResponseTaskId;
    private final Integer taskResponseTaskReportId;
    private final Integer taskResponseTaskReportConstructionSiteId;
    private final String taskResponseTaskReportConstructionSiteName;
    private final String taskResponseTaskReportConstructionSiteAddress;
    private final Integer taskResponseTaskReportConstructionSiteLatitude;
    private final Integer taskResponseTaskReportConstructionSiteLongitude;
    private final LocalDate taskResponseTaskReportDate;
    private final BigDecimal taskResponseTaskReportTom;
    private final Integer taskResponseTaskIncidentId;
    private final Boolean taskResponseTaskIncidentSafe;
    private final Integer taskResponseTaskIncidentSafetyFieldId;
    private final Integer taskResponseTaskIncidentSafetyFieldFieldNumber;
    private final String taskResponseTaskIncidentSafetyFieldFieldDescription;
    private final Integer taskResponseTaskIncidentReportId;
    private final Integer taskResponseTaskIncidentReportConstructionSiteId;
    private final String taskResponseTaskIncidentReportConstructionSiteName;
    private final String taskResponseTaskIncidentReportConstructionSiteAddress;
    private final Integer taskResponseTaskIncidentReportConstructionSiteLatitude;
    private final Integer taskResponseTaskIncidentReportConstructionSiteLongitude;
    private final LocalDate taskResponseTaskIncidentReportDate;
    private final BigDecimal taskResponseTaskIncidentReportTom;
    private final Integer taskResponseTaskCompanyId;
    private final String taskResponseTaskCompanyName;
    private final Integer taskResponseTaskCompanyRegNumber;
    private final String taskResponseTaskDescription;
    private final LocalDate taskResponseTaskDeadline;
    private final Boolean taskResponseTaskIsDone;
    private final String taskResponseDescription;
    private final Instant taskResponseTime;
    private final byte[] base64;
}
