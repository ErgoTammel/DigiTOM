package com.example.digitom.domain.taskresponse;

import com.example.digitom.domain.taskresponsepicture.TaskResponsePictureService;
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
    @Resource
    private TaskResponsePictureService taskResponsePictureService;

    public void addTaskResponse(TaskResponseRequest taskResponseRequest) {
        TaskResponse taskResponse = taskResponseMapper.requestToTaskResponse(taskResponseRequest);
        taskResponse.setTime(Instant.now());
        taskResponseRepository.save(taskResponse);
    }

    public TaskResponseDto getTaskResponseInformation(Integer taskId) {
        TaskResponse taskResponse = taskResponseRepository.findTaskResponseByTaskId(taskId);
        TaskResponseDto taskResponseDto = taskResponseMapper.toDto(taskResponse);
        taskResponseDto.setBase64(taskResponsePictureService.findByTaskResponseId(taskResponse.getId()));
        return taskResponseDto;
    }
}
