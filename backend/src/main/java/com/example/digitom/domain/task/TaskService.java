package com.example.digitom.domain.task;

import com.example.digitom.domain.report.Report;
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
}
