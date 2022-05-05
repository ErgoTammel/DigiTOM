package com.example.digitom.domain.task;

import com.example.digitom.domain.report.Report;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TaskService {

    @Resource
    private TaskMapper taskMapper;
    @Resource
    private TaskRepository taskRepository;


    public void addNewTask(TaskRequest taskRequest) {
        Task task = taskMapper.taskRequestToTask(taskRequest);
        taskRepository.save(task);
    }

    public void removeTasksByReportId(Report report) {
        taskRepository.deleteTasksByReportId(report);
    }
}
