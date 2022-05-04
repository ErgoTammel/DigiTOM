package com.example.digitom.domain.incident;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IncidentMapper {
    @Mapping(source = "safetyFieldId", target = "safetyField.id")
    @Mapping(source = "safetyFieldFieldNumber", target = "safetyField.fieldNumber")
    @Mapping(source = "safetyFieldFieldDescription", target = "safetyField.fieldDescription")
    @Mapping(source = "reportId", target = "report.id")
    @Mapping(source = "reportDate", target = "report.date")
    Incident incidentDtoToIncident(IncidentDto incidentDto);

    @InheritInverseConfiguration(name = "incidentDtoToIncident")
    IncidentDto incidentToIncidentDto(Incident incident);

    @InheritConfiguration(name = "incidentDtoToIncident")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateIncidentFromIncidentDto(IncidentDto incidentDto, @MappingTarget Incident incident);

    @Mapping(target = "safetyField.id", source = "safetyFieldId")
    @Mapping(target = "report.id", source = "reportId")
    Incident incidentRequestToIncident (IncidentRequest incidentRequest);
}
