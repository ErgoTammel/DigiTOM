package com.example.digitom.domain.task;

import com.example.digitom.service.inspection.IncidentCounterRequest;
import com.example.digitom.service.inspection.ReportOverviewResponse;
import com.example.digitom.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskService {

    @Resource
    private TaskMapper taskMapper;
    @Resource
    private TaskRepository taskRepository;
    @Resource
    private ValidationService validationService;


    public Integer addNewTask(TaskRequest taskRequest) {

        validationService.taskCompanyExists(taskRequest.getCompanyId());
        validationService.taskDescriptionExists(taskRequest.getDescription());
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


}
