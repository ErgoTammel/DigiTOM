package com.example.digitom.domain.task;

import com.example.digitom.domain.companyuser.CompanyUserService;
import com.example.digitom.service.inspection.IncidentCounterRequest;
import com.example.digitom.service.inspection.ReportOverviewResponse;
import com.example.digitom.service.reportmanagement.TaskOverviewResponse;
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


    public List<TaskOverviewResponse> getOpenTasksBySiteId(Integer constructionSiteId) {
        List<Task> tasks = taskRepository.findOpenTasksBySiteId(constructionSiteId, false);
        List<TaskOverviewResponse> responses = new ArrayList<>();
        for (Task task : tasks) {
            TaskOverviewResponse taskResponse = new TaskOverviewResponse();
            taskResponse.setConstructionSiteName(task.getReport().getConstructionSite().getName());
            taskResponse.setDeadline(task.getDeadline());
            taskResponse.setDescription(task.getDescription());
            taskResponse.setCompanyName(task.getCompany().getName());
            responses.add(taskResponse);
        }
        return responses;
    }

    public List<TaskOverviewResponse> getOpenTasksByUserId(Integer userId) {

        List<Integer> companyIds = companyUserService.getUserCompanyIdsByUserIds(userId);
        List<TaskOverviewResponse> responses = new ArrayList<>();
        for (Integer companyId : companyIds) {
            List<Task> tasksByCompanyId = taskRepository.findByCompanyId(companyId, false);
            for (Task task : tasksByCompanyId) {
                TaskOverviewResponse taskOverviewResponse = new TaskOverviewResponse();
                taskOverviewResponse.setConstructionSiteName(task.getReport().getConstructionSite().getName());
                taskOverviewResponse.setTaskId(task.getId());
                taskOverviewResponse.setCompanyName(task.getCompany().getName());
                taskOverviewResponse.setDescription(task.getDescription());
                taskOverviewResponse.setDeadline(task.getDeadline());
                responses.add(taskOverviewResponse);
            }
        }
        return responses;

    }
}
