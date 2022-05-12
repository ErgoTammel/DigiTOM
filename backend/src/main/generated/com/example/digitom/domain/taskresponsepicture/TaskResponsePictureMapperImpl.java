package com.example.digitom.domain.taskresponsepicture;

import com.example.digitom.domain.taskresponse.TaskResponse;
import com.example.digitom.service.image.TaskPictureRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-12T14:39:04+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class TaskResponsePictureMapperImpl implements TaskResponsePictureMapper {

    @Override
    public TaskResponsePicture requestToTaskResponsePicture(TaskPictureRequest taskPictureRequest) {
        if ( taskPictureRequest == null ) {
            return null;
        }

        TaskResponsePicture taskResponsePicture = new TaskResponsePicture();

        taskResponsePicture.setTaskResponse( taskPictureRequestToTaskResponse( taskPictureRequest ) );
        taskResponsePicture.setBase64( TaskResponsePictureMapper.stringToByteArray( taskPictureRequest.getBase64() ) );

        return taskResponsePicture;
    }

    protected TaskResponse taskPictureRequestToTaskResponse(TaskPictureRequest taskPictureRequest) {
        if ( taskPictureRequest == null ) {
            return null;
        }

        TaskResponse taskResponse = new TaskResponse();

        taskResponse.setId( taskPictureRequest.getTaskResponseId() );

        return taskResponse;
    }
}
