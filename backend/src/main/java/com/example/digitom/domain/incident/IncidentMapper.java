package com.example.digitom.domain.incident;

import com.example.digitom.service.inspection.IncidentRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IncidentMapper {

    @Mapping(target = "safetyField.id", source = "safetyFieldId")
    @Mapping(target = "report.id", source = "reportId")
    @Mapping(target = "safe", source = "safe")
    Incident incidentRequestToIncident(IncidentRequest incidentRequest);
}
