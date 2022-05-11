package com.example.digitom.service.image;

import com.example.digitom.domain.reportpicture.ReportPictureService;
import com.example.digitom.domain.taskresponsepicture.TaskResponsePictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ImageService {

    @Resource
    private ReportPictureService reportPictureService;
    @Resource
    private TaskResponsePictureService taskResponsePictureService;

    public void addNewReportPicture(ReportPictureRequest reportPictureRequest) {
        reportPictureService.addNewReportPicture(reportPictureRequest);
    }

    public byte[] getTaskPicture(Integer taskId) {
        return reportPictureService.getTaskPicture(taskId);
    }

    public void addNewTaskResponsePicture(TaskPictureRequest taskPictureRequest) {
        taskResponsePictureService.addNewTaskResponsePicture(taskPictureRequest);
    }
}



