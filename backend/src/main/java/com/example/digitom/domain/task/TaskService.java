package com.example.digitom.domain.task;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
