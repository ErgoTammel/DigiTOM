package com.example.digitom.domain.taskresponse;

import com.example.digitom.service.reportmanagement.TaskResponseRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;

@Service
public class TaskResponseService {

    @Resource
    private TaskResponseMapper taskResponseMapper;
    @Resource
    private TaskResponseRepository taskResponseRepository;

    public void addTaskResponse(TaskResponseRequest taskResponseRequest) {
        TaskResponse taskResponse = taskResponseMapper.requestToTaskResponse(taskResponseRequest);
        taskResponse.setTime(Instant.now());
        taskResponseRepository.save(taskResponse);
    }

    public String getTaskResponseInformation(Integer taskId) {
        TaskResponse taskResponse = taskResponseRepository.findTaskResponseByTaskId(taskId);
        return taskResponse.getDescription();
    }

    public TaskResponse findTaskResponseByTaskId(Integer taskId) {
        return taskResponseRepository.findTaskResponseByTaskId(taskId);
    }

    public void deleteTaskResponse (Integer responseId ) {
        TaskResponse taskResponse = taskResponseRepository.findById(responseId).get();
        taskResponseRepository.delete(taskResponse);
    }


    public Boolean existsByTaskId(Integer taskId) {
       return taskResponseRepository.existsByTaskId(taskId);

    }
}
