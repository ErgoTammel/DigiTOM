package com.example.digitom.domain.task;

import com.example.digitom.domain.companyconstructionsite.CompanyConstructionSite;
import com.example.digitom.domain.companyconstructionsite.CompanyConstructionSiteService;
import com.example.digitom.domain.companyuser.CompanyUserService;
import com.example.digitom.service.inspection.IncidentCounterRequest;
import com.example.digitom.service.inspection.ReportOverviewResponse;
import com.example.digitom.service.inspection.reportmanagement.TaskOverviewResponse;
import com.example.digitom.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Resource
    private TaskMapper taskMapper;
    @Resource
    private TaskRepository taskRepository;
    @Resource
    private ValidationService validationService;
    @Resource
    private CompanyUserService companyUserService;
    @Resource
    private CompanyConstructionSiteService companyConstructionSiteService;


    public Integer addNewTask(TaskRequest taskRequest) {

        validationService.taskCompanyExists(taskRequest.getCompanyId());
        validationService.checkFormCompletion(taskRequest.getDescription());
        validationService.taskDeadlineExists(taskRequest.getDeadline());
        Task task = taskMapper.taskRequestToTask(taskRequest);
        taskRepository.save(task);
        return task.getId();
    }

    public void removeTasksByReportId(Integer reportId) {
        taskRepository.deleteAll(taskRepository.findByReportId(reportId));
    }

    public List<Task> findByReportIdAndSafetyFieldIdAndSafe(IncidentCounterRequest incidentCounterRequest) {
        return taskRepository.findByReportIdAndSafetyFieldIdAndSafe(
                incidentCounterRequest.getReportId(), incidentCounterRequest.getSafetyFieldId(),
                incidentCounterRequest.getSafe());
    }


    public void removeTaskByTaskId(Integer taskId) {
        taskRepository.deleteById(taskId);
    }

    public Integer findIncidentIdByTaskId(Integer taskId) {
        Task task = taskRepository.getById(taskId);
        return task.getIncident().getId();
    }

    public List<Task> getTasksByReportId(Integer reportId) {
        return taskRepository.findByReportId(reportId);
    }

    public List<ReportOverviewResponse> toResponses(List<Task> tasks) {
        return taskMapper.taskToReportOverviewResponses(tasks);
    }

    public List<TaskOverviewResponse> getOpenTasksByUserId(Integer userId) {

        List<Integer> companyIds = companyUserService.getCompanyIdsByUserId(userId);
        List<TaskOverviewResponse> responses = new ArrayList<>();
        for (Integer companyId : companyIds) {
            List<Task> tasksByCompanyId = taskRepository.findByCompanyId(companyId, false);
            for (Task task : tasksByCompanyId) {
                TaskOverviewResponse taskOverviewResponse = new TaskOverviewResponse();
                taskOverviewResponse.setConstructionSiteName(task.getReport().getConstructionSite().getName());
                taskOverviewResponse.setTaskId(task.getId());
                CompanyConstructionSite mainContractor = companyConstructionSiteService.findMainContractor(
                        task.getReport().getConstructionSite().getId());
                taskOverviewResponse.setMainContractorName(mainContractor.getCompany().getName());
                taskOverviewResponse.setDescription(task.getDescription());
                taskOverviewResponse.setDeadline(task.getDeadline());
                responses.add(taskOverviewResponse);
            }
        }
        return responses;

    }

    public String getTaskDescription(Integer taskId) {
        return taskRepository.findById(taskId).get().getDescription();
    }

//    public void changeTaskStatus(Integer taskId) {
//        taskRepository.
//    }
}
