package com.example.digitom.domain.reportpicture;

import com.example.digitom.service.image.ReportPictureRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.nio.charset.StandardCharsets;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReportPictureMapper {

    @Mapping(target = "report.id", source = "reportId")
    @Mapping(target = "task.id", source = "taskId")
    @Mapping(target = "base64", source = "base64", qualifiedByName = "stringToByteArray")
    ReportPicture requestToReportPicture(ReportPictureRequest reportPictureRequest);

    @Named("stringToByteArray")
    static byte[] stringToByteArray(String base64) {
        return base64.getBytes(StandardCharsets.UTF_8);
    }

}
