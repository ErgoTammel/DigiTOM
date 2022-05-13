package com.example.digitom.service.image;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Resource
    private ImageService imageService;

    @PostMapping("/add")
    @Operation(summary = "Add new picture to the task")
    public void addReportPicture(@RequestBody ReportPictureRequest reportPictureRequest) {
        imageService.addNewReportPicture(reportPictureRequest);
    }

    @GetMapping("/task")
    @Operation(summary = "Show task picture")
    public byte[] getTaskPicture(@RequestParam Integer taskId) {
       return imageService.getTaskPicture(taskId);
    }

    @PostMapping("/response/add")
    @Operation(summary = "Add a new picture to the response")
    public void addTaskResponsePicture(@RequestBody TaskPictureRequest taskPictureRequest) {
        imageService.addNewTaskResponsePicture(taskPictureRequest);
    }

}
