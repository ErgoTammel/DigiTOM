package com.example.digitom.domain.task;

import com.example.digitom.domain.companyuser.CompanyUserService;
import com.example.digitom.service.constractionsitemanagement.CompanyNameResponse;
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
        List<CompanyNameResponse> userCompanies = companyUserService.getCompanyListByUserId(userId);
        List<TaskOverviewResponse> tasks = new ArrayList<>();
        for (CompanyNameResponse userCompany : userCompanies) {
            List<Task> companyOpenTasks = taskRepository.findByCompany_IdAndIsDone(userCompany.getCompanyId(), false);
            for (Task companyOpenTask : companyOpenTasks) {
                TaskOverviewResponse taskResponse = new TaskOverviewResponse();
                taskResponse.setTaskId(companyOpenTask.getId());
                taskResponse.setConstructionSiteName(companyOpenTask.getReport().getConstructionSite().getName());
                taskResponse.setDeadline(companyOpenTask.getDeadline());
                taskResponse.setDescription(companyOpenTask.getDescription());
                taskResponse.setCompanyName(companyOpenTask.getCompany().getName());
                tasks.add(taskResponse);
            }
        }
        return tasks;
    }
}
