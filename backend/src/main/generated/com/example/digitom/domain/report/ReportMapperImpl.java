package com.example.digitom.domain.report;

import com.example.digitom.domain.constructionsite.ConstructionSite;
import com.example.digitom.service.reportmanagement.FindReportRequest;
import com.example.digitom.service.reportmanagement.ReportResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-12T14:39:04+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class ReportMapperImpl implements ReportMapper {

    @Override
    public Report requestToReport(FindReportRequest findReportRequest) {
        if ( findReportRequest == null ) {
            return null;
        }

        Report report = new Report();

        report.setConstructionSite( findReportRequestToConstructionSite( findReportRequest ) );
        report.setDate( findReportRequest.getDate() );

        return report;
    }

    @Override
    public ReportResponse reportToResponse(Report report) {
        if ( report == null ) {
            return null;
        }

        ReportResponse reportResponse = new ReportResponse();

        reportResponse.setReportId( report.getId() );
        reportResponse.setConstructionSiteName( reportConstructionSiteName( report ) );
        reportResponse.setDate( report.getDate() );
        reportResponse.setTom( report.getTom() );

        return reportResponse;
    }

    @Override
    public List<ReportResponse> reportToResponses(List<Report> reports) {
        if ( reports == null ) {
            return null;
        }

        List<ReportResponse> list = new ArrayList<ReportResponse>( reports.size() );
        for ( Report report : reports ) {
            list.add( reportToResponse( report ) );
        }

        return list;
    }

    protected ConstructionSite findReportRequestToConstructionSite(FindReportRequest findReportRequest) {
        if ( findReportRequest == null ) {
            return null;
        }

        ConstructionSite constructionSite = new ConstructionSite();

        constructionSite.setName( findReportRequest.getConstructionSiteName() );

        return constructionSite;
    }

    private String reportConstructionSiteName(Report report) {
        if ( report == null ) {
            return null;
        }
        ConstructionSite constructionSite = report.getConstructionSite();
        if ( constructionSite == null ) {
            return null;
        }
        String name = constructionSite.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
