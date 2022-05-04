package com.example.digitom.domain.incident;

import com.example.digitom.domain.report.Report;
import com.example.digitom.domain.safetyfield.SafetyField;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-04T14:20:04+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class IncidentMapperImpl implements IncidentMapper {

    @Override
    public Incident incidentDtoToIncident(IncidentDto incidentDto) {
        if ( incidentDto == null ) {
            return null;
        }

        Incident incident = new Incident();

        incident.setSafetyField( incidentDtoToSafetyField( incidentDto ) );
        incident.setReport( incidentDtoToReport( incidentDto ) );
        incident.setId( incidentDto.getId() );
        incident.setSafe( incidentDto.getSafe() );

        return incident;
    }

    @Override
    public IncidentDto incidentToIncidentDto(Incident incident) {
        if ( incident == null ) {
            return null;
        }

        Integer safetyFieldId = null;
        Integer safetyFieldFieldNumber = null;
        String safetyFieldFieldDescription = null;
        Integer reportId = null;
        LocalDate reportDate = null;
        Integer id = null;
        Boolean safe = null;

        safetyFieldId = incidentSafetyFieldId( incident );
        safetyFieldFieldNumber = incidentSafetyFieldFieldNumber( incident );
        safetyFieldFieldDescription = incidentSafetyFieldFieldDescription( incident );
        reportId = incidentReportId( incident );
        reportDate = incidentReportDate( incident );
        id = incident.getId();
        safe = incident.getSafe();

        IncidentDto incidentDto = new IncidentDto( id, safe, safetyFieldId, safetyFieldFieldNumber, safetyFieldFieldDescription, reportId, reportDate );

        return incidentDto;
    }

    @Override
    public void updateIncidentFromIncidentDto(IncidentDto incidentDto, Incident incident) {
        if ( incidentDto == null ) {
            return;
        }

        if ( incident.getSafetyField() == null ) {
            incident.setSafetyField( new SafetyField() );
        }
        incidentDtoToSafetyField1( incidentDto, incident.getSafetyField() );
        if ( incident.getReport() == null ) {
            incident.setReport( new Report() );
        }
        incidentDtoToReport1( incidentDto, incident.getReport() );
        if ( incidentDto.getId() != null ) {
            incident.setId( incidentDto.getId() );
        }
        if ( incidentDto.getSafe() != null ) {
            incident.setSafe( incidentDto.getSafe() );
        }
    }

    @Override
    public Incident incidentRequestToIncident(IncidentRequest incidentRequest) {
        if ( incidentRequest == null ) {
            return null;
        }

        Incident incident = new Incident();

        incident.setSafetyField( incidentRequestToSafetyField( incidentRequest ) );
        incident.setReport( incidentRequestToReport( incidentRequest ) );
        incident.setSafe( incidentRequest.getSafe() );

        return incident;
    }

    protected SafetyField incidentDtoToSafetyField(IncidentDto incidentDto) {
        if ( incidentDto == null ) {
            return null;
        }

        SafetyField safetyField = new SafetyField();

        safetyField.setId( incidentDto.getSafetyFieldId() );
        safetyField.setFieldNumber( incidentDto.getSafetyFieldFieldNumber() );
        safetyField.setFieldDescription( incidentDto.getSafetyFieldFieldDescription() );

        return safetyField;
    }

    protected Report incidentDtoToReport(IncidentDto incidentDto) {
        if ( incidentDto == null ) {
            return null;
        }

        Report report = new Report();

        report.setId( incidentDto.getReportId() );
        report.setDate( incidentDto.getReportDate() );

        return report;
    }

    private Integer incidentSafetyFieldId(Incident incident) {
        if ( incident == null ) {
            return null;
        }
        SafetyField safetyField = incident.getSafetyField();
        if ( safetyField == null ) {
            return null;
        }
        Integer id = safetyField.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer incidentSafetyFieldFieldNumber(Incident incident) {
        if ( incident == null ) {
            return null;
        }
        SafetyField safetyField = incident.getSafetyField();
        if ( safetyField == null ) {
            return null;
        }
        Integer fieldNumber = safetyField.getFieldNumber();
        if ( fieldNumber == null ) {
            return null;
        }
        return fieldNumber;
    }

    private String incidentSafetyFieldFieldDescription(Incident incident) {
        if ( incident == null ) {
            return null;
        }
        SafetyField safetyField = incident.getSafetyField();
        if ( safetyField == null ) {
            return null;
        }
        String fieldDescription = safetyField.getFieldDescription();
        if ( fieldDescription == null ) {
            return null;
        }
        return fieldDescription;
    }

    private Integer incidentReportId(Incident incident) {
        if ( incident == null ) {
            return null;
        }
        Report report = incident.getReport();
        if ( report == null ) {
            return null;
        }
        Integer id = report.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private LocalDate incidentReportDate(Incident incident) {
        if ( incident == null ) {
            return null;
        }
        Report report = incident.getReport();
        if ( report == null ) {
            return null;
        }
        LocalDate date = report.getDate();
        if ( date == null ) {
            return null;
        }
        return date;
    }

    protected void incidentDtoToSafetyField1(IncidentDto incidentDto, SafetyField mappingTarget) {
        if ( incidentDto == null ) {
            return;
        }

        if ( incidentDto.getSafetyFieldId() != null ) {
            mappingTarget.setId( incidentDto.getSafetyFieldId() );
        }
        if ( incidentDto.getSafetyFieldFieldNumber() != null ) {
            mappingTarget.setFieldNumber( incidentDto.getSafetyFieldFieldNumber() );
        }
        if ( incidentDto.getSafetyFieldFieldDescription() != null ) {
            mappingTarget.setFieldDescription( incidentDto.getSafetyFieldFieldDescription() );
        }
    }

    protected void incidentDtoToReport1(IncidentDto incidentDto, Report mappingTarget) {
        if ( incidentDto == null ) {
            return;
        }

        if ( incidentDto.getReportId() != null ) {
            mappingTarget.setId( incidentDto.getReportId() );
        }
        if ( incidentDto.getReportDate() != null ) {
            mappingTarget.setDate( incidentDto.getReportDate() );
        }
    }

    protected SafetyField incidentRequestToSafetyField(IncidentRequest incidentRequest) {
        if ( incidentRequest == null ) {
            return null;
        }

        SafetyField safetyField = new SafetyField();

        safetyField.setId( incidentRequest.getSafetyFieldId() );

        return safetyField;
    }

    protected Report incidentRequestToReport(IncidentRequest incidentRequest) {
        if ( incidentRequest == null ) {
            return null;
        }

        Report report = new Report();

        report.setId( incidentRequest.getReportId() );

        return report;
    }
}
