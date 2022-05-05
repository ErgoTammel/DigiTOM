package com.example.digitom.domain.reportpicture;

import com.example.digitom.service.image.ReportPictureRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Service
public class ReportPictureService {

    @Resource
    private ReportPictureRepository reportPictureRepository;

    public void addNewReportPicture(ReportPictureRequest reportPictureRequest) {
        byte[] base64 = reportPictureRequest.getBase64().getBytes(StandardCharsets.UTF_8);
        ReportPicture reportPicture = new ReportPicture();
        reportPicture.setBase64(base64);
        reportPictureRepository.save(reportPicture);
    }
}
