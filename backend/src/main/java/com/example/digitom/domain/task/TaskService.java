package com.example.digitom.domain.task;

import com.example.digitom.service.inspection.IncidentCounterRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskService {

    @Resource
    private TaskMapper taskMapper;
    @Resource
    private TaskRepository taskRepository;


    public Integer addNewTask(TaskRequest taskRequest) {
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
        Task task  = taskRepository.getById(taskId);
        return task.getIncident().getId();
    }
}
