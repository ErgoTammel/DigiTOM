package com.example.digitom.service.image;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
