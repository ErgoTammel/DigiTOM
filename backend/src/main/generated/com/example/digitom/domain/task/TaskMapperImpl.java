package com.example.digitom.domain.task;

import com.example.digitom.domain.company.Company;
import com.example.digitom.domain.incident.Incident;
import com.example.digitom.domain.report.Report;
import com.example.digitom.service.account.inspection.ReportOverviewResponse;
import com.example.digitom.service.reportmanagement.TaskOverviewResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-12T15:15:53+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public ReportOverviewResponse taskToReportOverviewResponse(Task task) {
        if ( task == null ) {
            return null;
        }

        ReportOverviewResponse reportOverviewResponse = new ReportOverviewResponse();

        reportOverviewResponse.setCompanyName( taskCompanyName( task ) );
        reportOverviewResponse.setDescription( task.getDescription() );
        reportOverviewResponse.setDeadline( task.getDeadline() );

        return reportOverviewResponse;
    }

    @Override
    public List<ReportOverviewResponse> taskToReportOverviewResponses(List<Task> tasks) {
        if ( tasks == null ) {
            return null;
        }

        List<ReportOverviewResponse> list = new ArrayList<ReportOverviewResponse>( tasks.size() );
        for ( Task task : tasks ) {
            list.add( taskToReportOverviewResponse( task ) );
        }

        return list;
    }

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

    @Override
    public TaskOverviewResponse taskToResponse(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskOverviewResponse taskOverviewResponse = new TaskOverviewResponse();

        taskOverviewResponse.setTaskId( task.getId() );
        taskOverviewResponse.setDeadline( task.getDeadline() );
        taskOverviewResponse.setDescription( task.getDescription() );

        return taskOverviewResponse;
    }

    private String taskCompanyName(Task task) {
        if ( task == null ) {
            return null;
        }
        Company company = task.getCompany();
        if ( company == null ) {
            return null;
        }
        String name = company.getName();
        if ( name == null ) {
            return null;
        }
        return name;
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
