package com.example.digitom.domain.task;

import com.example.digitom.service.inspection.ReportOverviewResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")

public interface TaskMapper {

    @Mapping(target = "companyName", source = "company.name")
    ReportOverviewResponse taskToReportOverviewResponse (Task task);

    List<ReportOverviewResponse> taskToReportOverviewResponses (List<Task> tasks);

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
