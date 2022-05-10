package com.example.digitom.domain.report;

import com.example.digitom.domain.companyconstructionsite.CompanyConstructionSiteService;
import com.example.digitom.domain.companyuser.CompanyUserService;
import com.example.digitom.domain.constructionsite.ConstructionSite;
import com.example.digitom.domain.constructionsite.ConstructionSiteService;
import com.example.digitom.domain.incident.IncidentService;
import com.example.digitom.domain.reportpicture.ReportPictureService;
import com.example.digitom.domain.task.TaskService;
import com.example.digitom.service.constractionsitemanagement.CompanyNameResponse;
import com.example.digitom.service.inspection.ReportResultResponse;
import com.example.digitom.service.reportmanagement.CompanyConstructionSiteResponse;
import com.example.digitom.service.reportmanagement.FindReportRequest;
import com.example.digitom.service.reportmanagement.ReportResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ReportService {

    @Resource
    private ConstructionSiteService constructionSiteService;
    @Resource
    private ReportRepository reportRepository;
    @Resource
    private TaskService taskService;
    @Resource
    private ReportPictureService reportPictureService;
    @Resource
    private IncidentService incidentService;
    @Resource
    private ReportMapper reportMapper;
    @Resource
    private CompanyUserService companyUserService;
    @Resource
    private CompanyConstructionSiteService companyConstructionSiteService;


    public Integer addNewReport(Integer siteId) {
        Report report = new Report();
        report.setConstructionSite(constructionSiteService.findConstructionSiteById(siteId));
        report.setDate(LocalDate.now());
        reportRepository.save(report);
        return report.getId();
    }

    public Report getReportById(Integer reportId) {
        return reportRepository.findById(reportId).get();
    }

    public void removeReport(Integer reportId) {
        taskService.removeTasksByReportId(reportId);
        reportPictureService.removePicturesByReportId(reportId);
        incidentService.removeByReportId(reportId);
        reportRepository.deleteById(reportId);
    }

    public ReportResultResponse getReportResult(Integer reportId) {
        ReportResultResponse result = new ReportResultResponse();
        result.setSafeSum(incidentService.countTrueIncidents(reportId, true));
        result.setNotSafeSum(incidentService.countFalseIncidents(reportId, false));
        Integer x = result.getSafeSum();
        Integer y = result.getNotSafeSum();
        Double tomResult = (double) x / (x + y) * 100;
        result.setTom(BigDecimal.valueOf(tomResult));
        BigDecimal resultTom = result.getTom();
        Report report = reportRepository.findById(reportId).get();
        report.setTom(resultTom);
        reportRepository.save(report);
        return result;

    }

    public List<ReportResponse> searchReports(FindReportRequest findReportRequest) {
        Report report = reportMapper.requestToReport(findReportRequest);
        List<Report> reports = reportRepository.reportSearch(report.getId(), report.getConstructionSite().getName(), report.getDate());
        return reportMapper.reportToResponses(reports);
    }

    public List<ReportResponse> findAllReports(Integer userId) {
        List<Integer> companyUserIds = companyUserService.getUserCompanyIdsByUserIds(userId);
        List<ConstructionSite> constructionSites = companyConstructionSiteService.
                getConstructionSitesByUserCompanyIds(companyUserIds);
        List<ReportResponse> reportResponses = new ArrayList<>();
        for (ConstructionSite constructionSite : constructionSites) {
            List<Report> reportsByConstructionSiteId = reportRepository.findReportsByConstructionSiteId(constructionSite.getId());
            List<ReportResponse> reportResponses1 = reportMapper.reportToResponses(reportsByConstructionSiteId);
            for (ReportResponse reportResponse : reportResponses1) {
                ReportResponse response = new ReportResponse();
                response.setReportId(reportResponse.getReportId());
                response.setConstructionSiteName(reportResponse.getConstructionSiteName());
                response.setDate(reportResponse.getDate());
                response.setTom(reportResponse.getTom());
                reportResponses.add(response);
            }
            }
        Comparator<ReportResponse> reverseComparator = (c1, c2) -> Math.toIntExact(c2.getDate().compareTo(c1.getDate()));
        reportResponses.sort(reverseComparator);
        return reportResponses;
    }
}
