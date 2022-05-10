package com.example.digitom.domain.taskresponsepicture;


import com.example.digitom.service.image.TaskPictureRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/picture/response")

@RestController
public class TaskResponsePictureController {

    @Resource
    private TaskResponsePictureService taskResponsePictureService;

    @PostMapping("/add")
    @Operation(summary = "Add a new picture to the response")
    public void addTaskResponsePicture(@RequestBody TaskPictureRequest taskPictureRequest) {
        taskResponsePictureService.addNewTaskResponsePicture(taskPictureRequest);
    }

}
