package com.example.digitom.domain.report;

import com.example.digitom.domain.companyconstructionsite.CompanyConstructionSite;
import com.example.digitom.domain.companyconstructionsite.CompanyConstructionSiteService;
import com.example.digitom.domain.companyuser.CompanyUserService;
import com.example.digitom.domain.constructionsite.ConstructionSite;
import com.example.digitom.domain.constructionsite.ConstructionSiteService;
import com.example.digitom.domain.contact.ContactService;
import com.example.digitom.domain.incident.IncidentService;
import com.example.digitom.domain.reportpicture.ReportPictureService;
import com.example.digitom.domain.task.TaskService;
import com.example.digitom.service.account.inspection.ReportResultResponse;
import com.example.digitom.service.reportmanagement.FindReportRequest;
import com.example.digitom.service.reportmanagement.ReportResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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
    @Resource
    private ContactService contactService;


    public Integer addNewReport(Integer siteId, Integer userId) {
        Report report = new Report();
        report.setConstructionSite(constructionSiteService.findConstructionSiteById(siteId));
        report.setDate(LocalDate.now());
        report.setInspectorId(userId);
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
        result.setSafeSum(incidentService.countIncidents(reportId, true));
        result.setNotSafeSum(incidentService.countIncidents(reportId, false));
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

            CompanyConstructionSite mainContractor = companyConstructionSiteService.findMainContractor(constructionSite.getId());

            for (ReportResponse reportResponse : reportResponses1) {
                ReportResponse response = new ReportResponse();
                response.setReportId(reportResponse.getReportId());
                response.setConstructionSiteName(reportResponse.getConstructionSiteName());
                response.setDate(reportResponse.getDate());
                response.setTom(reportResponse.getTom());
                response.setMainContractorName(mainContractor.getCompany().getName());
                reportResponses.add(response);
            }
        }
        Comparator<ReportResponse> reverseComparator = (c1, c2) -> Math.toIntExact(c2.getReportId().compareTo(c1.getReportId()));
        reportResponses.sort(reverseComparator);
        return reportResponses;
    }

    public List<ReportResponse> getLastReports(Integer userId) {
        List<ReportResponse> allReports = findAllReports(userId);
        return allReports.subList(0, 5);
    }

    public List<ReportResponse> getInspectorReports(Integer inspectorId) {
        List<Report> inspectorReports = reportRepository.getInspectorReports(inspectorId);
        List<ReportResponse> responses = new ArrayList<>();
        for (Report inspectorReport : inspectorReports) {
            ReportResponse response = new ReportResponse();
            response.setReportId(inspectorReport.getId());
            response.setMainContractorName(companyConstructionSiteService.findMainContractor(
                    inspectorReport.getConstructionSite().getId()).getCompany().getName());
            response.setConstructionSiteName(inspectorReport.getConstructionSite().getName());
            response.setInspectorName(contactService.findName(inspectorId));
            response.setDate(inspectorReport.getDate());
            response.setTom(inspectorReport.getTom());
            responses.add(response);
        }
        return responses;
    }

    public List<Report> getReportsByInspectorId(Integer userId) {
        return reportRepository.getReportsByInspectorId(userId);
    }
}
