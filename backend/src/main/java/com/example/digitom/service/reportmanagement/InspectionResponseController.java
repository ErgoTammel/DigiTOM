package com.example.digitom.service.reportmanagement;

import com.example.digitom.domain.taskresponse.TaskResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/response")
public class InspectionResponseController {

    @Resource
    private InspectionResponseService inspectionResponseService;

    @PostMapping("/add")
    @Operation(summary = "Add new task response")
    public void addTaskResponse(@RequestBody TaskResponseRequest taskResponseRequest) {
        inspectionResponseService.addTaskResponse(taskResponseRequest);
    }
//
//    @GetMapping("/get/list")
//    @Operation(summary = "Get open tasks list by site ID")
//    public List<TaskOverviewResponse> getOpenTasksBySiteId(@RequestParam Integer constructionSiteId) {
//        return inspectionResponseService.getOpenTasksBySiteId(constructionSiteId);
//    }

    @GetMapping("/get/by/userid")
    @Operation(summary = "Get open tasks list by user ID")
    public List<TaskOverviewResponse> getOpenTasksByUserId(@RequestParam Integer userId) {
        return inspectionResponseService.getOpenTasksByUserId(userId);
    }

    @PostMapping("/report/search")
    @Operation(summary = "Search reports")
    public List<ReportResponse> searchReports(@RequestBody FindReportRequest findReportRequest) {
        return inspectionResponseService.searchReports(findReportRequest);
    }

    @GetMapping("/report/search/userid")
    @Operation(summary = "Show reports list")
    public List<ReportResponse> findAllReports(@RequestParam Integer userId) {
        return inspectionResponseService.findAllReports(userId);
    }

    @GetMapping("/report/last")
    @Operation(summary = "Show 5 last reports")
    public List<ReportResponse> getLastReports(@RequestParam Integer userId) {
        return inspectionResponseService.getLastReports(userId);
    }

    @GetMapping("/show/description")
    @Operation(summary = "Show task description")
    public String getTaskDescription(@RequestParam Integer taskId) {
        return inspectionResponseService.getTaskDescription(taskId);
    }

    @GetMapping("/raport/last")
    @Operation(summary = "Show last reports for inspector")
    public List<ReportResponse> getInspectorLastReports(@RequestParam Integer inspectorId) {
        return inspectionResponseService.getInspectorLastReports(inspectorId);
    }

    @GetMapping("/task/response")
    @Operation(summary = "Get task response information")
    public TaskResponseDto getTaskResponseInformation(@RequestParam Integer taskId) {
        return inspectionResponseService.getTaskResponseInformation(taskId);
    }

    @PutMapping("/task/done")
    @Operation(summary = "Mark task status as DONE")
    public void changeTaskStatus(@RequestParam Integer taskId) {
        inspectionResponseService.changeTaskStatus(taskId);
    }


}
