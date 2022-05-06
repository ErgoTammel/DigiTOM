package com.example.digitom.domain.report;

import com.example.digitom.domain.constructionsite.ConstructionSiteService;
import com.example.digitom.domain.incident.IncidentService;
import com.example.digitom.domain.reportpicture.ReportPictureService;
import com.example.digitom.domain.task.TaskService;
import com.example.digitom.service.inspection.ReportResultResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

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
        incidentService.countAllIncidents(reportId);

        return null;
    }
}
