package com.example.digitom.domain.taskresponsepicture;

import com.example.digitom.domain.taskresponse.TaskResponse;
import com.example.digitom.domain.taskresponse.TaskResponseService;
import com.example.digitom.service.image.TaskPictureRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;


@Service
public class TaskResponsePictureService {

    @Resource
    private TaskResponsePictureRepository taskResponsePictureRepository;
    @Resource
    private TaskResponseService taskResponseService;

    public void addNewTaskResponsePicture(TaskPictureRequest taskPictureRequest) {
        byte[] base64 = taskPictureRequest.getBase64().getBytes(StandardCharsets.UTF_8);
        TaskResponsePicture taskResponsePicture = new TaskResponsePicture();
        taskResponsePicture.setBase64(base64);
        TaskResponse result = taskResponseService.findTaskResponseByTaskId(taskPictureRequest.getTaskId());
        taskResponsePicture.setTaskResponse(result);
        taskResponsePictureRepository.save(taskResponsePicture);
    }

    public byte[] findByTaskResponseId(Integer id) {
        TaskResponsePicture taskResponsePicture = taskResponsePictureRepository.findByTaskResponse_Id(id).get();
        return taskResponsePicture.getBase64();
    }

    public byte[] getTaskResponsePicture(Integer taskId) {
        TaskResponsePicture taskResponsePicture = taskResponsePictureRepository.findByTaskId(taskId);
        return taskResponsePicture.getBase64();
    }
}

