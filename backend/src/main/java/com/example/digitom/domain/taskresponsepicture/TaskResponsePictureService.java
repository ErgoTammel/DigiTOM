package com.example.digitom.domain.taskresponsepicture;

import com.example.digitom.service.image.TaskPictureRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.Optional;


@Service
public class TaskResponsePictureService {

    @Resource
    private TaskResponsePictureMapper taskResponsePictureMapper;

    @Resource
    private TaskResponsePictureRepository taskResponsePictureRepository;

    public void addNewTaskResponsePicture(TaskPictureRequest taskPictureRequest) {
        byte[] base64 = taskPictureRequest.getBase64().getBytes(StandardCharsets.UTF_8);
        TaskResponsePicture taskResponsePicture = taskResponsePictureMapper.requestToTaskResponsePicture(taskPictureRequest);
        taskResponsePicture.setBase64(base64);
        taskResponsePictureRepository.save(taskResponsePicture);
    }

    public byte[] findByTaskResponseId(Integer id) {
        TaskResponsePicture taskResponsePicture = taskResponsePictureRepository.findByTaskResponse_Id(id).get();
        return taskResponsePicture.getBase64();
    }
}
