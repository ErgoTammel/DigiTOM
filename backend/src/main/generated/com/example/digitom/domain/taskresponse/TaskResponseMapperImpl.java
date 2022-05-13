package com.example.digitom.domain.taskresponse;

import com.example.digitom.domain.task.Task;
import com.example.digitom.service.reportmanagement.TaskResponseRequest;
import java.time.Instant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-13T15:07:25+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class TaskResponseMapperImpl implements TaskResponseMapper {

    @Override
    public TaskResponse requestToTaskResponse(TaskResponseRequest taskResponseRequest) {
        if ( taskResponseRequest == null ) {
            return null;
        }

        TaskResponse taskResponse = new TaskResponse();

        taskResponse.setTask( taskResponseRequestToTask( taskResponseRequest ) );
        taskResponse.setDescription( taskResponseRequest.getDescription() );

        return taskResponse;
    }

    @Override
    public TaskResponseDto toDto(TaskResponse taskResponse) {
        if ( taskResponse == null ) {
            return null;
        }

        Integer taskId = null;
        Integer id = null;
        String description = null;
        Instant time = null;

        taskId = taskResponseTaskId( taskResponse );
        id = taskResponse.getId();
        description = taskResponse.getDescription();
        time = taskResponse.getTime();

        TaskResponseDto taskResponseDto = new TaskResponseDto( id, taskId, description, time );

        return taskResponseDto;
    }

    protected Task taskResponseRequestToTask(TaskResponseRequest taskResponseRequest) {
        if ( taskResponseRequest == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( taskResponseRequest.getTaskId() );

        return task;
    }

    private Integer taskResponseTaskId(TaskResponse taskResponse) {
        if ( taskResponse == null ) {
            return null;
        }
        Task task = taskResponse.getTask();
        if ( task == null ) {
            return null;
        }
        Integer id = task.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
