package com.example.digitom.domain.reportpicture;

import com.example.digitom.service.image.ReportPictureRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Service
public class ReportPictureService {

    @Resource
    private ReportPictureRepository reportPictureRepository;

    @Resource
    private ReportPictureMapper reportPictureMapper;

    public void addNewReportPicture(ReportPictureRequest reportPictureRequest) {
        byte[] base64 = reportPictureRequest.getBase64().getBytes(StandardCharsets.UTF_8);
        ReportPicture reportPicture = reportPictureMapper.requestToReportPicture(reportPictureRequest);
        reportPicture.setBase64(base64);
        reportPictureRepository.save(reportPicture);
    }

    public void removePicturesByReportId(Integer reportId) {
        reportPictureRepository.deleteAll(reportPictureRepository.findByReportId(reportId));
    }

    public void removeByTaskId(Integer taskId) {

        ReportPicture picture = reportPictureRepository.findByTaskId(taskId);
        reportPictureRepository.delete(picture);

    }
}
