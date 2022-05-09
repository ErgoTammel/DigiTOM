package com.example.digitom.domain.taskresponsepicture;

import com.example.digitom.service.image.TaskPictureRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.nio.charset.StandardCharsets;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TaskResponsePictureMapper {
//    @Mapping(source = "taskResponseId", target = "taskResponse.id")
//    @Mapping(source = "taskResponseTaskId", target = "task.id")
//    @Mapping(source = "taskResponseTaskReportId", target = "report.id")
//    @Mapping(source = "taskResponseTaskReportConstructionSiteId", target = "constructionSite.id")
//    @Mapping(source = "taskResponseTaskReportConstructionSiteName", target = "constructionSite.name")
//    @Mapping(source = "taskResponseTaskReportConstructionSiteAddress", target = "constructionSite.address")
//    @Mapping(source = "taskResponseTaskReportConstructionSiteLatitude", target = "constructionSite.latitude")
//    @Mapping(source = "taskResponseTaskReportConstructionSiteLongitude", target = "constructionSite.longitude")
//    @Mapping(source = "taskResponseTaskReportDate", target = "report.date")
//    @Mapping(source = "taskResponseTaskReportTom", target = "report.tom")
//    @Mapping(source = "taskResponseTaskIncidentId", target = "incident.id")
//    @Mapping(source = "taskResponseTaskIncidentSafe", target = "incident.safe")
//    @Mapping(source = "taskResponseTaskIncidentSafetyFieldId", target = "safetyField.id")
//    @Mapping(source = "taskResponseTaskIncidentSafetyFieldFieldNumber", target = "safetyField.fieldNumber")
//    @Mapping(source = "taskResponseTaskIncidentSafetyFieldFieldDescription", target = "safetyField.fieldDescription")
//    @Mapping(source = "taskResponseTaskIncidentReportId", target = "report.id")
//    @Mapping(source = "taskResponseTaskIncidentReportConstructionSiteId", target = "constructionSite.id")
//    @Mapping(source = "taskResponseTaskIncidentReportConstructionSiteName", target = "constructionSite.name")
//    @Mapping(source = "taskResponseTaskIncidentReportConstructionSiteAddress", target = "constructionSite.address")
//    @Mapping(source = "taskResponseTaskIncidentReportConstructionSiteLatitude", target = "constructionSite.latitude")
//    @Mapping(source = "taskResponseTaskIncidentReportConstructionSiteLongitude", target = "constructionSite.longitude")
//    @Mapping(source = "taskResponseTaskIncidentReportDate", target = "report.date")
//    @Mapping(source = "taskResponseTaskIncidentReportTom", target = "report.tom")
//    @Mapping(source = "taskResponseTaskCompanyId", target = "company.id")
//    @Mapping(source = "taskResponseTaskCompanyName", target = "company.name")
//    @Mapping(source = "taskResponseTaskCompanyRegNumber", target = "company.regNumber")
//    @Mapping(source = "taskResponseTaskDescription", target = "task.description")
//    @Mapping(source = "taskResponseTaskDeadline", target = "task.deadline")
//    @Mapping(source = "taskResponseTaskIsDone", target = "task.isDone")
//    @Mapping(source = "taskResponseDescription", target = "taskResponse.description")
//    @Mapping(source = "taskResponseTime", target = "taskResponse.time")

    @Mapping(target = "taskResponse.id", source = "taskResponseId")
    @Mapping(target = "base64", source = "base64", qualifiedByName = "stringToByteArray")
    TaskResponsePicture requestToTaskResponsePicture(TaskPictureRequest taskPictureRequest);

    @Named("stringToByteArray")
    static byte[] stringToByteArray(String base64) {
        return base64.getBytes(StandardCharsets.UTF_8);
    }
}
