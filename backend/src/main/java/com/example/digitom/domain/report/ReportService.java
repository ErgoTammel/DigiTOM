package com.example.digitom.domain.report;

import com.example.digitom.domain.constructionsite.ConstructionSite;
import com.example.digitom.domain.constructionsite.ConstructionSiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

@Service
public class ReportService {

    @Resource
    private ConstructionSiteService constructionSiteService;

    @Resource
    private ReportRepository reportRepository;

    public Integer addNewReport(Integer siteId) {
        Report report = new Report();
        report.setConstructionSite(constructionSiteService.findConstructionSiteById(siteId));
        report.setDate(LocalDate.now());
        reportRepository.save(report);
        return report.getId();
    }
}
