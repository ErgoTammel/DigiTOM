package com.example.digitom.service.image;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
public class ImageController {

    private ImageService imageService;

    public void addReportPicture(@RequestBody ReportPictureRequest reportPictureRequest) {
        imageService.addNewReportPicture(reportPictureRequest);
    }

}
