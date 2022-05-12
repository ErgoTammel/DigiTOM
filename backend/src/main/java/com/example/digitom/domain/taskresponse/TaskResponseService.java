package com.example.digitom.domain.taskresponse;

import com.example.digitom.domain.taskresponsepicture.TaskResponsePictureService;
import com.example.digitom.service.reportmanagement.TaskResponseRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TaskResponseService {

    @Resource
    private TaskResponseMapper taskResponseMapper;
    @Resource
    private TaskResponseRepository taskResponseRepository;
    @Resource
    private TaskResponsePictureService taskResponsePictureService;

    public Integer addTaskResponse(TaskResponseRequest taskResponseRequest) {
        TaskResponse taskResponse = taskResponseMapper.requestToTaskResponse(taskResponseRequest);
        taskResponseRepository.save(taskResponse);
        return taskResponse.getId();
    }

    public TaskResponseDto getTaskResponseInformation(Integer taskId) {
        TaskResponse taskResponse = taskResponseRepository.findTaskResponseByTaskId(taskId);
        TaskResponseDto taskResponseDto = taskResponseMapper.toDto(taskResponse);
        taskResponseDto.setBase64(taskResponsePictureService.findByTaskResponseId(taskResponse.getId()));
        return taskResponseDto;
    }
}
