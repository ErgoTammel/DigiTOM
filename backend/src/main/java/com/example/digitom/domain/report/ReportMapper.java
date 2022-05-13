package com.example.digitom.domain.report;

import com.example.digitom.service.account.reportmanagement.FindReportRequest;
import com.example.digitom.service.account.reportmanagement.ReportResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ReportMapper {

    @Mapping(target = "constructionSite.name", source = "constructionSiteName")
    Report requestToReport(FindReportRequest findReportRequest);

    @Mapping(target = "reportId", source = "id")
    @Mapping(target = "constructionSiteName", source = "constructionSite.name")
    @Mapping(target = "inspectorName", ignore=true)
    ReportResponse reportToResponse(Report report);

    List<ReportResponse> reportToResponses(List<Report> reports);
}
