package com.example.digitom.domain.task;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TaskMapper {
//    @Mapping(source = "safetyFieldId", target = "safetyField.id")
//    @Mapping(source = "safetyFieldFieldNumber", target = "safetyField.fieldNumber")
//    @Mapping(source = "safetyFieldFieldDescription", target = "safetyField.fieldDescription")
//    @Mapping(source = "reportId", target = "report.id")
//    @Mapping(source = "reportConstructionSiteId", target = "constructionSite.id")
//    @Mapping(source = "reportConstructionSiteName", target = "constructionSite.name")
//    @Mapping(source = "reportConstructionSiteAddress", target = "constructionSite.address")
//    @Mapping(source = "reportConstructionSiteLatitude", target = "constructionSite.latitude")
//    @Mapping(source = "reportConstructionSiteLongitude", target = "constructionSite.longitude")
//    @Mapping(source = "reportDate", target = "report.date")
//    Task taskDtoToTask(TaskDto taskDto);

//    @InheritInverseConfiguration(name = "taskDtoToTask")
//    TaskDto taskToTaskDto(Task task);


    Task taskRequestToTask(TaskRequest taskRequest);

//    @InheritConfiguration(name = "taskDtoToTask")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateTaskFromTaskDto(TaskDto taskDto, @MappingTarget Task task);
}
