package com.example.digitom.domain.taskresponse;

import com.example.digitom.service.reportmanagement.TaskResponseRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TaskResponseMapper {

    @Mapping(target = "task.id", source = "taskId")
    TaskResponse requestToTaskResponse (TaskResponseRequest taskResponseRequest);




}
