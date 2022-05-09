package com.example.digitom.domain.task;

import com.example.digitom.domain.company.Company;
import com.example.digitom.domain.incident.Incident;
import com.example.digitom.domain.report.Report;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-08T22:38:44+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task taskRequestToTask(TaskRequest taskRequest) {
        if ( taskRequest == null ) {
            return null;
        }

        Task task = new Task();

        task.setReport( taskRequestToReport( taskRequest ) );
        task.setIncident( taskRequestToIncident( taskRequest ) );
        task.setCompany( taskRequestToCompany( taskRequest ) );
        task.setDeadline( addDays( taskRequest.getDeadline() ) );
        task.setDescription( taskRequest.getDescription() );

        return task;
    }

    protected Report taskRequestToReport(TaskRequest taskRequest) {
        if ( taskRequest == null ) {
            return null;
        }

        Report report = new Report();

        report.setId( taskRequest.getReportId() );

        return report;
    }

    protected Incident taskRequestToIncident(TaskRequest taskRequest) {
        if ( taskRequest == null ) {
            return null;
        }

        Incident incident = new Incident();

        incident.setId( taskRequest.getIncidentId() );

        return incident;
    }

    protected Company taskRequestToCompany(TaskRequest taskRequest) {
        if ( taskRequest == null ) {
            return null;
        }

        Company company = new Company();

        company.setId( taskRequest.getCompanyId() );

        return company;
    }
}
