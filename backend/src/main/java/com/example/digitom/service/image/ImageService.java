package com.example.digitom.service.image;

import com.example.digitom.domain.reportpicture.ReportPictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ImageService {

    @Resource
    private ReportPictureService reportPictureService;

    public void addNewReportPicture(ReportPictureRequest reportPictureRequest) {
        reportPictureService.addNewReportPicture(reportPictureRequest);


    }

}
