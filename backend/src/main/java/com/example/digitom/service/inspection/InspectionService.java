package com.example.digitom.service.inspection;

import com.example.digitom.domain.companyconstructionsite.CompanyConstructionSiteService;
import com.example.digitom.domain.companyuser.CompanyUserService;
import com.example.digitom.domain.constructionsite.ConstructionSite;
import com.example.digitom.domain.incident.IncidentService;
import com.example.digitom.domain.reportpicture.ReportPictureService;
import com.example.digitom.domain.task.TaskRequest;
import com.example.digitom.domain.task.TaskService;
import com.example.digitom.service.image.ReportPictureRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class InspectionService {

    @Resource
    private CompanyUserService companyUserService;
    @Resource
    private CompanyConstructionSiteService companyConstructionSiteService;
    @Resource
    private IncidentService incidentService;
    @Resource
    private TaskService taskService;
    @Resource
    private ReportPictureService reportPictureService;


    public List<NewInspectionConstructionSiteResponse> getConstructionSites(Integer userId) {
        List<NewInspectionConstructionSiteResponse> responses = new ArrayList<>();
        List<Integer> allUserCompanyIds = companyUserService.getUserCompanyIdsByUserIds(userId);
        List<ConstructionSite> companyConstructionSites = companyConstructionSiteService.getConstructionSitesByUserCompanyIds(allUserCompanyIds);
        for (ConstructionSite companyConstructionSite : companyConstructionSites) {
            NewInspectionConstructionSiteResponse response = new NewInspectionConstructionSiteResponse();
            response.setConstructionSiteId(companyConstructionSite.getId());
            response.setConstructionSiteName(companyConstructionSite.getName());
            responses.add(response);
        }
        return responses;
    }

    public Integer addNewIncident(IncidentRequest incidentRequest) {
        return incidentService.addNewIncident(incidentRequest);
    }

    public void addNewTask(TaskRequest taskRequest) {
        taskService.addNewTask(taskRequest);
    }

    public Integer incidentCounter(IncidentCounterResponse incidentCounterResponse) {
        return incidentService.incidentCounter(incidentCounterResponse);
    }

    public void removeTrueIncident(IncidentCounterResponse incidentCounterResponse) {
        incidentService.removeTrueIncident(incidentCounterResponse);
    }


    public void addNewReportPicture(ReportPictureRequest reportPictureRequest) {
        reportPictureService.addNewReportPicture(reportPictureRequest);
    }
}

