package com.example.digitom.domain.reportpicture;

import com.example.digitom.service.image.ReportPictureRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.nio.charset.StandardCharsets;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReportPictureMapper {
//    @Mapping(source = "reportId", target = "report.id")
//    @Mapping(source = "reportConstructionSiteId", target = "constructionSite.id")
//    @Mapping(source = "reportConstructionSiteName", target = "constructionSite.name")
//    @Mapping(source = "reportConstructionSiteAddress", target = "constructionSite.address")
//    @Mapping(source = "reportConstructionSiteLatitude", target = "constructionSite.latitude")
//    @Mapping(source = "reportConstructionSiteLongitude", target = "constructionSite.longitude")
//    @Mapping(source = "reportDate", target = "report.date")
//    @Mapping(source = "taskId", target = "task.id")
//    @Mapping(source = "taskReportId", target = "report.id")
//    @Mapping(source = "taskReportConstructionSiteId", target = "constructionSite.id")
//    @Mapping(source = "taskReportConstructionSiteName", target = "constructionSite.name")
//    @Mapping(source = "taskReportConstructionSiteAddress", target = "constructionSite.address")
//    @Mapping(source = "taskReportConstructionSiteLatitude", target = "constructionSite.latitude")
//    @Mapping(source = "taskReportConstructionSiteLongitude", target = "constructionSite.longitude")
//    @Mapping(source = "taskReportDate", target = "report.date")
//    @Mapping(source = "taskIncidentId", target = "incident.id")
//    @Mapping(source = "taskIncidentSafe", target = "incident.safe")
//    @Mapping(source = "taskIncidentSafetyFieldId", target = "safetyField.id")
//    @Mapping(source = "taskIncidentSafetyFieldFieldNumber", target = "safetyField.fieldNumber")
//    @Mapping(source = "taskIncidentSafetyFieldFieldDescription", target = "safetyField.fieldDescription")
//    @Mapping(source = "taskIncidentReportId", target = "report.id")
//    @Mapping(source = "taskIncidentReportConstructionSiteId", target = "constructionSite.id")
//    @Mapping(source = "taskIncidentReportConstructionSiteName", target = "constructionSite.name")
//    @Mapping(source = "taskIncidentReportConstructionSiteAddress", target = "constructionSite.address")
//    @Mapping(source = "taskIncidentReportConstructionSiteLatitude", target = "constructionSite.latitude")
//    @Mapping(source = "taskIncidentReportConstructionSiteLongitude", target = "constructionSite.longitude")
//    @Mapping(source = "taskIncidentReportDate", target = "report.date")
//    @Mapping(source = "taskCompanyId", target = "company.id")
//    @Mapping(source = "taskCompanyName", target = "company.name")
//    @Mapping(source = "taskCompanyRegNumber", target = "company.regNumber")
//    @Mapping(source = "taskDescription", target = "task.description")
//    @Mapping(source = "taskDeadline", target = "task.deadline")
//    @Mapping(source = "taskIsDone", target = "task.isDone")
//    ReportPicture reportPictureDtoToReportPicture(ReportPictureDto reportPictureDto);

    @Mapping(target = "report.id", source = "reportId")
    @Mapping(target = "task.id", source = "taskId")
    @Mapping(target = "base64", source = "base64", qualifiedByName = "stringToByteArray")
    ReportPicture requestToReportPicture(ReportPictureRequest reportPictureRequest);

    @Named("stringToByteArray")
    static byte[] stringToByteArray(String base64) {
        return base64.getBytes(StandardCharsets.UTF_8);
    }

}
