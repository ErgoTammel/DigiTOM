package com.example.digitom.service.reportmanagement;

import com.example.digitom.domain.report.ReportService;
import com.example.digitom.domain.task.TaskService;
import com.example.digitom.domain.taskresponse.TaskResponseDto;
import com.example.digitom.domain.taskresponse.TaskResponseService;
import com.example.digitom.domain.taskresponsepicture.TaskResponsePictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InspectionResponseService {

    @Resource
    private TaskResponseService taskResponseService;
    @Resource
    private TaskService taskService;
    @Resource
    private ReportService reportService;
    @Resource
    private TaskResponsePictureService taskResponsePictureService;


    public void addTaskResponse(TaskResponseRequest taskResponseRequest) {
        taskResponseService.addTaskResponse(taskResponseRequest);
    }

//    public List<TaskOverviewResponse> getOpenTasksBySiteId(Integer constructionSiteId) {
//        return taskService.getOpenTasksBySiteId(constructionSiteId);
//    }

    public List<ReportResponse> searchReports(FindReportRequest findReportRequest) {
        return reportService.searchReports(findReportRequest);
    }

    public List<TaskOverviewResponse> getOpenTasksByUserId(Integer userId) {
        return taskService.getOpenTasksByUserId(userId);
    }

    public List<ReportResponse> findAllReports(Integer userId) {
        return reportService.findAllReports(userId);
    }

    public List<ReportResponse> getLastReports(Integer userId) {
        return reportService.getLastReports(userId);
    }

    public String getTaskResponseInformation(Integer taskId) {
        return taskResponseService.getTaskResponseInformation(taskId);
    }

    public String getTaskDescription(Integer taskId) {
        return taskService.getTaskDescription(taskId);
    }

    public List<ReportResponse> getInspectorLastReports(Integer inspectorId) {
        return reportService.getInspectorReports(inspectorId);
    }

    public void changeTaskStatus(Integer taskId) {
        taskService.changeTaskStatus(taskId);
    }

    public void deleteTaskResponse(Integer taskId) {
        taskResponsePictureService.deleteTaskResponsePicture(taskId);
        taskResponseService.deleteTaskResponse(taskId);
    }

    public byte[] getTaskResponsePicture(Integer taskId) {
        return taskResponsePictureService.getTaskResponsePicture(taskId);
    }

    public void taskResponseExists(Integer taskId) {
        taskResponseService.taskResponseExists(taskId);
    }

    public void isTaskResponseValid(String description) {
        taskResponseService.isTaskResponseValid(description);
    }

    public void ifTaskResponseNotExists(Integer taskId) {
        taskResponseService.ifTaskResponseNotExists(taskId);
    }
}