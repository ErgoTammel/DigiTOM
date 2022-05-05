package com.example.digitom.service.image;

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
    public void addReportPicture(@RequestBody ReportPictureRequest reportPictureRequest) {
        imageService.addNewReportPicture(reportPictureRequest);
    }

}
