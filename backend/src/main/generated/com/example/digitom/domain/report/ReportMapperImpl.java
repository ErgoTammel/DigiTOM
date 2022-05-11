package com.example.digitom.domain.report;

import com.example.digitom.domain.constructionsite.ConstructionSite;
import com.example.digitom.service.reportmanagement.FindReportRequest;
import com.example.digitom.service.reportmanagement.ReportResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-10T14:28:45+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class ReportMapperImpl implements ReportMapper {

    @Override
    public Report reportDtoToReport(ReportDto reportDto) {
        if ( reportDto == null ) {
            return null;
        }

        Report report = new Report();

        report.setConstructionSite( reportDtoToConstructionSite( reportDto ) );
        report.setId( reportDto.getId() );
        report.setDate( reportDto.getDate() );
        report.setTom( reportDto.getTom() );

        return report;
    }

    @Override
    public ReportDto reportToReportDto(Report report) {
        if ( report == null ) {
            return null;
        }

        Integer constructionSiteId = null;
        String constructionSiteName = null;
        String constructionSiteAddress = null;
        Integer constructionSiteLatitude = null;
        Integer constructionSiteLongitude = null;
        Integer id = null;
        LocalDate date = null;
        BigDecimal tom = null;

        constructionSiteId = reportConstructionSiteId( report );
        constructionSiteName = reportConstructionSiteName( report );
        constructionSiteAddress = reportConstructionSiteAddress( report );
        constructionSiteLatitude = reportConstructionSiteLatitude( report );
        constructionSiteLongitude = reportConstructionSiteLongitude( report );
        id = report.getId();
        date = report.getDate();
        tom = report.getTom();

        ReportDto reportDto = new ReportDto( id, constructionSiteId, constructionSiteName, constructionSiteAddress, constructionSiteLatitude, constructionSiteLongitude, date, tom );

        return reportDto;
    }

    @Override
    public void updateReportFromReportDto(ReportDto reportDto, Report report) {
        if ( reportDto == null ) {
            return;
        }

        if ( report.getConstructionSite() == null ) {
            report.setConstructionSite( new ConstructionSite() );
        }
        reportDtoToConstructionSite1( reportDto, report.getConstructionSite() );
        if ( reportDto.getId() != null ) {
            report.setId( reportDto.getId() );
        }
        if ( reportDto.getDate() != null ) {
            report.setDate( reportDto.getDate() );
        }
        if ( reportDto.getTom() != null ) {
            report.setTom( reportDto.getTom() );
        }
    }

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

    protected ConstructionSite reportDtoToConstructionSite(ReportDto reportDto) {
        if ( reportDto == null ) {
            return null;
        }

        ConstructionSite constructionSite = new ConstructionSite();

        constructionSite.setId( reportDto.getConstructionSiteId() );
        constructionSite.setName( reportDto.getConstructionSiteName() );
        constructionSite.setAddress( reportDto.getConstructionSiteAddress() );
        constructionSite.setLatitude( reportDto.getConstructionSiteLatitude() );
        constructionSite.setLongitude( reportDto.getConstructionSiteLongitude() );

        return constructionSite;
    }

    private Integer reportConstructionSiteId(Report report) {
        if ( report == null ) {
            return null;
        }
        ConstructionSite constructionSite = report.getConstructionSite();
        if ( constructionSite == null ) {
            return null;
        }
        Integer id = constructionSite.getId();
        if ( id == null ) {
            return null;
        }
        return id;
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

    private String reportConstructionSiteAddress(Report report) {
        if ( report == null ) {
            return null;
        }
        ConstructionSite constructionSite = report.getConstructionSite();
        if ( constructionSite == null ) {
            return null;
        }
        String address = constructionSite.getAddress();
        if ( address == null ) {
            return null;
        }
        return address;
    }

    private Integer reportConstructionSiteLatitude(Report report) {
        if ( report == null ) {
            return null;
        }
        ConstructionSite constructionSite = report.getConstructionSite();
        if ( constructionSite == null ) {
            return null;
        }
        Integer latitude = constructionSite.getLatitude();
        if ( latitude == null ) {
            return null;
        }
        return latitude;
    }

    private Integer reportConstructionSiteLongitude(Report report) {
        if ( report == null ) {
            return null;
        }
        ConstructionSite constructionSite = report.getConstructionSite();
        if ( constructionSite == null ) {
            return null;
        }
        Integer longitude = constructionSite.getLongitude();
        if ( longitude == null ) {
            return null;
        }
        return longitude;
    }

    protected void reportDtoToConstructionSite1(ReportDto reportDto, ConstructionSite mappingTarget) {
        if ( reportDto == null ) {
            return;
        }

        if ( reportDto.getConstructionSiteId() != null ) {
            mappingTarget.setId( reportDto.getConstructionSiteId() );
        }
        if ( reportDto.getConstructionSiteName() != null ) {
            mappingTarget.setName( reportDto.getConstructionSiteName() );
        }
        if ( reportDto.getConstructionSiteAddress() != null ) {
            mappingTarget.setAddress( reportDto.getConstructionSiteAddress() );
        }
        if ( reportDto.getConstructionSiteLatitude() != null ) {
            mappingTarget.setLatitude( reportDto.getConstructionSiteLatitude() );
        }
        if ( reportDto.getConstructionSiteLongitude() != null ) {
            mappingTarget.setLongitude( reportDto.getConstructionSiteLongitude() );
        }
    }

    protected ConstructionSite findReportRequestToConstructionSite(FindReportRequest findReportRequest) {
        if ( findReportRequest == null ) {
            return null;
        }

        ConstructionSite constructionSite = new ConstructionSite();

        constructionSite.setName( findReportRequest.getConstructionSiteName() );

        return constructionSite;
    }
}
