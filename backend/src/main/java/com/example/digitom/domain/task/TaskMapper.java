package com.example.digitom.domain.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")

public interface TaskMapper {
//    @Mapping(source = "reportId", target = "report.id")
//    @Mapping(source = "reportConstructionSiteId", target = "constructionSite.id")
//    @Mapping(source = "reportConstructionSiteName", target = "constructionSite.name")
//    @Mapping(source = "reportConstructionSiteAddress", target = "constructionSite.address")
//    @Mapping(source = "reportConstructionSiteLatitude", target = "constructionSite.latitude")
//    @Mapping(source = "reportConstructionSiteLongitude", target = "constructionSite.longitude")
//    @Mapping(source = "reportDate", target = "report.date")
//    @Mapping(source = "incidentId", target = "incident.id")
//    @Mapping(source = "incidentSafe", target = "incident.safe")
//    @Mapping(source = "incidentSafetyFieldId", target = "safetyField.id")
//    @Mapping(source = "incidentSafetyFieldFieldNumber", target = "safetyField.fieldNumber")
//    @Mapping(source = "incidentSafetyFieldFieldDescription", target = "safetyField.fieldDescription")
//    @Mapping(source = "incidentReportId", target = "report.id")
//    @Mapping(source = "incidentReportConstructionSiteId", target = "constructionSite.id")
//    @Mapping(source = "incidentReportConstructionSiteName", target = "constructionSite.name")
//    @Mapping(source = "incidentReportConstructionSiteAddress", target = "constructionSite.address")
//    @Mapping(source = "incidentReportConstructionSiteLatitude", target = "constructionSite.latitude")
//    @Mapping(source = "incidentReportConstructionSiteLongitude", target = "constructionSite.longitude")
//    @Mapping(source = "incidentReportDate", target = "report.date")
//    @Mapping(source = "companyId", target = "company.id")
//    @Mapping(source = "companyName", target = "company.name")
//    @Mapping(source = "companyRegNumber", target = "company.regNumber")
//    Task taskDtoToTask(TaskDto taskDto);

    @Mapping(target = "report.id", source = "reportId")
    @Mapping(target = "incident.id", source = "incidentId")
    @Mapping(target = "company.id", source = "companyId")
    @Mapping(target = "deadline", source = "deadline", qualifiedByName = "addDays")
    Task taskRequestToTask(TaskRequest taskRequest);

    @Named("addDays")
    default LocalDate addDays (Integer deadline) {
        return LocalDate.now().plusDays(deadline);

    }
}
