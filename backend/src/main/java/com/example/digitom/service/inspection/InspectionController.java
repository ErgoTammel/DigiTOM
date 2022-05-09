package com.example.digitom.service.inspection;

import com.example.digitom.domain.task.TaskRequest;
import com.example.digitom.service.image.ReportPictureRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/inspection")
public class InspectionController {

    @Resource
    private InspectionService inspectionService;


    @GetMapping("/sites")
    @Operation(summary = "Get all user's construction sites")
    public List<NewInspectionConstructionSiteResponse> getConstructionSites(@RequestParam Integer userId) {
        return inspectionService.getConstructionSites(userId);
    }

    @PostMapping("/incident/new")
    @Operation(summary = "Add new incident into report")
    public Integer addNewIncident(@RequestBody IncidentRequest incidentRequest) {
        return inspectionService.addNewIncident(incidentRequest);
    }

    @PostMapping("/task/new")
    @Operation(summary = "Add new task into report")
    public Integer addNewTask(@RequestBody TaskRequest taskRequest) {
        return inspectionService.addNewTask(taskRequest);
    }

    @PostMapping("/counter/incident")
    @Operation(summary = "Get the number of incidents")
    public Integer incidentCounter(@RequestBody IncidentCounterRequest incidentCounterRequest) {
        return inspectionService.incidentCounter(incidentCounterRequest);
    }

    @DeleteMapping("/counter/incident")
    @Operation(summary = "Delete the TRUE incident")
    public void removeTrueIncident(@RequestBody IncidentCounterRequest incidentCounterRequest) {
        inspectionService.removeTrueIncident(incidentCounterRequest);
    }

    @PostMapping("/new/picture")
    @Operation(summary = "Add new picture to the report and task")
    public void addNewReportPicture(@RequestBody ReportPictureRequest reportPictureRequest) {
        inspectionService.addNewReportPicture(reportPictureRequest);
    }

    @DeleteMapping("/report")
    @Operation(summary = "Delete the report")
    public void removeReport(@RequestParam Integer reportId) {
        inspectionService.removeReport(reportId);
    }

    @PostMapping("/incident/false")
    @Operation(summary = "Show the report's tasks list")
    public List<RemoveFalseIncidentList> getRemoveFalseIncidentList(@RequestBody IncidentCounterRequest incidentCounterRequest) {
        return inspectionService.getRemoveFalseIncidentList(incidentCounterRequest);
    }

    @DeleteMapping("/incident")
    @Operation(summary = "Delete the FALSE incident")
    public void removeFalseIncident(@RequestParam Integer taskId) {
        inspectionService.removeFalseIncident(taskId);
    }

    @PostMapping("/report/overview")
    @Operation(summary = "Get all tasks information for report overview")
    public List<ReportOverviewResponse> getReportOverview(@RequestParam Integer reportId) {
        return inspectionService.getReportOverview(reportId);
    }

    @GetMapping("/report/result")
    @Operation(summary = "Get report result TOM")
    public ReportResultResponse getReportResult(@RequestParam Integer reportId) {
        return inspectionService.getReportResult(reportId);
    }

}