package com.example.digitom.domain.taskresponsepicture;

import com.example.digitom.service.image.TaskPictureRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.nio.charset.StandardCharsets;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TaskResponsePictureMapper {

    @Mapping(target = "taskResponse.id", source = "taskResponseId")
    @Mapping(target = "base64", source = "base64", qualifiedByName = "stringToByteArray")
    TaskResponsePicture requestToTaskResponsePicture(TaskPictureRequest taskPictureRequest);

    @Named("stringToByteArray")
    static byte[] stringToByteArray(String base64) {
        return base64.getBytes(StandardCharsets.UTF_8);
    }
}
