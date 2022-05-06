package com.example.digitom.service.inspection;

import com.example.digitom.domain.companyconstructionsite.CompanyConstructionSiteService;
import com.example.digitom.domain.companyuser.CompanyUserService;
import com.example.digitom.domain.constructionsite.ConstructionSite;
import com.example.digitom.domain.incident.IncidentService;
import com.example.digitom.domain.report.ReportService;
import com.example.digitom.domain.reportpicture.ReportPictureService;
import com.example.digitom.domain.task.Task;
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
    @Resource
    private ReportService reportService;


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

    public Integer addNewTask(TaskRequest taskRequest) {
       return taskService.addNewTask(taskRequest);
    }

    public Integer incidentCounter(IncidentCounterRequest incidentCounterResponse) {
        return incidentService.incidentCounter(incidentCounterResponse);
    }

    public void removeTrueIncident(IncidentCounterRequest incidentCounterResponse) {
        incidentService.removeTrueIncident(incidentCounterResponse);
    }

    public void addNewReportPicture(ReportPictureRequest reportPictureRequest) {
        reportPictureService.addNewReportPicture(reportPictureRequest);
    }

    public void removeReport(Integer reportId) {
        reportService.removeReport(reportId);
    }

    public List<RemoveFalseIncidentList> getRemoveFalseIncidentList(IncidentCounterRequest incidentCounterRequest) {
        List<Task> tasks = taskService.findByReportIdAndSafetyFieldIdAndSafe(incidentCounterRequest);
        List<RemoveFalseIncidentList> responseList = new ArrayList<>();
        for (Task task : tasks) {
            RemoveFalseIncidentList removeFalseIncidentList = new RemoveFalseIncidentList();
            removeFalseIncidentList.setTaskId(task.getId());
            removeFalseIncidentList.setDescription(task.getDescription());
            removeFalseIncidentList.setCompanyName(task.getCompany().getName());
            removeFalseIncidentList.setDeadline(task.getDeadline());
            responseList.add(removeFalseIncidentList);
        }
        return responseList;
    }

    public void removeFalseIncident(Integer taskId) {
        reportPictureService.removeByTaskId(taskId);
        Integer incidentId = taskService.findIncidentIdByTaskId(taskId);
        taskService.removeTaskByTaskId(taskId);
        incidentService.removeById(incidentId);
    }
}

