package com.example.digitom.domain.taskresponsepicture;

import com.example.digitom.service.image.TaskPictureRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.nio.charset.StandardCharsets;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TaskResponsePictureMapper {


    @Named("stringToByteArray")
    static byte[] stringToByteArray(String base64) {
        return base64.getBytes(StandardCharsets.UTF_8);
    }
}
