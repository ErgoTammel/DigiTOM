package com.example.digitom.domain.taskresponse;

import com.example.digitom.domain.task.Task;
import com.example.digitom.service.reportmanagement.TaskResponseRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-11T14:59:22+0300",
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
        taskResponse.setTime( taskResponseRequest.getTime() );

        return taskResponse;
    }

    protected Task taskResponseRequestToTask(TaskResponseRequest taskResponseRequest) {
        if ( taskResponseRequest == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( taskResponseRequest.getTaskId() );

        return task;
    }
}
