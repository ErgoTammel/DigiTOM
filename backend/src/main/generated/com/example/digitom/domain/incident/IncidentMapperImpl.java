package com.example.digitom.domain.incident;

import com.example.digitom.domain.report.Report;
import com.example.digitom.domain.safetyfield.SafetyField;
import com.example.digitom.service.inspection.IncidentRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-12T11:51:52+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class IncidentMapperImpl implements IncidentMapper {

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
