package com.example.digitom.domain.task;

import com.example.digitom.domain.report.ReportRepository;
import com.example.digitom.domain.safetyfield.SafetyFieldRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TaskService {

    @Resource
    private ReportRepository reportRepository;

    @Resource
    private SafetyFieldRepository safetyFieldRepository;

    @Resource
    private TaskRepository taskRepository;

    @Resource
    private TaskMapper taskMapper;

    public void addNewTask(Integer safetyFiledId, Integer reportId, TaskRequest taskRequest) {
        Task task = taskMapper.taskRequestToTask(taskRequest);
        task.setSafetyField(safetyFieldRepository.findById(safetyFiledId).get());
        task.setReport(reportRepository.findById(reportId).get());

        task.setDescription(taskRequest.getDescription());
        task.setDeadline(taskRequest.getDeadline());
        taskRepository.save(task);

    }

}
